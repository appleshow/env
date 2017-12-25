package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.service.HbParkService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/20</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface HbParkService {
    void refHbPark(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyHbPark(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);

    void refHbParkDataByPar(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);
}
