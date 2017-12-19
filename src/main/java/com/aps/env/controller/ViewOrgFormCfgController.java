package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.ComCodeCfgService;
import com.aps.env.service.OrgFormCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewOrgFormCfgController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewOrgFormConfig")
public class ViewOrgFormCfgController extends ExceptionController {
    @Resource(name = "orgFormCfgServiceImpl")
    private OrgFormCfgService viewOrgFormCfgService;
    @Resource(name = "comCodeCfgServiceImpl")
    private ComCodeCfgService viewComCodeCfgService;
    private final int formId = 6;

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
            viewOrgFormCfgService.referOrg(httpSession, requestRefPar, responseData);
        }
        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referForm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referForm(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referForm", responseData)) {
            viewOrgFormCfgService.referForm(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referOrgForm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referOrgForm(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referOrgForm", responseData)) {
            viewOrgFormCfgService.referOrgForm(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referFormRights", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referFormRights(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referFormRights", responseData)) {
            viewOrgFormCfgService.referFormRights(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referOrgFormRights", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referOrgFormRights(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referOrgFormRights", responseData)) {
            viewOrgFormCfgService.referOrgFormRights(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referCombCode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referCombCode(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referCombCode", responseData)) {
            viewComCodeCfgService.refComCode(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyOrgForm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyOrgForm(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyOrgForm", responseData)) {
            viewOrgFormCfgService.modifyOrgForm(httpSession, requestMdyPar, responseData);
        }
        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyOrgFormRights", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyOrgFormRights(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyOrgFormRights", responseData)) {
            viewOrgFormCfgService.modifyOrgFormRights(httpSession, requestMdyPar, responseData);
        }
        return responseData;
    }
}
