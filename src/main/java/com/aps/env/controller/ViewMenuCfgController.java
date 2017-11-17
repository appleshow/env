package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.ViewMenuCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewMenuConfigController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewMenuConfig")
public class ViewMenuCfgController extends ExceptionController {
    @Resource(name = "viewMenuCfgServiceImpl")
    private ViewMenuCfgService viewMenuCfgService;
    private final int formId = 5;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referMenuTree", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referMenuTree(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referMenu", responseData)) {
            viewMenuCfgService.referMenu(httpSession, requestRefPar, responseData);
        }
        return responseData;
    }

    /**
     * @param httpSession
     * @param inPar
     * @return
     */
    @RequestMapping(value = "referMenu", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referMenu(HttpSession httpSession, @RequestParam("inf") String inPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referMenu", responseData)) {
            viewMenuCfgService.referMenu(httpSession, JsonUtil.readRequestRefPar(inPar), responseData);
        }
        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyMenu", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyMenu(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyMenu", responseData)) {
            viewMenuCfgService.modifyMenu(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }

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
            viewMenuCfgService.referAllForms(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }
}
