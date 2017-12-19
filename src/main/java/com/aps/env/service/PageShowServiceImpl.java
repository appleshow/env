package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.ComFormMapper;
import com.aps.env.dao.ComPageshowMapper;
import com.aps.env.entity.ComFormExample;
import com.aps.env.entity.ComPageshow;
import com.aps.env.entity.ComPageshowExample;
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
 * <dt>com.aps.env.service.ViewPageShowServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/11</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class PageShowServiceImpl implements PageShowService {
    @Resource
    private ComFormMapper comFormMapper;
    @Resource
    private ComPageshowMapper comPageshowMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referAllForms(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comForms;
        ComFormExample comFormExample = new ComFormExample();

        comFormExample.setOrderByClause("PRGROUP,FORM_ID");
        comForms = comFormMapper.selectByExample(comFormExample);

        responseData.setData(comForms);
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referPageShow(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<ComPageshow> comPageshows;
        PageInfo<ComPageshow> pageInfo;
        ComPageshowExample comPageshowExample = new ComPageshowExample();
        Integer pageId = requestRefPar.getIntegerPar("pageId");

        if (pageId != null) {
            comPageshowExample.createCriteria().andPageIdEqualTo(pageId);
        }
        comPageshowExample.setOrderByClause("PAGE_ID,COLUMN_INDEX");

        PageHelper.startPage(requestRefPar.getIntegerPar("pageNumber"), requestRefPar.getIntegerPar("pageSize"));
        comPageshows = comPageshowMapper.selectByExample(comPageshowExample);
        pageInfo = new PageInfo<>(comPageshows);

        responseData.setTotalCount(pageInfo.getTotal());
        responseData.setData(comPageshows);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyPageShow(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        ComPageshow comPageshow;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            comPageshow = (ComPageshow) JsonUtil.readValueAsObject(rowData, ComPageshow.class);
            if (null != comPageshow) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        comPageshow.setItime(now);
                        comPageshow.setIperson(personId);
                        comPageshow.setUtime(now);
                        comPageshow.setUperson(personId);
                        comPageshowMapper.insertSelective(comPageshow);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        comPageshow.setUtime(now);
                        comPageshow.setUperson(personId);
                        comPageshowMapper.updateByPrimaryKeySelective(comPageshow);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        comPageshowMapper.deleteByPrimaryKey(comPageshow);
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
