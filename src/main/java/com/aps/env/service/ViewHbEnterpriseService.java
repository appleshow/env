package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbEnterpriseService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    appleshow Technology </dd>
 * <dd>CreateDate: 2017/11/25</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewHbEnterpriseService {
    void refEnterprise(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyEnterprise(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);
}
