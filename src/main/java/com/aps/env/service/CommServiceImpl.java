package com.aps.env.service;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.comm.StringUtil;
import com.aps.env.dao.ComPageshowMapper;
import com.aps.env.dao.HbEnforceMapper;
import com.aps.env.entity.ComPageshowExample;
import com.aps.env.entity.HbEnforce;
import com.aps.env.entity.HbEnforceExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <dl>
 * <dt>com.aps.env.service.CommServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/16</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class CommServiceImpl implements CommService {
    @Resource
    private ComPageshowMapper comPageshowMapper;
    @Resource
    private HbEnforceMapper hbEnforceMapper;
    @Value("${ENFORCE_IMAGE}")
    private String enforceImagePath;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     * @see CommService#referComPageShowByCondition(HttpSession,
     * RequestRefPar, ResponseData)
     */
    @Override
    public void referComPageShowByCondition(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comPageShows;
        ComPageshowExample comPageshowExample = new ComPageshowExample();
        Integer pageId = requestRefPar.getIntegerPar("pageId");

        comPageshowExample.createCriteria().andPageIdEqualTo(pageId);
        comPageshowExample.setOrderByClause("PAGE_ID,COLUMN_INDEX");

        comPageShows = comPageshowMapper.selectByExample(comPageshowExample);

        responseData.setData(comPageShows);
    }

    /**
     * @param httpSession
     * @param uploadFile
     * @param personId
     * @param nodeId
     * @param uuid
     * @param title
     * @param content
     * @param fileNames
     * @param latitude
     * @param longitude
     * @param responseData
     * @throws IOException
     */
    @Override
    public void uploadImage(HttpSession httpSession, MultipartFile uploadFile, Integer personId, Integer nodeId, String uuid, String title, String content, String fileNames, String latitude, String longitude, ResponseData responseData) throws IOException {
        String pathRoot = httpSession.getServletContext().getRealPath("");
        String filePath = String.format("%s/%s/%d/%s", StringUtil.isNullOrEmpty(enforceImagePath) ? pathRoot : enforceImagePath, CommUtil.HB_ENFORCE_PIC, nodeId, uuid);
        File file = new File(filePath);
        Date dateNow = new Date();

        if (null != uploadFile && uploadFile.getSize() > 0) {
            if (!file.exists()) {
                file.mkdirs();

                HbEnforce hbEnforce = new HbEnforce();
                hbEnforce.setGuid(uuid);
                hbEnforce.setNodeId(nodeId);
                hbEnforce.setDicName(uuid);
                hbEnforce.setPrflag(1);
                hbEnforce.setIperson(personId);
                hbEnforce.setItime(dateNow);
                hbEnforce.setUperson(personId);
                hbEnforce.setUtime(dateNow);

                hbEnforceMapper.insertSelective(hbEnforce);
            }

            String uploadFileName = uploadFile.getOriginalFilename();
            String saveFile = String.format("%s/%s", filePath, uploadFileName);

            uploadFile.transferTo(new File(saveFile));
        }

        if (!StringUtil.isNullOrEmpty(fileNames)) {
            if ("Delete".equals(fileNames)) {
                if (file.exists()) {
                    Arrays.stream(file.listFiles()).forEach(f -> {
                        if (!f.isDirectory()) {
                            f.delete();
                        }
                    });
                    file.delete();
                }
                hbEnforceMapper.deleteByPrimaryKey(uuid);
            } else {
                final HbEnforce hbEnforce = new HbEnforce();

                Arrays.stream(file.listFiles()).forEach(f -> {
                    if (!f.isDirectory()) {
                        if (fileNames.indexOf(f.getName()) < 0) {
                            f.delete();
                        }
                    }
                });


                hbEnforce.setGuid(uuid);
                hbEnforce.setNodeId(nodeId);
                hbEnforce.setDicName(uuid);
                hbEnforce.setTitle(title);
                hbEnforce.setContent(content);
                hbEnforce.setDicFiles(fileNames);
                hbEnforce.setProperty0(latitude);
                hbEnforce.setProperty1(longitude);
                hbEnforce.setUperson(personId);
                hbEnforce.setUtime(dateNow);

                hbEnforceMapper.updateByPrimaryKeySelective(hbEnforce);
            }
        }

        responseData.setCode(0);
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     * @see CommService#referImage(HttpSession, RequestRefPar, ResponseData)
     */
    @Override
    public void referImage(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer nodeId = requestRefPar.getIntegerPar("nodeId");
        Integer pageNumber = requestRefPar.getIntegerPar("pageNumber");
        Integer pageSize = requestRefPar.getIntegerPar("pageSize");
        String dateStringStr = requestRefPar.getStringPar("dateStr");
        String dateStringEnd = requestRefPar.getStringPar("dateEnd");
        List<HbEnforce> hbEnforces = new ArrayList<>();

        if (!StringUtil.isNullOrEmpty(dateStringStr) && !StringUtil.isNullOrEmpty(dateStringEnd)) {
            Date dateStr = dateFormat.parse(dateStringStr);
            Date dateEnd = dateFormat.parse(dateStringEnd);

            HbEnforceExample hbEnforceExample = new HbEnforceExample();
            hbEnforceExample.createCriteria().andNodeIdEqualTo(nodeId).andItimeBetween(dateStr, dateEnd);
            hbEnforceExample.setOrderByClause("ITIME DESC");

            hbEnforces = hbEnforceMapper.selectByExample(hbEnforceExample);

            hbEnforceMapper.selectByExample(hbEnforceExample);
        } else {
            if (null == pageNumber) {
                pageNumber = 1;
            }
            if (null == pageSize) {
                pageSize = 10;
            }
            HbEnforceExample hbEnforceExample = new HbEnforceExample();
            hbEnforceExample.createCriteria().andNodeIdEqualTo(nodeId);
            hbEnforceExample.setOrderByClause("ITIME DESC");

            PageInfo<HbEnforce> pageInfo;

            PageHelper.startPage(pageNumber, pageSize);
            hbEnforces = hbEnforceMapper.selectByExample(hbEnforceExample);

            pageInfo = new PageInfo<>(hbEnforces);
            responseData.setTotalCount(pageInfo.getTotal());
        }

        if (StringUtil.isNullOrEmpty(enforceImagePath)) {
            hbEnforces.stream().forEach(v -> v.setPrgroup("N"));
        } else {
            hbEnforces.stream().forEach(v -> v.setPrgroup("Y"));
        }

        responseData.setData(hbEnforces);
    }
}
