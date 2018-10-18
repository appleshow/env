package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.ViewReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewReportController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2018/8/6</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewReport")
public class ViewReportController extends CommController {
    @Resource(name = "viewReportServiceImpl")
    private ViewReportService viewReportService;
    private final int formId = 0;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "reportD", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData reportD(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) throws IOException {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, formId, "referData", responseData)) {
            viewReportService.reportD(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }
}
