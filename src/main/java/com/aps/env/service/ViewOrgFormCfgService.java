package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewOrgFormCfgService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewOrgFormCfgService {
    void referOrg(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void referForm(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void referOrgForm(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void referFormRights(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void referOrgFormRights(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyOrgForm(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);

    void modifyOrgFormRights(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);
}
