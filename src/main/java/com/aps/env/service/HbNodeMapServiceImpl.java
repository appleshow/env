package com.aps.env.service;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.dao.HbDataLatestMapper;
import com.aps.env.dao.HbNodeMapper;
import com.aps.env.entity.HbDataLatest;
import com.aps.env.entity.HbDataLatestExample;
import com.aps.env.entity.HbNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <dl>
 * <dt>com.aps.env.service.HbNodeMapServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/19</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbNodeMapServiceImpl implements HbNodeMapService {
    @Resource
    private HbNodeMapper hbNodeMapper;
    @Resource
    private HbDataLatestMapper hbDataLatestMapper;

    @Override
    public void refHbNodeJoinLatestData(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        Integer dataType = requestRefPar.getIntegerPar("dataType");
        HbNode hbNode = new HbNode();

        hbNode.setIperson((int) httpSession.getAttribute(CommUtil.SESSION_PERSON_ID));
        responseData.setData(hbNodeMapper.selectAssociationByPerson(hbNode));

        if (1 == dataType) {
            int nodeId = -1;
            ResponseData responseDataLatestData = new ResponseData();
            List<HbDataLatest> hbDataLatests = new ArrayList<>();
            HbDataLatestExample hbDataLatestExample = new HbDataLatestExample();
            hbDataLatestExample.setOrderByClause("NODE_ID,DATA_TIME DESC");
            for (HbDataLatest hbDataLatest : hbDataLatestMapper.selectByExample(hbDataLatestExample)) {
                if (nodeId != hbDataLatest.getNodeId()) {
                    nodeId = hbDataLatest.getNodeId();
                    hbDataLatests.add(hbDataLatest);
                }
            }
            responseDataLatestData.setData(hbDataLatests);
            responseData.setSubJoinResponseData(responseDataLatestData);
        }
    }
}
