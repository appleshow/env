package com.aps.env.controller;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestMdyPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.comm.StringUtil;
import com.aps.env.service.ViewMainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.controller.ViewMainController</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/9</dd>
 * </dl>
 *
 * @author appleshow
 */
@Controller
@RequestMapping(value = "viewMain")
public class ViewMainController extends ExceptionController {
    @Resource(name = "viewMainServiceImpl")
    private ViewMainService viewMainService;

    /**
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "personMenu", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData personMenu(HttpSession httpSession) {
        ResponseData responseData = new ResponseData();

        viewMainService.referPersonMenu(httpSession, null, responseData);

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @return
     */
    @RequestMapping(value = "updatePersonPSW", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updatePersonPSW(HttpSession httpSession, @RequestBody RequestMdyPar requestMdyPar) {
        ResponseData responseData = new ResponseData();

        viewMainService.modifyPersonPassword(httpSession, requestMdyPar, responseData);

        return responseData;
    }

    /**
     * @param httpSession
     * @param url
     * @return
     */
    @RequestMapping(value = "showPage", method = RequestMethod.GET)
    public ModelAndView showPage(HttpSession httpSession, @RequestParam("url") String url) {
        final ModelAndView modelAndView = new ModelAndView();

        if (null == httpSession.getAttribute(CommUtil.SESSION_PERSON_ID) || null == url || "".equals(url.trim())) {
            httpSession.removeAttribute(CommUtil.SESSION_PERSON_ID);
            httpSession.invalidate();

            modelAndView.setViewName("reload");
        } else {
            Map<String, String> convertUrl = StringUtil.convertUrl(url);
            convertUrl.forEach((key, value) -> {
                if (!key.equals("url")) {
                    modelAndView.addObject(key, value);
                    if (key.equals("pageId")) {
                        int pageId = Integer.parseInt(value);
                        switch (pageId) {
                            case 19:
                                modelAndView.addObject("codeName", "企业分类名称");
                                break;
                            case 20:
                                modelAndView.addObject("codeName", "设备厂商名称");
                                break;
                            case 21:
                                modelAndView.addObject("codeName", "设备型号名称");
                                break;
                            default:
                                break;
                        }
                    }
                }
            });

            modelAndView.setViewName(convertUrl.get("url"));
        }

        return modelAndView;
    }
}
