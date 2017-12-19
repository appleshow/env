package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.ComOrgMapper;
import com.aps.env.dao.ComResourceMapper;
import com.aps.env.dao.HbNodeMapper;
import com.aps.env.dao.HbTypeMapper;
import com.aps.env.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbNodeAccessServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/15</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbNodeAccessServiceImpl implements HbNodeAccessService {
    @Resource
    private ComOrgMapper comOrgMapper;
    @Resource
    private ComResourceMapper comResourceMapper;
    @Resource
    private HbTypeMapper hbTypeMapper;
    @Resource
    private HbNodeMapper hbNodeMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void refOrg(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<ComOrg> comOrgs;
        ComOrg comOrg = new ComOrg();

        comOrg.setFarOrgId(requestRefPar.getIntegerPar("farOrgId"));
        comOrgs = comOrgMapper.selectByFarOrgId(comOrg);

        responseData.setData(comOrgs);
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void refNode(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<HbType> hbTypes;
        List<HbNode> hbNodes;
        HbTypeExample hbTypeExample = new HbTypeExample();
        HbNodeExample hbNodeExample = new HbNodeExample();

        hbTypes = hbTypeMapper.selectByExample(hbTypeExample);
        hbNodes = hbNodeMapper.selectByExample(hbNodeExample);

        responseData.setData(hbNodes);
        responseData.setSubJoinResponseData(new ResponseData(hbTypes));
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void refNodeAccess(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<ComResource> comResources = new ArrayList<>();
        PageInfo<ComResource> pageInfo;
        Integer orgId = requestRefPar.getIntegerPar("orgId");

        if (orgId != null) {
            PageHelper.startPage(requestRefPar.getIntegerPar("pageNumber"), requestRefPar.getIntegerPar("pageSize"));
            comResources = comResourceMapper.selectByOrg(orgId);
            comResources.forEach(item -> item.setResourceTypeE(orgId));
        }

        pageInfo = new PageInfo<>(comResources);
        responseData.setTotalCount(pageInfo.getTotal());
        responseData.setData(comResources);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyNodeAccess(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        Date now = new Date();
        Map<String, String> rowData;
        ComResource comResource;
        boolean jsonParseException = false;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            comResource = (ComResource) JsonUtil.readValueAsObject(rowData, ComResource.class);
            if (null != comResource) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                comResource.setProperty1(null);
                comResource.setProperty2(null);
                comResource.setProperty3(null);
                if (comResource.getResourceId() == null) {
                    comResource.setResourceTypeA("NODE");
                    comResource.setItime(now);
                    comResource.setIperson(personId);
                    comResource.setUtime(now);
                    comResource.setUperson(personId);
                    comResourceMapper.insertSelective(comResource);
                } else {
                    comResource.setUtime(now);
                    comResource.setUperson(personId);
                    comResourceMapper.updateByPrimaryKeySelective(comResource);
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
