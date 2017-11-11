package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewMenuCfgService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewMenuCfgService {

    void referMenu(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyMenu(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);

    void referAllForms(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);
}
