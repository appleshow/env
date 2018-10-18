package com.aps.env.controller;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.service.CommService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

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

    /**
     * @param uploadFile
     * @param personId
     * @param nodeId
     * @param uuid
     * @param title
     * @param content
     * @param fileNames
     * @param latitude
     * @param longitude
     * @param httpSession
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData uploadImage(@RequestParam MultipartFile uploadFile,
                                    @RequestParam Integer personId,
                                    @RequestParam Integer nodeId,
                                    @RequestParam String uuid,
                                    @RequestParam String title,
                                    @RequestParam String content,
                                    @RequestParam String fileNames,
                                    @RequestParam(required = false) String latitude,
                                    @RequestParam(required = false) String longitude,
                                    HttpSession httpSession) throws IOException {
        ResponseData responseData = new ResponseData();

        commService.uploadImage(httpSession, uploadFile, personId, nodeId, uuid, title, content, fileNames, latitude, longitude, responseData);

        return responseData;
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @return
     */
    @RequestMapping(value = "referImage", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData referImage(HttpSession httpSession, @RequestBody RequestRefPar requestRefPar) throws ParseException {
        ResponseData responseData = new ResponseData();

        commService.referImage(httpSession, requestRefPar, responseData);

        return responseData;
    }

}
