package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.*;
import com.aps.env.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewFormCfgServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/11</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class ViewFormCfgServiceImpl implements ViewFormCfgService {
    @Resource
    private ComFormMapper comFormMapper;
    @Resource
    private ComFormRightsMapper comFormRightMapper;
    @Resource
    private ComCodeMapper comCodeMapper;
    @Resource
    private ComOrgFormMapper comOrgFormMapper;
    @Resource
    private ComOrgFormRightsMapper comOrgFormRightsMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referForm(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comForms;
        String prgroup = requestRefPar.getStringPar("prgroup");
        String formName = requestRefPar.getStringPar("formName");
        ComFormExample comFormExample = new ComFormExample();
        ComFormExample.Criteria criteria = comFormExample.createCriteria();

        if (!StringUtil.isNullOrEmpty(prgroup)) {
            criteria.andPrgroupEqualTo(prgroup);
        }
        if (!StringUtil.isNullOrEmpty(formName)) {
            criteria.andFormNameLike("%" + formName + "%");
        }
        comForms = comFormMapper.selectByExample(comFormExample);

        responseData.setData(comForms);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyForm(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        ComForm comForm;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            comForm = (ComForm) JsonUtil.readValueAsObject(rowData, ComForm.class);
            if (null != comForm) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        comForm.setItime(now);
                        comForm.setIperson(personId);
                        comForm.setUtime(now);
                        comForm.setUperson(personId);
                        comFormMapper.insertSelective(comForm);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        comForm.setUtime(now);
                        comForm.setUperson(personId);
                        comFormMapper.updateByPrimaryKeySelective(comForm);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        ComOrgFormRights comOrgFormRights = new ComOrgFormRights();
                        ComOrgForm comOrgForm = new ComOrgForm();
                        ComFormRights comFormRights = new ComFormRights();

                        comOrgFormRights.setFormId(comForm.getFormId());
                        comOrgFormRightsMapper.deleteByPrimaryKey(comOrgFormRights);
                        comFormRights.setFormId(comForm.getFormId());
                        comFormRightMapper.deleteByPrimaryKey(comFormRights);
                        comOrgForm.setFormId(comForm.getFormId());
                        comOrgFormMapper.deleteByPrimaryKey(comOrgForm);

                        comFormMapper.deleteByPrimaryKey(comForm.getFormId());
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
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referFormRight(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        ComFormRights comFormRight = new ComFormRights();
        List<?> comFormRights;

        comFormRight.setFormId(requestRefPar.getIntegerPar("formId"));
        comFormRights = comFormRightMapper.selectAssociation(comFormRight);

        responseData.setData(comFormRights);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyFormRight(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId, returnValue;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        ComFormRights comFormRight;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            comFormRight = (ComFormRights) JsonUtil.readValueAsObject(rowData, ComFormRights.class);
            if (null != comFormRight) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        if (null == comFormRight.getRea()) {
                            comFormRight.setRea(0);
                        }
                        if (null == comFormRight.getR1()) {
                            comFormRight.setR1(0);
                        }
                        if (null == comFormRight.getR2()) {
                            comFormRight.setR2(0);
                        }
                        if (null == comFormRight.getR3()) {
                            comFormRight.setR3(0);
                        }
                        comFormRight.setItime(now);
                        comFormRight.setIperson(personId);
                        comFormRight.setUtime(now);
                        comFormRight.setUperson(personId);
                        returnValue = comFormRightMapper.insertSelective(comFormRight);

                        if (returnValue > 0) {
                            ComOrgForm comOrgForm;
                            List<ComOrgForm> comOrgForms;

                            comOrgForm = new ComOrgForm();
                            comOrgForm.setFormId(comFormRight.getFormId());
                            comOrgForms = comOrgFormMapper.selectAssociation(comOrgForm);
                            if (null != comOrgForms) {
                                for (ComOrgForm orgForm : comOrgForms) {
                                    ComOrgFormRights comOrgFormRights = new ComOrgFormRights();

                                    comOrgFormRights.setOrgId(orgForm.getOrgId());
                                    comOrgFormRights.setFormId(orgForm.getFormId());
                                    comOrgFormRights.setRightId(comFormRight.getRightId());
                                    comOrgFormRights.setRea(comFormRight.getRea());
                                    comOrgFormRights.setRel(0);
                                    comOrgFormRights.setR1(comFormRight.getR1());
                                    comOrgFormRights.setR2(comFormRight.getR2());
                                    comOrgFormRights.setR3(comFormRight.getR3());
                                    comOrgFormRights.setIperson(comFormRight.getIperson());
                                    comOrgFormRights.setItime(comFormRight.getItime());
                                    comOrgFormRights.setUperson(comFormRight.getUperson());
                                    comOrgFormRights.setUtime(comFormRight.getUtime());

                                    comOrgFormRightsMapper.insertSelective(comOrgFormRights);
                                }
                            }
                        }

                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        returnValue = comFormRightMapper.updateByPrimaryKeySelective(comFormRight);
                        if (returnValue > 0) {
                            ComOrgFormRights comOrgFormRights = new ComOrgFormRights();

                            comOrgFormRights.setFormId(comFormRight.getFormId());
                            comOrgFormRights.setRightId(comFormRight.getRightId());
                            comOrgFormRights.setRea(comFormRight.getRea());
                            comOrgFormRights.setR1(comFormRight.getR1());
                            comOrgFormRights.setR2(comFormRight.getR2());
                            comOrgFormRights.setR3(comFormRight.getR3());
                            comOrgFormRights.setUperson(comFormRight.getUperson());
                            comOrgFormRights.setUtime(comFormRight.getUtime());

                            comOrgFormRightsMapper.updateByPrimaryKeySelective(comOrgFormRights);
                        }

                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        ComOrgFormRights comOrgFormRights = new ComOrgFormRights();

                        comOrgFormRights.setFormId(comFormRight.getFormId());
                        comOrgFormRights.setRightId(comFormRight.getRightId());
                        comOrgFormRightsMapper.deleteByPrimaryKey(comOrgFormRights);

                        comFormRightMapper.deleteByPrimaryKey(comFormRight);

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
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referFormCtlType(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comCodes;
        List<String> codeTypes = new ArrayList<String>();
        ComCodeExample comCodeExample = new ComCodeExample();

        codeTypes.add("C0001");
        comCodeExample.createCriteria().andCodeTypeIn(codeTypes);
        comCodes = comCodeMapper.selectByExample(comCodeExample);

        responseData.setData(comCodes);
    }
}
