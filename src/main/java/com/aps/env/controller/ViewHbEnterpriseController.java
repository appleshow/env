package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.ViewHbEnterpriseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewHbEnterpriseController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/25</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewHbEnterpriseCfg")
public class ViewHbEnterpriseController extends ExceptionController {
    @Resource(name = "viewHbEnterpriseServiceImpl")
    private ViewHbEnterpriseService viewHbEnterpriseService;
    private final int formId = 23;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "refEnterprise", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refEnterprise(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refEnterprise", responseData)) {
            viewHbEnterpriseService.refEnterprise(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyEnterprise", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyEnterprise(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyEnterprise", responseData)) {
            viewHbEnterpriseService.modifyEnterprise(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }
}
