package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewCodeCfgService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewCodeCfgService {
    void referCode(HttpSession session, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyCode(HttpSession session, RequestMdyPar requestMdyPar, ResponseData responseData);
}
