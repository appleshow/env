package com.aps.env.controller;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.comm.StringUtil;
import com.aps.env.service.CommService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.CommController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2017/11/16</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "comm")
public class CommController extends ExceptionController {
    @Resource(name = "commServiceImpl")
    private CommService commService;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referPageShow", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referPageShow(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        commService.referComPageShowByCondition(httpSession, requestRefPar, responseData);

        return responseData;
    }
}
