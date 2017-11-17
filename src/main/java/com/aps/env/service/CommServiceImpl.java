package com.aps.env.service;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.dao.ComPageshowMapper;
import com.aps.env.entity.ComPageshow;
import com.aps.env.entity.ComPageshowExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <dl>
 * <dt>com.aps.env.service.CommServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/16</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class CommServiceImpl implements CommService {
    @Resource
    private ComPageshowMapper comPageshowMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     * @see CommService#referComPageShowByCondition(HttpSession,
     * RequestRefPar, ResponseData)
     */
    @Override
    public void referComPageShowByCondition(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comPageShows;
        ComPageshowExample comPageshowExample = new ComPageshowExample();
        Integer pageId = requestRefPar.getIntegerPar("pageId");

        comPageshowExample.createCriteria().andPageIdEqualTo(pageId);
        comPageshowExample.setOrderByClause("PAGE_ID,COLUMN_INDEX");

        comPageShows = comPageshowMapper.selectByExample(comPageshowExample);

        responseData.setData(comPageShows);
    }
}
