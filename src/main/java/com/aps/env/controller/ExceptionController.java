package com.aps.env.controller;

import com.aps.env.comm.ResponseData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <dl>
 * <dt>com.aps.env.controller.ExceptionController</dt>
 * <dd>Description: </dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/7</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
public abstract class ExceptionController {
    private static final Logger LOG = LogManager.getLogger(ExceptionController.class);

    /**
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public ResponseData exception(HttpServletRequest request, Exception e) {
        ResponseData responseData = new ResponseData();

        LOG.error(e);
        responseData.setData(e);

        return responseData;
    }
}
