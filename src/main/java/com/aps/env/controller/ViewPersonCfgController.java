package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.ViewOrgCfgService;
import com.aps.env.service.ViewPersonCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewPersonCfgController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/17</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewPersonConfig")
public class ViewPersonCfgController extends ExceptionController {
    @Resource(name = "viewPersonCfgServiceImpl")
    private ViewPersonCfgService viewPersonCfgService;
    @Resource(name = "viewOrgCfgServiceImpl")
    private ViewOrgCfgService viewOrgCfgService;
    private final int formId = 3;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referOrg", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referOrg(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referOrg", responseData)) {
            viewOrgCfgService.referOrg(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param inPar
     * @return
     */
    @RequestMapping(value = "referPerson", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referPerson(HttpSession httpSession, @RequestParam("inf") String inPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referPerson", responseData)) {
            viewPersonCfgService.referPerson(httpSession, JsonUtil.readRequestRefPar(inPar), responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyPerson", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyPerson(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyPerson", responseData)) {
            viewPersonCfgService.modifyPerson(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }
}
