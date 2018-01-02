package com.aps.env.controller;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.LoginViewService;
import com.aps.env.service.PreLoginHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.controller.LoginController</dt>
 * <dd>Description: 登入相关功能Controller</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/7</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
public class LoginController extends ExceptionController {
    @Resource(name = "loginViewServiceImpl")
    private LoginViewService loginViewService;
    @Resource(name = "perLoginHandlerVerification")
    PreLoginHandler preLoginHandler;

    @RequestMapping(value = "/")
    public ModelAndView indexPage(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("verification", "0");
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping(value = "/main")
    public ModelAndView mainPage(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("verification", "0");
        modelAndView.setViewName("index");

        return modelAndView;
    }

    /**
     * 请求登入验证码
     *
     * @throws
     * @Title: perVerificationImg
     * @Description: 请求登入验证码
     * @param: @param session
     * @param: @return
     * @param: @throws Exception
     * @return: Map<?,?>
     * @since 1.0.0
     */
    @RequestMapping(value = "/perVerificationImg", method = RequestMethod.POST)
    @ResponseBody
    public Map<?, ?> perVerificationImg(HttpSession httpSession) throws Exception {
        return preLoginHandler.handle(httpSession);
    }

    /**
     * 提交登入
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param userId
     * @param password
     * @param verification
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam("userId") String userId,
                              @RequestParam("password") String password, @RequestParam("verification") String verification) {
        return loginViewService.tryToLogin(userId, password, verification, httpServletRequest, httpServletResponse);
    }

    /**
     * 提交登入Mobile
     *
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "/loginMobile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData loginMobile(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        loginViewService.tryToLoginMobile(httpSession, requestRefPar, responseData);

        return responseData;
    }

}
