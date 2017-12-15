package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.ViewHbNodeAccessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewHbNodeAccessController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/15</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewHbNodeAccessCfg")
public class ViewHbNodeAccessController extends ExceptionController {
    @Resource(name = "viewHbNodeAccessServiceImpl")
    private ViewHbNodeAccessService viewHbNodeAccessService;
    private final int formId = 18;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "refOrg", method = RequestMethod.POST)
    public ResponseData refOrg(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refOrg", responseData)) {
            viewHbNodeAccessService.refOrg(httpSession, requestRefPar, responseData);
        }

        return responseData;

    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "refNode", method = RequestMethod.POST)
    public ResponseData refNode(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refNode", responseData)) {
            viewHbNodeAccessService.refNode(httpSession, requestRefPar, responseData);
        }

        return responseData;

    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "refNodeAccess", method = RequestMethod.POST)
    public ResponseData refNodeAccess(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refNodeAccess", responseData)) {
            viewHbNodeAccessService.refNodeAccess(httpSession, requestRefPar, responseData);
        }

        return responseData;

    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "modifyNodeAccess", method = RequestMethod.POST)
    public ResponseData modifyNodeAccess(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyNodeAccess", responseData)) {
            viewHbNodeAccessService.modifyNodeAccess(httpSession, requestMdyPar, responseData);
        }

        return responseData;

    }
}
