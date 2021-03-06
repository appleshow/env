package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.ComCodeMapper;
import com.aps.env.dao.ComRegionMapper;
import com.aps.env.entity.ComCode;
import com.aps.env.entity.ComCodeExample;
import com.aps.env.entity.ComRegion;
import com.aps.env.entity.ComRegionExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewComCodeCfgServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/18</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class ComCodeCfgServiceImpl implements ComCodeCfgService {
    @Resource
    private ComCodeMapper comCodeMapper;
    @Resource
    private ComRegionMapper comRegionMapper;

    @Override
    public void refComCode(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        final List<ComCode> comCodes;
        final PageInfo<ComCode> pageInfo;
        final ComCodeExample comCodeExample = new ComCodeExample();
        final ComCodeExample.Criteria criteria = comCodeExample.createCriteria();
        String codeType = requestRefPar.getStringPar("codeType");
        String codeName = requestRefPar.getStringPar("codeName");

        if (!StringUtil.isNullOrEmpty(codeType)) {
            if (codeType.indexOf(",") > 0) {
                criteria.andCodeTypeIn(Arrays.asList(codeType.split(",")));
            } else {
                criteria.andCodeTypeEqualTo(codeType);
            }
        }
        if (!StringUtil.isNullOrEmpty(codeName)) {
            criteria.andCodeNameLike("%" + codeName + "%");
        }
        comCodeExample.setOrderByClause("CODE_TYPE,CODE_ID");

        PageHelper.startPage(requestRefPar.getIntegerPar("pageNumber"), requestRefPar.getIntegerPar("pageSize"));
        comCodes = comCodeMapper.selectByExample(comCodeExample);
        pageInfo = new PageInfo<>(comCodes);

        responseData.setTotalCount(pageInfo.getTotal());
        responseData.setData(comCodes);
    }

    @Override
    public void modifyComCode(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        ComCode comCode;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            comCode = (ComCode) JsonUtil.readValueAsObject(rowData, ComCode.class);
            if (null != comCode) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        comCode.setItime(now);
                        comCode.setIperson(personId);
                        comCode.setUtime(now);
                        comCode.setUperson(personId);
                        comCodeMapper.insertSelective(comCode);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        comCode.setUtime(now);
                        comCode.setUperson(personId);
                        comCodeMapper.updateByPrimaryKeySelective(comCode);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        comCodeMapper.deleteByPrimaryKey(comCode.getCodeId());
                        break;
                    default:
                        break;
                }
            } else {
                jsonParseException = true;
                break;
            }
        }

        if (jsonParseException) {
            responseData.setCode(-108);
            responseData.setMessage("数据处理异常，请检查输入数据！");
        } else {
            responseData.setCode(0);
        }
    }

    @Override
    public void refComRegion(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<ComRegion> comRegions;
        ComRegionExample comRegionExample = new ComRegionExample();
        String farRegionId = requestRefPar.getStringPar("farRegionId");

        if (!StringUtil.isNullOrEmpty(farRegionId)) {
            comRegionExample.createCriteria().andFarRegionIdEqualTo(farRegionId);
        }
        comRegionExample.setOrderByClause("FAR_REGION_ID,REGION_ID");
        comRegions = comRegionMapper.selectByExample(comRegionExample);

        responseData.setData(comRegions);
    }
}
