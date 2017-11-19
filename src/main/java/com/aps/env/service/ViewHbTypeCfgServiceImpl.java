package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbTypeMapper;
import com.aps.env.entity.HbType;
import com.aps.env.entity.HbTypeExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbTypeCfgServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/19</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class ViewHbTypeCfgServiceImpl implements ViewHbTypeCfgService {
    @Resource
    private HbTypeMapper hbTypeMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referHbType(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<HbType> hbTypes;
        PageInfo<HbType> pageInfo;
        HbTypeExample hbTypeExample = new HbTypeExample();

        PageHelper.startPage(requestRefPar.getIntegerPar("pageNumber"), requestRefPar.getIntegerPar("pageSize"));
        hbTypeExample.setOrderByClause("TYPE_ID");
        hbTypes = hbTypeMapper.selectByExample(hbTypeExample);
        pageInfo = new PageInfo<>(hbTypes);

        responseData.setTotalCount(pageInfo.getTotal());
        responseData.setData(hbTypes);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyHbType(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        HbType hbType;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            hbType = (HbType) JsonUtil.readValueAsObject(rowData, HbType.class);
            if (null != hbType) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        hbType.setItime(now);
                        hbType.setIperson(personId);
                        hbType.setUtime(now);
                        hbType.setUperson(personId);
                        hbTypeMapper.insertSelective(hbType);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        hbType.setUtime(now);
                        hbType.setUperson(personId);
                        hbTypeMapper.updateByPrimaryKeySelective(hbType);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        hbTypeMapper.deleteByPrimaryKey(hbType.getTypeId());

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
}
