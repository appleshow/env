package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewComCodeCfgService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/18</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewComCodeCfgService {
    void refComCode(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyComCode(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);

    void refComRegion(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);
}
