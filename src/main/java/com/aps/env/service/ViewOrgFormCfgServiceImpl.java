package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.*;
import com.aps.env.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewOrgFormCfgServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class ViewOrgFormCfgServiceImpl implements ViewOrgFormCfgService {
    @Resource
    private ComCodeMapper comCodemapper;
    @Resource
    private ComOrgMapper comOrgMapper;
    @Resource
    private ComFormMapper comFormMapper;
    @Resource
    private ComOrgFormMapper comOrgFormMapper;
    @Resource
    private ComFormRightsMapper comFormRightsMapper;
    @Resource
    private ComOrgFormRightsMapper comOrgFormRightsMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referOrg(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comOrgs;
        ComOrgExample comOrgExample = new ComOrgExample();

        comOrgs = comOrgMapper.selectByExample(comOrgExample);
        responseData.setData(comOrgs);
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referForm(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comForms;
        ComFormExample comFormExample = new ComFormExample();

        comForms = comFormMapper.selectByExample(comFormExample);
        responseData.setData(comForms);
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referOrgForm(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comOrgForms;
        Integer orgId = requestRefPar.getIntegerPar("orgId");
        Integer formId = requestRefPar.getIntegerPar("formId");
        ComOrgFormExample comOrgFormExample = new ComOrgFormExample();
        ComOrgFormExample.Criteria criteria = comOrgFormExample.createCriteria();

        if (orgId != null) {
            criteria.andOrgIdEqualTo(orgId);
        }
        if (formId != null) {
            criteria.andFormIdEqualTo(formId);
        }
        comOrgForms = comOrgFormMapper.selectByExample(comOrgFormExample);

        responseData.setData(comOrgForms);
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referFormRights(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comFormRightss;
        Integer formId = requestRefPar.getIntegerPar("formId");
        ComFormRightsExample comFormRightsExample = new ComFormRightsExample();
        ComFormRightsExample.Criteria criteria = comFormRightsExample.createCriteria();

        if (formId != null) {
            criteria.andFormIdEqualTo(formId);
        }
        comFormRightss = comFormRightsMapper.selectByExample(comFormRightsExample);

        responseData.setData(comFormRightss);
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referOrgFormRights(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comOrgFormRightss;
        Integer formId = requestRefPar.getIntegerPar("formId");
        Integer orgId = requestRefPar.getIntegerPar("orgId");
        ComOrgFormRightsExample comOrgFormRightsExample = new ComOrgFormRightsExample();
        ComOrgFormRightsExample.Criteria criteria = comOrgFormRightsExample.createCriteria();

        if (formId != null) {
            criteria.andFormIdEqualTo(formId);
        }
        if (orgId != null) {
            criteria.andOrgIdEqualTo(orgId);
        }
        comOrgFormRightss = comOrgFormRightsMapper.selectByExample(comOrgFormRightsExample);

        responseData.setData(comOrgFormRightss);
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referCombCode(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comCodes;
        ComCodeExample comCodeExample = new ComCodeExample();

        comCodeExample.createCriteria().andCodeTypeEqualTo("C0001");
        comCodes = comCodemapper.selectByExample(comCodeExample);

        responseData.setData(comCodes);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyOrgForm(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        ComOrgForm comOrgForm;
        ComOrgFormRights comOrgFormRights;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            comOrgForm = (ComOrgForm) JsonUtil.readValueAsObject(rowData, ComOrgForm.class);
            if (null != comOrgForm) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        comOrgForm.setItime(now);
                        comOrgForm.setIperson(personId);
                        comOrgForm.setUtime(now);
                        comOrgForm.setUperson(personId);
                        comOrgFormMapper.insertSelective(comOrgForm);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        comOrgFormMapper.deleteByPrimaryKey(comOrgForm);
                        comOrgFormRights = new ComOrgFormRights();

                        comOrgFormRights.setOrgId(comOrgForm.getOrgId());
                        comOrgFormRights.setFormId(comOrgForm.getFormId());

                        comOrgFormRightsMapper.deleteByPrimaryKey(comOrgFormRights);
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

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyOrgFormRights(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        ComOrgFormRights comOrgFormRights;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            comOrgFormRights = (ComOrgFormRights) JsonUtil.readValueAsObject(rowData, ComOrgFormRights.class);
            if (null != comOrgFormRights) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        comOrgFormRights.setItime(now);
                        comOrgFormRights.setIperson(personId);
                        comOrgFormRights.setUtime(now);
                        comOrgFormRights.setUperson(personId);
                        if (null == comOrgFormRights.getRea()) {
                            comOrgFormRights.setRea(0);
                        }
                        if (null == comOrgFormRights.getR1()) {
                            comOrgFormRights.setR1(0);
                        }
                        if (null == comOrgFormRights.getR2()) {
                            comOrgFormRights.setR2(0);
                        }
                        if (null == comOrgFormRights.getR3()) {
                            comOrgFormRights.setR3(0);
                        }
                        comOrgFormRightsMapper.insertSelective(comOrgFormRights);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        comOrgFormRights.setUtime(now);
                        comOrgFormRights.setUperson(personId);
                        comOrgFormRightsMapper.updateByPrimaryKeySelective(comOrgFormRights);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
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
