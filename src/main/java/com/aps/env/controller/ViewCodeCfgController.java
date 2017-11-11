package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.ViewCodeCfgService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewCodeConfigController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewCodeConfig")
public class ViewCodeCfgController extends ExceptionController {
    @Resource(name = "viewCodeCfgServiceImpl")
    private ViewCodeCfgService viewCodeCfgService;

    private final int formId = 1;

    /**
     * @param httpSession
     * @param inPar
     * @return
     */
    @RequestMapping(value = "referCode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referCode(HttpSession httpSession, @RequestParam("inf") String inPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referCode", responseData)) {
            viewCodeCfgService.referCode(httpSession, JsonUtil.readRequestRefPar(inPar), responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyCode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyCode(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyCode", responseData)) {
            viewCodeCfgService.modifyCode(httpSession, StringUtil.conversionRequestMdyData(requestMdyPar), responseData);
        }

        return responseData;
    }
}
