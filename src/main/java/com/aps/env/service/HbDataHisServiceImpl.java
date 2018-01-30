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
import java.util.Date;
import java.util.List;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbDataHisServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/16</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbDataHisServiceImpl implements HbDataHisService {
    @Resource
    private HbDataModeMapper hbDataModeMapper;

    @Override
    public void refHbDataHis(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer nodeId = requestRefPar.getIntegerPar("nodeId");
        Integer pageNumber = requestRefPar.getIntegerPar("pageNumber");
        Integer pageSize = requestRefPar.getIntegerPar("pageSize");
        String nodeMn = requestRefPar.getStringPar("nodeMn");
        String dataType = requestRefPar.getStringPar("dataType");
        Date dateStr = dateFormat.parse(requestRefPar.getStringPar("dateStr"));
        Date dateEnd = dateFormat.parse(requestRefPar.getStringPar("dateEnd"));
        HbDataModeExample hbDataModeExample = new HbDataModeExample();
        hbDataModeExample.setDataTbale(CommUtil.HB_DATA_CUR + nodeId);
        hbDataModeExample.createCriteria().andDataTypeEqualTo(dataType).andDataTimeBetween(dateStr, dateEnd);
        hbDataModeExample.setOrderByClause("DATA_TIME");

        if (null != pageNumber && null != pageSize) {
            PageInfo<HbDataMode> pageInfo;

            PageHelper.startPage(pageNumber,pageSize);
            List<HbDataMode>  comResources = hbDataModeMapper.selectByExample(hbDataModeExample);
            pageInfo = new PageInfo<>(comResources);
            responseData.setTotalCount(pageInfo.getTotal());
            responseData.setData(comResources);
        } else {
            responseData.setData(hbDataModeMapper.selectByExample(hbDataModeExample));
        }
    }
}
