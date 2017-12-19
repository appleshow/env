package com.aps.env.service;

import com.aps.env.comm.CommUtil;
import com.aps.env.comm.RequestRefPar;
import com.aps.env.comm.ResponseData;
import com.aps.env.dao.HbDataModeMapper;
import com.aps.env.entity.HbDataMode;
import com.aps.env.entity.HbDataModeExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbContrastServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/18</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbContrastServiceImpl implements HbContrastService {
    @Resource
    private HbDataModeMapper hbDataModeMapper;

    @Override
    public void refHbData(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) throws ParseException {
        List<HbDataMode> hbDataModes = new ArrayList<>(), hbDataModesTmp;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PageInfo<HbDataMode> pageInfo;
        String[] nodeIds = requestRefPar.getStringPar("nodeId").split(";");
        String[] nodeMns = requestRefPar.getStringPar("nodeMn").split(";");
        String dataType = requestRefPar.getStringPar("dataType");
        Date dateStr = dateFormat.parse(requestRefPar.getStringPar("dateStr"));
        Date dateEnd = dateFormat.parse(requestRefPar.getStringPar("dateEnd"));

        int totalCount = 0;

        for (int index = 0; index < nodeIds.length; index++) {
            HbDataModeExample hbDataModeExample = new HbDataModeExample();
            hbDataModeExample.setDataTbale(CommUtil.HB_DATA_CUR + nodeIds[index]);
            hbDataModeExample.createCriteria().andNodeMnEqualTo(nodeMns[index]).andDataTypeEqualTo(dataType).andDataTimeBetween(dateStr, dateEnd);
            hbDataModeExample.setOrderByClause("DATA_TIME");


            PageHelper.startPage(requestRefPar.getIntegerPar("pageNumber"), requestRefPar.getIntegerPar("pageSize") / nodeIds.length);
            hbDataModesTmp = hbDataModeMapper.selectByExample(hbDataModeExample);
            pageInfo = new PageInfo<>(hbDataModesTmp);
            totalCount += pageInfo.getTotal();
            hbDataModes.addAll(hbDataModesTmp);
        }
        responseData.setTotalCount(totalCount);
        responseData.setData(hbDataModes.stream().sorted((hbDataMode1, hbDataMode2) -> hbDataMode1.getDataTime().before(hbDataMode2.getDataTime()) ? -1 : 1)
                .collect(Collectors.toList()));
    }
}
