package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.ViewHbNodeStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewHbNodeStatusController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/17</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewHbNodeStatus")
public class ViewHbNodeStatusController extends ExceptionController {
    @Resource(name = "viewHbNodeStatusServiceImpl")
    private ViewHbNodeStatusService viewHbNodeStatusService;
    private final int formId = 16;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "refNodeStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refNodeStatus(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refNodeStatus", responseData)) {
            viewHbNodeStatusService.refNodeStatus(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }
}
