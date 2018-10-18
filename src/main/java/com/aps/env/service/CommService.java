package com.aps.env.service;

import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

/**
 * <dl>
 * <dt>com.aps.env.service.CommService</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/16</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface CommService {

    void referComPageShowByCondition(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData);

    void uploadImage(HttpSession httpSession, MultipartFile uploadFile, Integer personId, Integer nodeId, String uuid, String title, String content, String fileNames, String latitude, String longitude, ResponseData responseData) throws IOException;

    void referImage(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) throws ParseException;
}
