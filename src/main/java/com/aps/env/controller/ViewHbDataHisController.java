package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.JsonUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.ViewHbDataHisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewHbDataHisController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/16</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewHbDataHis")
public class ViewHbDataHisController extends ExceptionController {
    @Resource(name = "viewHbDataHisServiceImpl")
    private ViewHbDataHisService viewHbDataHisService;

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "refHbDataHis", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData refHbDataHis(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) throws ParseException {
        ResponseData responseData = new ResponseData();

        if (CommUtil.isPermissoned(httpSession, 0, "refHbDataHis", responseData)) {
            viewHbDataHisService.refHbDataHis(httpSession, requestRefPar, responseData);
        }

        return responseData;
    }
}
