package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.HbNodeContactService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2018/8/18</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface HbNodeContactService {
    void refData(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyData(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);
}
