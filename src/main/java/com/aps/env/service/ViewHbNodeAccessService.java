package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbNodeAccessService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/15</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewHbNodeAccessService {
    void refOrg(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void refNode(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void refNodeAccess(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyNodeAccess(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);
}
