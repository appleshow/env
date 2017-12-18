package com.aps.env.service;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbNodeStatisticService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/18</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewHbNodeStatisticService {
    void refHbData(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) throws ParseException;
}
