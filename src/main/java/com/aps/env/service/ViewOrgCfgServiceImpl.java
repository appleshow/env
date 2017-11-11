package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.ComOrgMapper;
import com.aps.env.entity.ComOrg;
import com.aps.env.entity.ComOrgExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewOrgCfgServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class ViewOrgCfgServiceImpl implements ViewOrgCfgService {
    @Resource
    private ComOrgMapper comOrgMapper;

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
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyOrg(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        ComOrg comOrg;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            comOrg = (ComOrg) JsonUtil.readValueAsObject(rowData, ComOrg.class);
            if (null != comOrg) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        comOrg.setItime(now);
                        comOrg.setIperson(personId);
                        comOrg.setUtime(now);
                        comOrg.setUperson(personId);
                        comOrgMapper.insertSelective(comOrg);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        comOrgMapper.updateByPrimaryKeySelective(comOrg);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        comOrgMapper.deleteByPrimaryKey(comOrg.getOrgId());
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
