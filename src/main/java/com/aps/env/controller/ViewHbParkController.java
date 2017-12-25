package com.aps.env.controller;

import com.aps.env.comm.*;
import com.aps.env.service.HbParkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.HbParkController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/20</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "hbParkCfg")
public class ViewHbParkController extends ExceptionController {
    @Resource(name = "hbParkServiceImpl")
    private HbParkService hbParkService;
    int formId = 33;

    @RequestMapping(value = "refHbPark", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refHbPark(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refHbPark", responseData)) {
            hbParkService.refHbPark(httpSession, requestRefPar, responseData);
        }
        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "modifyHbPark", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyHbPark(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "modifyHbPark", responseData)) {
            hbParkService.modifyHbPark(httpSession, requestMdyPar, responseData);
        }

        return responseData;
    }

    @RequestMapping(value = "refHbParkDataByPar", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refHbParkDataByPar(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, 0, "refHbParkDataByPar", responseData)) {
            hbParkService.refHbParkDataByPar(httpSession, requestRefPar, responseData);
        }
        return responseData;
    }
}
