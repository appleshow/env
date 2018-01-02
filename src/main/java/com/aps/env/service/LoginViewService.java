package com.aps.env.service;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.entity.ComOrgFormRights;
import com.aps.env.entity.ComPerson;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <dl>
 * <dt>com.aps.env.service.LoginViewService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/8</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface LoginViewService {

    ComPerson selectPersoinByPrimaryKey(Integer personId);

    ComPerson selectPersonByUserId(String userId);

    List<ComOrgFormRights> selectPersonPermissions(Integer personId);

    ModelAndView tryToLogin(String userId, String password, String verification, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    void tryToLoginMobile(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);
}
