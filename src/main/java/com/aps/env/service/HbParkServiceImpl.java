package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbDataModeMapper;
import com.aps.env.dao.HbParkMapper;
import com.aps.env.entity.HbDataMode;
import com.aps.env.entity.HbDataModeExample;
import com.aps.env.entity.HbPark;
import com.aps.env.entity.HbParkExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * <dl>
 * <dt>com.aps.env.service.HbParkServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/20</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbParkServiceImpl implements HbParkService {
    @Resource
    private HbParkMapper hbParkMapper;
    @Resource
    private HbDataModeMapper hbDataModeMapper;

    @Override
    public void refHbPark(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        HbParkExample hbParkExample = new HbParkExample();

        responseData.setData(hbParkMapper.selectByExample(hbParkExample));
    }

    @Override
    public void modifyHbPark(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        HbPark hbPark;
        HbParkExample hbParkExample;
        List<HbPark> hbParkExist;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            hbPark = (HbPark) JsonUtil.readValueAsObject(rowData, HbPark.class);
            if (null != hbPark) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        hbParkExample = new HbParkExample();
                        hbParkExample.createCriteria().andParkNameEqualTo(hbPark.getParkName());
                        hbParkExist = hbParkMapper.selectByExample(hbParkExample);
                        if (null != hbParkExist && hbParkExist.size() > 0) {
                            responseData.setCode(-107);
                            responseData.setMessage("园区名称已存在...！");
                            return;
                        }
                        hbPark.setParkGuid(UUID.randomUUID().toString());
                        hbPark.setDeleteFlag(0);
                        hbPark.setItime(now);
                        hbPark.setIperson(personId);
                        hbPark.setUtime(now);
                        hbPark.setUperson(personId);
                        hbParkMapper.insertSelective(hbPark);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        hbParkExample = new HbParkExample();
                        hbParkExample.createCriteria().andParkNameEqualTo(hbPark.getParkName()).andParkGuidNotEqualTo(hbPark.getParkGuid());
                        hbParkExist = hbParkMapper.selectByExample(hbParkExample);
                        if (null != hbParkExist && hbParkExist.size() > 0) {
                            responseData.setCode(-107);
                            responseData.setMessage("园区名称已存在...！");
                            return;
                        }

                        hbPark.setUtime(now);
                        hbPark.setUperson(personId);
                        hbParkMapper.updateByPrimaryKeySelective(hbPark);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        hbParkMapper.deleteByPrimaryKey(hbPark.getParkGuid());
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
    public void refHbParkDataByPar(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<HbDataMode> hbDataModes = new ArrayList<>(), hbDataModesTmp;
        String[] nodeIds = requestRefPar.getStringPar("nodeId").split(";");
        String[] nodeMns = requestRefPar.getStringPar("nodeMn").split(";");
        String dataType = requestRefPar.getStringPar("dataType");
        Integer hours = requestRefPar.getIntegerPar("hours");
        Date dateEnd = new Date();
        Date dateStr = new Date(dateEnd.getTime() - 1000 * 60 * 60 * hours);

        for (int index = 0; index < nodeIds.length; index++) {
            HbDataModeExample hbDataModeExample = new HbDataModeExample();
            hbDataModeExample.setDataTbale(CommUtil.HB_DATA_CUR + nodeIds[index]);
            hbDataModeExample.createCriteria().andNodeMnEqualTo(nodeMns[index]).andDataTypeEqualTo(dataType).andDataTimeBetween(dateStr, dateEnd);
            hbDataModeExample.setOrderByClause("DATA_TIME");


            hbDataModesTmp = hbDataModeMapper.selectByExample(hbDataModeExample);
            hbDataModes.addAll(hbDataModesTmp);
        }
        responseData.setData(hbDataModes);

    }
}
