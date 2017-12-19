package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.HbNodeStatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewHbNodeStatisticController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/18</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewHbNodeStatistic")
public class ViewHbNodeStatisticController extends ExceptionController {
    @Resource(name = "hbNodeStatisticServiceImpl")
    private HbNodeStatisticService viewHbNodeStatisticService;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "refHbData", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refHbData(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) throws ParseException {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, 0, "refHbData", responseData)) {
            viewHbNodeStatisticService.refHbData(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }
}
