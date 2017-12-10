package com.aps.env.service;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.CommService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/16</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface CommService {

    void referComPageShowByCondition(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);
}