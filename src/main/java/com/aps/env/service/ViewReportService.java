package com.aps.env.service;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewReportService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2018/8/7</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewReportService {
    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     * @throws ParseException
     */
    void reportD(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) throws IOException;
}
