package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.HbNodeMapService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.HbNodeMapController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/19</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "hbNodeMap")
public class HbNodeMapController extends ExceptionController {
    @Resource(name = "hbNodeMapServiceImpl")
    private HbNodeMapService hbNodeMapService;

    @RequestMapping(value = "refHbNodeJoinLatestData", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refHbNodeJoinLatestData(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, 0, "refHbNodeJoinLatestData", responseData)) {
            hbNodeMapService.refHbNodeJoinLatestData(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }
}
