package com.aps.env.service;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.dao.HbDataLatestMapper;
import com.aps.env.entity.HbDataLatest;
import com.aps.env.entity.HbDataLatestExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbDataLGridServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/16</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbDataLGridServiceImpl implements HbDataLGridService {
    @Resource
    private HbDataLatestMapper hbDataLatestMapper;

    @Override
    public void refHbDataLatest(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<HbDataLatest> hbDataLatests = new ArrayList<>();
        Integer nodeId = requestRefPar.getIntegerPar("nodeId");

        if (null != nodeId) {
            HbDataLatestExample hbDataLatestExample = new HbDataLatestExample();
            hbDataLatestExample.createCriteria().andNodeIdEqualTo(nodeId).andNodeDataIsNotNull();
            hbDataLatestExample.setOrderByClause("DATA_TIME DESC");
            List<HbDataLatest> hbDataLatestsTemp = hbDataLatestMapper.selectByExample(hbDataLatestExample);
            if (hbDataLatestsTemp.size() > 0) {
                hbDataLatests.add(hbDataLatestsTemp.get(0));
            }
        }

        responseData.setData(hbDataLatests);
    }
}
