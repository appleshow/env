package com.aps.env.service;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbNodeStatusService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/17</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewHbNodeStatusService {

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    void refNodeStatus(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);
}
