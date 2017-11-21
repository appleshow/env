package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.ViewComCodeCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewComCodeCfgController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/18</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewComCodeConfig")
public class ViewComCodeCfgController extends ExceptionController {
    @Resource(name = "viewComCodeCfgServiceImpl")
    private ViewComCodeCfgService viewComCodeCfgService;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "refComCode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refComCode(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        viewComCodeCfgService.refComCode(httpSession, requestRefPar, responseData);

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyComCode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyComCode(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();
        int formId = 0;
        String codeType = requestMdyPar.getInPar().get(0).get("codeType");

        if (!StringUtil.isNullOrEmpty(codeType)) {
            formId = Integer.parseInt(codeType);
        }
        if (CommUtil.isPermissoned(httpSession, formId, "modifyComCode", responseData)) {
            viewComCodeCfgService.modifyComCode(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "refComRegion", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refComRegion(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        viewComCodeCfgService.refComRegion(httpSession, requestRefPar, responseData);

        return responseData;
    }
}
