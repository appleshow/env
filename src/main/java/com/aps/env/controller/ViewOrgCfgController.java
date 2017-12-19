package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.OrgCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewOrgConfigController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewOrgConfig")
public class ViewOrgCfgController extends ExceptionController {
    @Resource(name = "orgCfgServiceImpl")
    private OrgCfgService viewOrgCfgService;
    private final int formId = 2;

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
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyOrg", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyOrg(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyOrg", responseData)) {
            viewOrgCfgService.modifyOrg(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }
}
