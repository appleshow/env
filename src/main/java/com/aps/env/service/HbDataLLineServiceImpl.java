package com.aps.env.service;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.dao.HbDataLatestMapper;
import com.aps.env.dao.HbNodeMapper;
import com.aps.env.entity.HbDataLatest;
import com.aps.env.entity.HbNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbDataLLineServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/15</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbDataLLineServiceImpl implements HbDataLLineService {
    @Resource
    private HbNodeMapper hbNodeMapper;
    @Resource
    private HbDataLatestMapper hbDatalatestMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void refHbNode(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        HbNode hbNode = new HbNode();

        hbNode.setIperson((int) httpSession.getAttribute(CommUtil.SESSION_PERSON_ID));
        hbNode.setEnterpriseId(requestRefPar.getIntegerPar("enterpriseId"));
        responseData.setData(hbNodeMapper.selectByPerson(hbNode));
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void refHbDataLatest(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        HbDataLatest hbDataLatest = new HbDataLatest();

        hbDataLatest.setIperson((int) httpSession.getAttribute(CommUtil.SESSION_PERSON_ID));
        hbDataLatest.setPrflag(requestRefPar.getIntegerPar("enterpriseId"));
        responseData.setData(hbDatalatestMapper.selectByPerson(hbDataLatest));
    }
}
