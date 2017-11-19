package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewFormCfgService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/11</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewFormCfgService {
    void referForm(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyForm(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);

    void referFormRight(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyFormRight(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);
}
