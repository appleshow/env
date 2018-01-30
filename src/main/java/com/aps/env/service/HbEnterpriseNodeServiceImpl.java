package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.*;
import com.aps.env.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbEnterpriseNodeServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbEnterpriseNodeServiceImpl implements HbEnterpriseNodeService {
    @Resource
    private HbTypeMapper hbTypeMapper;
    @Resource
    private HbNodeMapper hbNodeMapper;
    @Resource
    private HbDataModeMapper hbDataModeMapper;
    @Resource
    private HbTypeItemMapper hbTypeItemMapper;
    @Resource
    private HbDataLatestMapper hbDataLatestMapper;
    @Resource
    private ComResourceMapper comResourceMapper;

    private final String CREATE_TABLE_SQL = "CREATE TABLE `#` (\n" +
            "  `DATA_GUID` varchar(50) NOT NULL,\n" +
            "  `NODE_MN` varchar(40) DEFAULT NULL,\n" +
            "  `DATA_TYPE` varchar(20) DEFAULT NULL,\n" +
            "  `DATA_TIME` datetime DEFAULT NULL,\n" +
            "  `NODE_DATA` varchar(4000) DEFAULT NULL,\n" +
            "  `NODE_TABLE` varchar(20) DEFAULT NULL,\n" +
            "  `RECORD_GUID` varchar(50) DEFAULT NULL,\n" +
            "  `PRSTATUS` int(11) DEFAULT NULL,\n" +
            "  `PRFLAG` int(11) DEFAULT NULL,\n" +
            "  `PRGROUP` varchar(10) DEFAULT NULL,\n" +
            "  `PRTYPE` varchar(10) DEFAULT NULL,\n" +
            "  `PROPERTY0` varchar(100) DEFAULT NULL,\n" +
            "  `PROPERTY1` varchar(100) DEFAULT NULL,\n" +
            "  `PROPERTY2` varchar(20) DEFAULT NULL,\n" +
            "  `PROPERTY3` varchar(20) DEFAULT NULL,\n" +
            "  `PROPERTY4` varchar(20) DEFAULT NULL,\n" +
            "  `PROPERTY5` varchar(20) DEFAULT NULL,\n" +
            "  `PROPERTY6` varchar(20) DEFAULT NULL,\n" +
            "  `PROPERTY7` varchar(20) DEFAULT NULL,\n" +
            "  `PROPERTY8` varchar(20) DEFAULT NULL,\n" +
            "  `PROPERTY9` varchar(20) DEFAULT NULL,\n" +
            "  `PROPERTY10` decimal(15,3) DEFAULT NULL,\n" +
            "  `PROPERTY11` decimal(15,3) DEFAULT NULL,\n" +
            "  `PROPERTY12` decimal(15,3) DEFAULT NULL,\n" +
            "  `PROPERTY13` decimal(15,3) DEFAULT NULL,\n" +
            "  `PROPERTY14` decimal(15,3) DEFAULT NULL,\n" +
            "  `PRINF` varchar(20) DEFAULT NULL,\n" +
            "  `PREXP` varchar(100) DEFAULT NULL,\n" +
            "  `ITIME` datetime DEFAULT NULL,\n" +
            "  `IPERSON` int(11) DEFAULT NULL,\n" +
            "  `UTIME` datetime DEFAULT NULL,\n" +
            "  `UPERSON` int(11) DEFAULT NULL,\n" +
            "  `DELETE_FLAG` int(11) DEFAULT NULL,\n" +
            "  `DTIME` date DEFAULT NULL,\n" +
            "  `DPERSON` int(11) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`DATA_GUID`),\n" +
            "  UNIQUE KEY `XPKHB_DATA_MODE` (`DATA_GUID`),\n" +
            "  KEY `HB_DATA_MODE_A@` (`NODE_MN`) USING BTREE,\n" +
            "  KEY `HB_DATA_MODE_B@` (`DATA_TYPE`) USING BTREE,\n" +
            "  KEY `HB_DATA_MODE_C@` (`DATA_TIME`) USING BTREE\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

    @Override
    public void refNodeType(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        HbTypeExample hbTypeExample = new HbTypeExample();
        List<HbType> hbTypes;

        hbTypeExample.setOrderByClause("TYPE_ID");
        hbTypes = hbTypeMapper.selectByExample(hbTypeExample);

        responseData.setData(hbTypes);
    }

    @Override
    public void refEnterpriseNode(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        HbNode hbNode = new HbNode();
        String selectByPerson = requestRefPar.getStringPar("byPerson");

        if (!StringUtil.isNullOrEmpty(selectByPerson) && "1".equals(selectByPerson)) {
            hbNode.setIperson((int) httpSession.getAttribute(CommUtil.SESSION_PERSON_ID));
            responseData.setData(hbNodeMapper.selectAssociationByPerson(hbNode));
        } else {
            responseData.setData(hbNodeMapper.selectAssociation(hbNode));
        }
    }

    @Override
    public void modifyEnterpriseNode(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        final Map<String, Object> nodeItemMap = new HashMap<>();
        HbNode hbNode;
        HbNodeExample hbNodeExample;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            hbNode = (HbNode) JsonUtil.readValueAsObject(rowData, HbNode.class);
            if (null != hbNode) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        hbNodeExample = new HbNodeExample();
                        hbNodeExample.createCriteria().andNodeMnEqualTo(hbNode.getNodeMn());
                        if (hbNodeMapper.selectByExample(hbNodeExample).size() > 0) {
                            responseData.setCode(-108);
                            responseData.setMessage("站点MN号已存在，请重新录入！");
                            return;
                        }

                        final HbTypeItemExample hbTypeItemExample = new HbTypeItemExample();
                        hbTypeItemExample.createCriteria().andTypeIdEqualTo(hbNode.getTypeId());
                        final List<HbTypeItem> hbTypeItems = hbTypeItemMapper.selectByExample(hbTypeItemExample);
                        hbTypeItems.forEach(item -> {
                            if (1 == item.getPrflag()) {
                                HbTypeItemNode hbTypeItemNode = new HbTypeItemNode();
                                hbTypeItemNode.setItemId(item.getItemId());
                                hbTypeItemNode.setItemName(item.getItemName());
                                hbTypeItemNode.setItemUnit(item.getItemUnit());
                                hbTypeItemNode.setItemUnitConvert(item.getItemUnitConvert());
                                hbTypeItemNode.setItemVmin(item.getItemVmin());
                                hbTypeItemNode.setItemVmax(item.getItemVmax());
                                hbTypeItemNode.setItemVsta(item.getItemVsta());
                                hbTypeItemNode.setItemVala1(item.getItemVala1());
                                hbTypeItemNode.setItemVala2(item.getItemVala2());
                                hbTypeItemNode.setItemVala3(item.getItemVala3());
                                hbTypeItemNode.setItemConvertFormat(item.getItemConvertFormat());
                                hbTypeItemNode.setItemSelect(1);
                                hbTypeItemNode.setItemMonitor(null == item.getProperty10() ? 0 : Integer.parseInt(item.getProperty10().toString()));
                                hbTypeItemNode.setItemAlarm(0);
                                hbTypeItemNode.setItemShowMain(0);
                                nodeItemMap.put(hbTypeItemNode.getItemId(), hbTypeItemNode);
                            }
                        });

                        hbNode.setNodeItem(JsonUtil.writeValueAsString(nodeItemMap));
                        hbNode.setDeleteFlag(CommUtil.AVAILABLE);
                        hbNode.setItime(now);
                        hbNode.setIperson(personId);
                        hbNode.setUtime(now);
                        hbNode.setUperson(personId);
                        hbNodeMapper.insertSelective(hbNode);

                        /*
                        hbDataLatest = new HbDataLatest();
                        for (int index = 0; index < CommUtil.MAX_LATEST_DATA; index++) {
                            hbDataLatest.setDataGuid(UUID.randomUUID().toString());
                            hbDataLatest.setNodeId(hbNode.getNodeId());
                            hbDataLatest.setDataTime(now);
                            hbDataLatest.setItime(now);
                            hbDataLatest.setIperson(personId);
                            hbDataLatest.setUtime(now);
                            hbDataLatest.setUperson(personId);

                            hbDataLatestMapper.insertSelective(hbDataLatest);
                        }
                        */

                        String sql;
                        String nodeIdStr = String.valueOf(hbNode.getNodeId());
                        HbDataMode hbDataMode = new HbDataMode();
                        sql = CREATE_TABLE_SQL.replace("#", CommUtil.HB_DATA_CUR + nodeIdStr);
                        sql = sql.replace("@", "C" + nodeIdStr);
                        hbDataMode.setNodeTable(sql);
                        hbDataModeMapper.createTable(hbDataMode);
                        sql = CREATE_TABLE_SQL.replace("#", CommUtil.HB_DATA_HIS + nodeIdStr);
                        sql = sql.replace("@", "H" + nodeIdStr);
                        hbDataMode.setNodeTable(sql);
                        hbDataModeMapper.createTable(hbDataMode);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        hbNodeExample = new HbNodeExample();
                        hbNodeExample.createCriteria().andNodeMnEqualTo(hbNode.getNodeMn()).andNodeIdNotEqualTo(hbNode.getNodeId());
                        if (hbNodeMapper.selectByExample(hbNodeExample).size() > 0) {
                            responseData.setCode(-108);
                            responseData.setMessage("站点MN号已存在，请重新录入！");
                            return;
                        }

                        hbNode.setUtime(now);
                        hbNode.setUperson(personId);
                        hbNodeMapper.updateByPrimaryKeySelective(hbNode);

                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        ComResourceExample comResourceExample = new ComResourceExample();
                        comResourceExample.createCriteria().andResourceTypeFEqualTo(hbNode.getNodeId()).andResourceTypeAEqualTo("NODE");
                        comResourceMapper.deleteByExample(comResourceExample);

                        hbNodeMapper.deleteByPrimaryKey(hbNode);

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
