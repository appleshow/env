package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbNodeMapper;
import com.aps.env.dao.HbTypeItemMapper;
import com.aps.env.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbNodeItemServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/12</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbNodeItemServiceImpl implements HbNodeItemService {
    @Resource
    private HbTypeItemMapper hbTypeItemMapper;
    @Resource
    private HbNodeMapper hbNodeMapper;

    @Override
    public void referHbTypeItem(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        Integer nodeId = requestRefPar.getIntegerPar("nodeId");
        final List<HbTypeItemNode> hbTypeItemNodes = new ArrayList<>();

        if (nodeId == null) {
            responseData.setData(hbTypeItemNodes);
        } else {
            final HbNode hbNode = hbNodeMapper.selectByPrimaryKey(nodeId);
            final HbTypeItemExample hbTypeItemExample = new HbTypeItemExample();
            hbTypeItemExample.createCriteria().andTypeIdEqualTo(hbNode.getTypeId());
            final List<HbTypeItem> hbTypeItems = hbTypeItemMapper.selectByExample(hbTypeItemExample);

            hbTypeItems.stream().forEach(item -> {
                HbTypeItemNode hbTypeItemNode = new HbTypeItemNode();

                hbTypeItemNode.setNodeId(nodeId);
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
                hbTypeItemNode.setItemMonitor(null == item.getProperty10() ? 0 : Integer.parseInt(item.getProperty10().toString()));
                hbTypeItemNode.setItemAlarm(0);
                hbTypeItemNode.setItemShowMain(0);

                if (hbNode != null) {
                    String nodeItem = hbNode.getNodeItem();
                    if (!StringUtil.isNullOrEmpty(nodeItem)) {
                        try {
                            Map nodeItemMap = JsonUtil.getObjectMapper().readValue(nodeItem, Map.class);
                            if (nodeItemMap.containsKey(item.getItemId())) {
                                String nodeItemValue = String.valueOf(nodeItemMap.get(item.getItemId()));
                                if (!StringUtil.isNullOrEmpty(nodeItemValue)) {
                                    Map itemMap = JsonUtil.getObjectMapper().readValue(nodeItemValue, Map.class);
                                    HbTypeItemNode hbTypeItemNodeTemp = (HbTypeItemNode) JsonUtil.readValueAsObject(itemMap, hbTypeItemNode.getClass());
                                    if (hbTypeItemNodeTemp != null) {
                                        hbTypeItemNode.setItemUnit(hbTypeItemNodeTemp.getItemUnit());
                                        hbTypeItemNode.setItemUnitConvert(hbTypeItemNodeTemp.getItemUnitConvert());
                                        hbTypeItemNode.setItemVmin(hbTypeItemNodeTemp.getItemVmin());
                                        hbTypeItemNode.setItemVmax(hbTypeItemNodeTemp.getItemVmax());
                                        hbTypeItemNode.setItemVsta(hbTypeItemNodeTemp.getItemVsta());
                                        hbTypeItemNode.setItemVala1(hbTypeItemNodeTemp.getItemVala1());
                                        hbTypeItemNode.setItemVala2(hbTypeItemNodeTemp.getItemVala2());
                                        hbTypeItemNode.setItemVala3(hbTypeItemNodeTemp.getItemVala3());
                                        hbTypeItemNode.setItemConvertFormat(hbTypeItemNodeTemp.getItemConvertFormat());
                                        hbTypeItemNode.setItemSelect(hbTypeItemNodeTemp.getItemSelect());
                                        hbTypeItemNode.setItemMonitor(hbTypeItemNodeTemp.getItemMonitor());
                                        hbTypeItemNode.setItemOperating(hbTypeItemNodeTemp.getItemOperating());
                                        hbTypeItemNode.setItemLog(hbTypeItemNodeTemp.getItemLog());
                                        hbTypeItemNode.setItemAlarm(hbTypeItemNodeTemp.getItemAlarm());
                                        hbTypeItemNode.setItemShowMain(hbTypeItemNodeTemp.getItemShowMain());
                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                hbTypeItemNodes.add(hbTypeItemNode);
            });

            responseData.setTotalCount(hbTypeItemNodes.size());
            responseData.setData(hbTypeItemNodes);
        }
    }

    @Override
    public void modifyHbNode(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        HbTypeItemNode hbTypeItemNode;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            hbTypeItemNode = (HbTypeItemNode) JsonUtil.readValueAsObject(rowData, HbTypeItemNode.class);
            if (null != hbTypeItemNode) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        HbNode hbNode = hbNodeMapper.selectByPrimaryKey(hbTypeItemNode.getNodeId());
                        try {
                            Map nodeItemMap = JsonUtil.getObjectMapper().readValue(hbNode.getNodeItem(), Map.class);

                            hbTypeItemNode.setNodeId(null);
                            nodeItemMap.put(hbTypeItemNode.getItemId(), JsonUtil.writeValueAsString(hbTypeItemNode));
                            hbNode.setNodeItem(JsonUtil.writeValueAsString(nodeItemMap));
                            hbNode.setUtime(now);
                            hbNode.setUperson(personId);
                            hbNodeMapper.updateByPrimaryKeySelective(hbNode);
                        } catch (IOException e) {
                            e.printStackTrace();
                            jsonParseException = true;
                        }
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
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
