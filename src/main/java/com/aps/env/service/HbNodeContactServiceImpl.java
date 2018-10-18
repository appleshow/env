package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbNodeContactMapper;
import com.aps.env.entity.HbNodeContact;
import com.aps.env.entity.HbNodeContactExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.HbNodeContactServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2018/8/18</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbNodeContactServiceImpl implements HbNodeContactService {
    @Resource
    private HbNodeContactMapper hbNodeContactMapper;


    @Override
    public void refData(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        Integer nodeId = requestRefPar.getIntegerPar("nodeId");
        List<HbNodeContact> hbNodeContactList = new ArrayList<>();

        if (nodeId == null) {
            responseData.setData(hbNodeContactList);
        } else {
            HbNodeContactExample hbNodeContactExample = new HbNodeContactExample();
            hbNodeContactExample.createCriteria().andNodeIdEqualTo(nodeId);

            hbNodeContactList = hbNodeContactMapper.selectByExample(hbNodeContactExample);

            responseData.setTotalCount(hbNodeContactList.size());
            responseData.setData(hbNodeContactList);
        }
    }

    @Override
    public void modifyData(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        HbNodeContact hbNodeContact;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            hbNodeContact = (HbNodeContact) JsonUtil.readValueAsObject(rowData, HbNodeContact.class);
            if (null != hbNodeContact) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        hbNodeContact.setItime(now);
                        hbNodeContact.setIperson(personId);
                        hbNodeContact.setUtime(now);
                        hbNodeContact.setUperson(personId);
                        hbNodeContactMapper.insertSelective(hbNodeContact);

                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        hbNodeContact.setUtime(now);
                        hbNodeContact.setUperson(personId);
                        hbNodeContactMapper.updateByPrimaryKeySelective(hbNodeContact);

                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        hbNodeContactMapper.deleteByPrimaryKey(hbNodeContact.getGuid());

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
