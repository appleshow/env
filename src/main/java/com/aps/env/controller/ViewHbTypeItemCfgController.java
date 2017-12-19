package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.HbTypeItemCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewHbTypeItemCfgController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/19</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewHbTypeItemConfig")
public class ViewHbTypeItemCfgController extends ExceptionController {
    @Resource(name = "hbTypeItemCfgServiceImpl")
    private HbTypeItemCfgService viewHbTypeItemCfgService;
    private final int formId = 11;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referHbType", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referHbType(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referHbType", responseData)) {
            viewHbTypeItemCfgService.referHbType(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referHbTypeItem", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referHbTypeItem(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referHbTypeItem", responseData)) {
            viewHbTypeItemCfgService.referHbTypeItem(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyHbTypeItem", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyHbTypeItem(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyHbTypeItem", responseData)) {
            viewHbTypeItemCfgService.modifyHbTypeItem(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }
}
