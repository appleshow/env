package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbDataModeMapper;
import com.aps.env.dao.HbNodeMapper;
import com.aps.env.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbNodeStatusServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2017/12/17</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbNodeStatusServiceImpl implements HbNodeStatusService {
    @Resource
    private HbNodeMapper hbNodeMapper;
    @Resource
    private HbDataModeMapper hbDataModeMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void refNodeStatus(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        final HbNode hbNode = new HbNode();
        final List<Map<String, Object>> returnArray = new ArrayList<>();
        final String dataType = "2051";
        Integer hours = requestRefPar.getIntegerPar("hours");

        hbNode.setIperson((int) httpSession.getAttribute(CommUtil.SESSION_PERSON_ID));
        List<HbNode> hbNodes = hbNodeMapper.selectAssociationByPerson(hbNode);

        hbNodes.stream().forEach(node -> {
            Map<String, Object> lineMap = new HashMap<>();
            lineMap.put("nodeId", String.valueOf(node.getNodeId()));
            lineMap.put("nodeMn", node.getNodeMn());
            lineMap.put("nodeName", node.getNodeName());
            lineMap.put("enterpriseName", node.getHbEnterprise().getEnterpriseName());
            lineMap.put("typeName", node.getHbType().getTypeName());
            lineMap.put("nodeStatus", "");

            final Map<String, HbTypeItemNode> hbTypeItemNodeMap = new HashMap<>();
            try {
                Map<String, String> typeItemStringMap = JsonUtil.getObjectMapper().readValue(node.getNodeItem(), Map.class);
                typeItemStringMap.forEach((itemId, itemInfo) -> {
                    try {
                        HbTypeItemNode hbTypeItemNode = JsonUtil.getObjectMapper().readValue(itemInfo, HbTypeItemNode.class);
                        hbTypeItemNodeMap.put(itemId, hbTypeItemNode);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

            processNodeData(lineMap, hbTypeItemNodeMap, node.getNodeId(), node.getNodeMn(), dataType, hours);

            returnArray.add(lineMap);
        });

        responseData.setTotalCount(returnArray.size());
        responseData.setData(returnArray);
    }

    /**
     * @param lineMap
     * @param hbTypeItemNodeMap
     * @param nodeId
     * @param nodeMn
     * @param dataType
     * @param hours
     */
    private void processNodeData(Map<String, Object> lineMap, Map<String, HbTypeItemNode> hbTypeItemNodeMap, Integer nodeId, String nodeMn, String dataType, Integer hours) {
        final Map<String, HbTypeItemException> hbTypeItemExceptionMap = new HashMap<>();
        final List<HbDataMode> hbDataModes = findNodeData(nodeId, nodeMn, dataType, hours);

        hbTypeItemNodeMap.forEach((itemId, hbTypeItemNode) -> {
            if (hbTypeItemNode.isSelectMonitorItem()) {
                hbTypeItemExceptionMap.put(itemId, new HbTypeItemException(hbTypeItemNode));
            }
        });

        hbDataModes.stream().forEach(nodeData -> {
            try {
                final Map<String, String> nodeDataMap = JsonUtil.getObjectMapper().readValue(nodeData.getNodeData(), Map.class);

                hbTypeItemExceptionMap.forEach((itemId, hbTypeItemException) -> {
                    if (nodeDataMap.containsKey(itemId)) {
                        HbTypeItemNode hbTypeItemNode = hbTypeItemException.getHbTypeItemNode();
                        float itemValue = Float.valueOf(nodeDataMap.get(itemId));

                        HbTypeItemException.checkItemValue(hbTypeItemException, hbTypeItemNode, itemValue);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        if (hbDataModes.size() > 0) {
            HbDataMode hbDataMode = hbDataModes.get(hbDataModes.size() - 1);

            lineMap.put("dataFrom", hbDataMode.getProperty0());
            lineMap.put("receiveTime", DateUtil.formatString(hbDataMode.getItime(), DateUtil.SIMPLE_DATE_FORMAT1));
            lineMap.put("latestTime", DateUtil.formatString(hbDataMode.getDataTime(), DateUtil.SIMPLE_DATE_FORMAT1));

            final List<HbTypeItemException> hbTypeItemExceptions = new ArrayList<>();
            hbTypeItemExceptionMap.forEach((item, hbTypeItemException) -> {
                if (hbTypeItemException.hasException()) {
                    hbTypeItemExceptions.add(hbTypeItemException);
                }
            });
            if (hbTypeItemExceptions.size() > 0) {
                lineMap.put("exceptionPars", hbTypeItemExceptions);
            }
            lineMap.put("dataCount", hbDataModes.size());
        }

    }

    /**
     * @param nodeId
     * @param hours
     * @return
     */
    private List<HbDataMode> findNodeData(Integer nodeId, String nodeMn, String dataType, Integer hours) {
        final Date dateEnd = new Date();
        final Date dateStr = new Date(dateEnd.getTime() - 1000 * 60 * 60 * hours);
        HbDataModeExample hbDataModeExample = new HbDataModeExample();
        hbDataModeExample.setDataTbale(CommUtil.HB_DATA_CUR + nodeId);
        hbDataModeExample.createCriteria().andNodeMnEqualTo(nodeMn).andDataTypeEqualTo(dataType).andDataTimeBetween(dateStr, dateEnd);
        hbDataModeExample.setOrderByClause("DATA_TIME");

        return hbDataModeMapper.selectByExample(hbDataModeExample);
    }


}
