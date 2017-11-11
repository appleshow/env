package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.ComCodeMapper;
import com.aps.env.entity.ComCode;
import com.aps.env.entity.ComCodeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewCodeCfgServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class ViewCodeCfgServiceImpl implements ViewCodeCfgService {
    @Resource
    private ComCodeMapper comCodeMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referCode(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comCodes;
        String codeType = requestRefPar.getStringPar("codeType");
        String codeName = requestRefPar.getStringPar("codeName");

        ComCodeExample comCodeExample = new ComCodeExample();
        ComCodeExample.Criteria criteria = comCodeExample.createCriteria();
        if (!StringUtil.isNullOrEmpty(codeType)) {
            criteria.andCodeTypeEqualTo(codeType);
        }
        if (!StringUtil.isNullOrEmpty(codeName)) {
            criteria.andCodeNameLike("%" + codeName + "%");
        }
        comCodes = comCodeMapper.selectByExample(comCodeExample);

        responseData.setData(comCodes);
    }

    /**
     * @param session
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyCode(HttpSession session, RequestMdyPar requestMdyPar, ResponseData responseData) {
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
                personId = requestMdyPar.getPersonId(session, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        comCode.setItime(now);
                        comCode.setIperson(personId);
                        comCode.setUtime(now);
                        comCode.setUperson(personId);
                        comCodeMapper.insertSelective(comCode);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        comCodeMapper.updateByPrimaryKeySelective(comCode);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        comCodeMapper.deleteByPrimaryKey(comCode);
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
