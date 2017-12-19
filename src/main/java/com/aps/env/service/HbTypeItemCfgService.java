package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.HbTypeItemCfgService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/19</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface HbTypeItemCfgService {

    void referHbType(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void referHbTypeItem(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyHbTypeItem(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);

}
