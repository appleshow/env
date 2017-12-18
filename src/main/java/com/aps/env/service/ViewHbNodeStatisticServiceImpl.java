package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbDataModeMapper;
import com.aps.env.dao.HbNodeMapper;
import com.aps.env.entity.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbNodeStatisticServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/18</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class ViewHbNodeStatisticServiceImpl implements ViewHbNodeStatisticService {
    @Resource
    private HbDataModeMapper hbDataModeMapper;
    @Resource
    private HbNodeMapper hbNodeMapper;

    @Override
    public void refHbData(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) throws ParseException {
        final Date dateFrom = DateUtil.fromString(requestRefPar.getStringPar("dateStr"), DateUtil.SIMPLE_DATE_FORMAT1);
        final Date dateTo = DateUtil.fromString(requestRefPar.getStringPar("dateEnd"), DateUtil.SIMPLE_DATE_FORMAT1);
        final Integer nodeId = requestRefPar.getIntegerPar("nodeId");
        final String dataType = requestRefPar.getStringPar("dataType");
        final List<ObjectNode> nodeParInfo;

        nodeParInfo = findNodeDataInfo(nodeId, dataType, dateFrom, dateTo);

        responseData.setTotalCount(nodeParInfo.size());
        responseData.setData(nodeParInfo);
    }

    /**
     * @param nodeId
     * @param dataType
     * @param dateStr
     * @param dateEnd
     * @return
     */
    private List<ObjectNode> findNodeDataInfo(Integer nodeId, String dataType, Date dateStr, Date dateEnd) {
        final List<HbDataMode> hbDataModes;
        final List<ObjectNode> nodeParValeInfo = new ArrayList<>();
        final HbNode hbNode;

        try {
            hbNode = hbNodeMapper.selectByPrimaryKey(nodeId);
            if (null != hbNode) {
                final Map<String, String> hbTypeItemNodeMap = JsonUtil.getObjectMapper().readValue(hbNode.getNodeItem(), Map.class);
                if (null != hbTypeItemNodeMap) {
                    final HbDataModeExample hbDataModeExample = new HbDataModeExample();
                    hbDataModeExample.setDataTbale(CommUtil.HB_DATA_CUR + nodeId);
                    hbDataModeExample.createCriteria().andNodeMnEqualTo(hbNode.getNodeMn()).andDataTypeEqualTo(dataType).andDataTimeBetween(dateStr, dateEnd);
                    hbDataModeExample.setOrderByClause("DATA_TIME");
                    hbDataModes = hbDataModeMapper.selectByExample(hbDataModeExample);

                    if (null != hbDataModes && hbDataModes.size() > 0) {
                        final int totalDataCount = hbDataModes.size();
                        final List<Map<String, String>> nodeDatas = new ArrayList<>();
                        final ObjectNode checkParInfoTmp = JsonUtil.getObjectNodeInstance();

                        checkParInfoTmp.put("itemId", hbNode.getNodeId());
                        checkParInfoTmp.put("itemName", hbNode.getNodeName());
                        checkParInfoTmp.put("dataCount", totalDataCount);
                        nodeParValeInfo.add(checkParInfoTmp);

                        hbDataModes.stream().forEach(dataMode -> {
                            if (!StringUtil.isNullOrEmpty(dataMode.getNodeData())) {
                                try {
                                    if (!StringUtil.isNullOrEmpty(dataMode.getNodeData())) {
                                        nodeDatas.add(JsonUtil.getObjectMapper().readValue(dataMode.getNodeData(), Map.class));
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        hbTypeItemNodeMap.forEach((itemId, hbTypeItem) -> {
                            try {
                                HbTypeItemNode hbTypeItemNode = JsonUtil.getObjectMapper().readValue(hbTypeItem, HbTypeItemNode.class);
                                if (hbTypeItemNode.getItemSelect() == 1) {
                                    final HbTypeItemException hbTypeItemException = new HbTypeItemException(hbTypeItemNode);

                                    nodeDatas.forEach(nodeData -> {
                                        if (nodeData.containsKey(itemId)) {
                                            float itemValue;
                                            try {
                                                itemValue = Float.valueOf(nodeData.get(itemId));
                                                hbTypeItemException.putValue(Double.valueOf(itemValue));

                                                HbTypeItemException.checkItemValue(hbTypeItemException, hbTypeItemNode, itemValue);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });

                                    final ObjectNode checkParInfo = JsonUtil.getObjectNodeInstance();
                                    checkParInfo.put("itemId", itemId);
                                    if (1 != hbTypeItemNode.getItemAlarm()) {
                                        checkParInfo.put("itemName", "<kbd style='background:green' title='未开启报警'>" + hbTypeItemNode.getItemName() + "</kbd>");
                                    } else {
                                        checkParInfo.put("itemName", hbTypeItemNode.getItemName());
                                    }
                                    checkParInfo.put("itemUnit", hbTypeItemNode.getItemUnit());
                                    checkParInfo.put("dataCount", hbTypeItemException.getValueTotalCount());
                                    if (null != hbTypeItemException.getValueMin()) {
                                        checkParInfo.put("minValue", Math.round(hbTypeItemException.getValueMin() * 1000) / 1000.0);
                                    }
                                    if (null != hbTypeItemException.getValueMax()) {
                                        checkParInfo.put("maxValue", Math.round(hbTypeItemException.getValueMax() * 1000) / 1000.0);
                                    }
                                    if (null != hbTypeItemException.getValueAvg()) {
                                        checkParInfo.put("avgValue", Math.round(hbTypeItemException.getValueAvg() * 1000) / 1000.0);
                                    }

                                    if (0 < hbTypeItemException.getValueMinCount()) {
                                        if (1 == hbTypeItemNode.getItemAlarm()) {
                                            checkParInfo.put("minCount", "<span class='badge'><small>" + hbTypeItemException.getValueMinCount() + "</small></span><kbd style='background:red' title='下限：" + hbTypeItemNode.getItemVmin() + "'><small>" + hbTypeItemException.getValueMinCountRate() + "</kbd>");
                                        } else {
                                            checkParInfo.put("minCount", "<span class='badge'><small>" + hbTypeItemException.getValueMinCount() + "</small></span><kbd style='background:green' title='下限：" + hbTypeItemNode.getItemVmin() + "'><small>" + hbTypeItemException.getValueMinCountRate() + "</kbd>");
                                        }

                                    }
                                    if (0 < hbTypeItemException.getValueMaxCount()) {
                                        if (1 == hbTypeItemNode.getItemAlarm()) {
                                            checkParInfo.put("maxCount", "<span class='badge'><small>" + hbTypeItemException.getValueMaxCount() + "</small></span><kbd style='background:red' title='上限：" + hbTypeItemNode.getItemVmax() + "'>" + hbTypeItemException.getValueMaxCountRate() + "</kbd>");
                                        } else {
                                            checkParInfo.put("maxCount", "<span class='badge'><small>" + hbTypeItemException.getValueMaxCount() + "</small></span><kbd style='background:green' title='上限：" + hbTypeItemNode.getItemVmax() + "'>" + hbTypeItemException.getValueMaxCountRate() + "</kbd>");
                                        }

                                    }
                                    if (0 < hbTypeItemException.getValueAla1Count()) {
                                        if (1 == hbTypeItemNode.getItemAlarm()) {
                                            checkParInfo.put("ala1Count", "<span class='badge'><small>" + hbTypeItemException.getValueAla1Count() + "</small></span><kbd style='background:red' title='一级阀值：" + hbTypeItemNode.getItemVala1() + "'>" + hbTypeItemException.getValueAla1CountRate() + "</kbd>");
                                        } else {
                                            checkParInfo.put("ala1Count", "<span class='badge'><small>" + hbTypeItemException.getValueAla1Count() + "</small></span><kbd style='background:green' title='一级阀值：" + hbTypeItemNode.getItemVala1() + "'>" + hbTypeItemException.getValueAla1CountRate() + "</kbd>");
                                        }

                                    }
                                    if (0 < hbTypeItemException.getValueAla2Count()) {
                                        if (1 == hbTypeItemNode.getItemAlarm()) {
                                            checkParInfo.put("ala2Count", "<span class='badge'><small>" + hbTypeItemException.getValueAla2Count() + "</small></span><kbd style='background:red' title='二级阀值：" + hbTypeItemNode.getItemVala2() + "'>" + hbTypeItemException.getValueAla2CountRate() + "</kbd>");
                                        } else {
                                            checkParInfo.put("ala2Count", "<span class='badge'><small>" + hbTypeItemException.getValueAla2Count() + "</small></span><kbd style='background:green' title='二级阀值：" + hbTypeItemNode.getItemVala2() + "'>" + hbTypeItemException.getValueAla2CountRate() + "</kbd>");

                                        }
                                    }
                                    if (0 < hbTypeItemException.getValueAla3Count()) {
                                        if (1 == hbTypeItemNode.getItemAlarm()) {
                                            checkParInfo.put("ala3Count", "<span class='badge'><small>" + hbTypeItemException.getValueAla3Count() + "</small></span><kbd style='background:red' title='三级阀值：" + hbTypeItemNode.getItemVala3() + "'>" + hbTypeItemException.getValueAla3CountRate() + "</kbd>");
                                        } else {
                                            checkParInfo.put("ala3Count", "<span class='badge'><small>" + hbTypeItemException.getValueAla3Count() + "</small></span><kbd style='background:green' title='三级阀值：" + hbTypeItemNode.getItemVala3() + "'>" + hbTypeItemException.getValueAla3CountRate() + "</kbd>");
                                        }

                                    }

                                    nodeParValeInfo.add(checkParInfo);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nodeParValeInfo;
    }
}
