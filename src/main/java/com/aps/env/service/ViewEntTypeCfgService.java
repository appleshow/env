package com.aps.env.service;

import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.entity.ComCode;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewEntTypeCfgService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/18</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface ViewEntTypeCfgService {

    void refEntType(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void modifyEntType(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData);

}
