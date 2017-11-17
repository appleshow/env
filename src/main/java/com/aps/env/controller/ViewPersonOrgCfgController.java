package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.ViewOrgCfgService;
import com.aps.env.service.ViewPersonCfgService;
import com.aps.env.service.ViewPersonOrgCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewPersonOrgCfgController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/17</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewPersonOrgConfig")
public class ViewPersonOrgCfgController extends ExceptionController {
    @Resource(name = "viewOrgCfgServiceImpl")
    private ViewOrgCfgService viewOrgCfgService;
    @Resource(name = "viewPersonCfgServiceImpl")
    private ViewPersonCfgService viewPersonCfgService;
    @Resource(name = "viewPersonOrgCfgServiceImpl")
    private ViewPersonOrgCfgService viewPersonOrgCfgService;
    private final int formId = 7;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referPerson", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referPerson(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referPerson", responseData)) {
            viewPersonCfgService.referPerson(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @throws @since 1.0.0
     * @Title: referComOrg
     * @Description: TODO
     * @param: @param
     * httpSession
     * @param: @param
     * inPar
     * @param: @return
     * @return: String
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
     * @throws @since 1.0.0
     * @Title: referComPersonOrg
     * @Description: TODO
     * @param: @param
     * httpSession
     * @param: @param
     * inPar
     * @param: @return
     * @return: String
     */
    @RequestMapping(value = "referPersonOrg", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referPersonOrg(HttpSession httpSession, @RequestParam("inf") String inPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referPersonOrg", responseData)) {
            viewPersonOrgCfgService.referPersonOrg(httpSession, JsonUtil.readRequestRefPar(inPar), responseData);
        }
        return responseData;
    }

    /**
     * @throws @since 1.0.0
     * @Title: mydComPersonOrg
     * @Description: TODO
     * @param: @param
     * httpSession
     * @param: @param
     * inPar
     * @param: @return
     * @return: String
     */
    @RequestMapping(value = "modifyPersonOrg", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyPersonOrg(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyPersonOrg", responseData)) {
            viewPersonOrgCfgService.modifyPersonOrg(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }
}
