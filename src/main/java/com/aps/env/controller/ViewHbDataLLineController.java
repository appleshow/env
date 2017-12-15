package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.ViewHbDataLLineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewHbDataLLineController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/15</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewHbDataLLine")
public class ViewHbDataLLineController extends ExceptionController {
    @Resource(name = "viewHbDataLLineServiceImpl")
    private ViewHbDataLLineService viewHbDataLLineService;
    private final int formId = 13;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "refHbNode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refHbNode(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refHbNode", responseData)) {
            viewHbDataLLineService.refHbNode(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "refHbDataLatest", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refHbDataLatest(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "refHbDataLatest", responseData)) {
            viewHbDataLLineService.refHbDataLatest(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }
}
