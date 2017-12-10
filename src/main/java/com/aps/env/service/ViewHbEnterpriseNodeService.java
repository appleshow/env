package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbEnterpriseNodeService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    Appleshow Technology </dd>
 * <dd>CreateDate: 2017/12/10</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewHbEnterpriseNodeService {
    void refNodeType(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void refEnterpriseNode(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyEnterpriseNode(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);
}
