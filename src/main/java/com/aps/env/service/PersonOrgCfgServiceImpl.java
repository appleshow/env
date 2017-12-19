package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.ComPersonOrgMapper;
import com.aps.env.entity.ComPerson;
import com.aps.env.entity.ComPersonOrg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewPersonOrgCfgServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/17</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class PersonOrgCfgServiceImpl implements PersonOrgCfgService {
    @Resource
    private ComPersonOrgMapper comPeronOrgMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referPersonOrg(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comPersonOrgs;
        ComPerson comPerson = new ComPerson();
        String userId = requestRefPar.getStringPar("userId");
        String userName = requestRefPar.getStringPar("userName");

        comPerson.setUserId(userId);
        comPerson.setUserName(userName);
        comPersonOrgs = comPeronOrgMapper.selectByPerson(comPerson);
        responseData.setData(comPersonOrgs);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyPersonOrg(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        ComPersonOrg comPersonOrg;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            comPersonOrg = (ComPersonOrg) JsonUtil.readValueAsObject(rowData, ComPersonOrg.class);
            if (null != comPersonOrg) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        comPersonOrg.setPrtype("1");
                        comPersonOrg.setItime(now);
                        comPersonOrg.setIperson(personId);
                        comPersonOrg.setUtime(now);
                        comPersonOrg.setUperson(personId);

                        comPeronOrgMapper.insertSelective(comPersonOrg);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        comPersonOrg.setUtime(now);
                        comPersonOrg.setUperson(personId);
                        comPeronOrgMapper.updateByPrimaryKeySelective(comPersonOrg);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        comPeronOrgMapper.deleteByPrimaryKey(comPersonOrg);
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
