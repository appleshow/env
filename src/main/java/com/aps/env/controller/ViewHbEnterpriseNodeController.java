package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.HbEnterpriseNodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewHbEnterpriseNodeController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewHbEnterpriseNodeCfg")
public class ViewHbEnterpriseNodeController extends ExceptionController {
    @Resource(name = "hbEnterpriseNodeServiceImpl")
    private HbEnterpriseNodeService viewHbEnterpriseNodeService;
    private int formId = 27;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "refNodeType", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refNodeType(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refNodeType", responseData)) {
            viewHbEnterpriseNodeService.refNodeType(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "refEnterpriseNode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refEnterpriseNode(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refEnterpriseNode", responseData)) {
            viewHbEnterpriseNodeService.refEnterpriseNode(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyEnterpriseNode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyEnterpriseNode(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyEnterpriseNode", responseData)) {
            viewHbEnterpriseNodeService.modifyEnterpriseNode(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }
}
