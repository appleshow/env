package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.ViewEntTypeCfgService;
import com.aps.env.service.ViewPageShowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewEntTypeCfgController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/18</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewEntTypeConfig")
public class ViewEntTypeCfgController extends ExceptionController {
    @Resource(name = "viewEntTypeCfgServiceImpl")
    private ViewEntTypeCfgService viewEntTypeCfgService;
    private int formId = 19;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "refEntType", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refEntType(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refEntType", responseData)) {
            viewEntTypeCfgService.refEntType(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }


    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyEntType", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyEntType(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyEntType", responseData)) {
            viewEntTypeCfgService.modifyEntType(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }
}
