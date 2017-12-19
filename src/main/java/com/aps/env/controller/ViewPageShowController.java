package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.PageShowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewPageShowController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/11</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewPageShow")
public class ViewPageShowController extends ExceptionController {
    @Resource(name = "pageShowServiceImpl")
    private PageShowService viewPageShowService;
    private int formId = 9;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referAllForms", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referAllForms(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referAllForms", responseData)) {
            viewPageShowService.referAllForms(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referPageShow", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referPageShow(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referPageShow", responseData)) {
            viewPageShowService.referPageShow(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyPageShow", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyPageShow(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyPageShow", responseData)) {
            viewPageShowService.modifyPageShow(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }
}
