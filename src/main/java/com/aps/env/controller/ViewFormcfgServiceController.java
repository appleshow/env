package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.ViewFormCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewFormcfgServiceController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/11</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewFormConfig")
public class ViewFormcfgServiceController extends ExceptionController {
    @Resource(name = "viewFormCfgServiceImpl")
    private ViewFormCfgService viewFormCfgService;
    private final int formId = 4;

    /**
     * @param httpSession
     * @param inPar
     * @return
     */
    @RequestMapping(value = "referForm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referForm(HttpSession httpSession, @RequestParam("inf") String inPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referForm", responseData)) {
            viewFormCfgService.referForm(httpSession, JsonUtil.readRequestRefPar(inPar), responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyForm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyForm(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyForm", responseData)) {
            viewFormCfgService.modifyForm(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param inPar
     * @return
     */
    @RequestMapping(value = "referFormRight", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referFormRight(HttpSession httpSession, @RequestParam("inf") String inPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referFormRight", responseData)) {
            viewFormCfgService.referFormRight(httpSession, JsonUtil.readRequestRefPar(inPar), responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyFormRight", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyFormRight(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyFormRight", responseData)) {
            viewFormCfgService.modifyFormRight(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referFormCtlType", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referFormCtlType(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referFormCtlType", responseData)) {
            viewFormCfgService.referFormCtlType(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }
}
