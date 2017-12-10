package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbDataModeMapper;
import com.aps.env.dao.HbNodeMapper;
import com.aps.env.dao.HbTypeItemMapper;
import com.aps.env.dao.HbTypeMapper;
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
public class ViewHbEnterpriseNodeServiceImpl implements ViewHbEnterpriseNodeService {
    @Resource
    private HbTypeMapper hbTypeMapper;
    @Resource
    private HbNodeMapper hbNodeMapper;
    @Resource
    private HbDataModeMapper hbDataModeMapper;
    @Resource
    private HbTypeItemMapper hbTypeItemMapper;

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

    }

    @Override
    public void modifyEnterpriseNode(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        HbNode hbNode;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            hbNode = (HbNode) JsonUtil.readValueAsObject(rowData, HbNode.class);
            if (null != hbNode) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        final HbTypeItemExample hbTypeItemExample = new HbTypeItemExample();
                        hbTypeItemExample.createCriteria().andTypeIdEqualTo(hbNode.getTypeId());
                        final List<HbTypeItem> hbTypeItems = hbTypeItemMapper.selectByExample(hbTypeItemExample);
                        final List<HbTypeItemNode> hbTypeItemNodes = new ArrayList<>();
                        hbTypeItems.stream().forEach(item -> {
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
                                hbTypeItemNode.setItemSelect(0);
                                hbTypeItemNode.setItemAlarm(0);
                                hbTypeItemNode.setItemShowMain(1);
                                hbTypeItemNodes.add(hbTypeItemNode);
                            }
                        });

                        hbNode.setNodeItem(JsonUtil.writeValueAsString(hbTypeItemNodes));
                        hbNode.setDeleteFlag(CommUtil.AVAILABLE);
                        hbNode.setItime(now);
                        hbNode.setIperson(personId);
                        hbNode.setUtime(now);
                        hbNode.setUperson(personId);
                        hbNodeMapper.insertSelective(hbNode);

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
                        hbNode.setUtime(now);
                        hbNode.setUperson(personId);
                        hbNodeMapper.updateByPrimaryKeySelective(hbNode);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        hbNode.setDeleteFlag(CommUtil.DELETE);
                        hbNodeMapper.updateByPrimaryKeySelective(hbNode);

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