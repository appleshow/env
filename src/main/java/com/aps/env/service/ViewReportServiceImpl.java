package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbDataModeMapper;
import com.aps.env.entity.HbDataMode;
import com.aps.env.entity.HbDataModeExample;
import com.aps.env.entity.ReportTable;
import com.aps.env.entity.ReportTableItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewReportServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2018/8/7</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class ViewReportServiceImpl implements ViewReportService {
    @Resource
    private HbDataModeMapper hbDataModeMapper;
    final private String[] D10_PAR = {
            //颗粒物(烟尘)
            "01;a34013",
            //颗粒物(烟尘) 折算值
            "01-ZsAvg;a34013-ZsAvg",
            //颗粒物(烟尘) 排量
            "",
            //SO2
            "02;a21026",
            //SO2 折算值
            "02-ZsAvg;a21026-ZsAvg",
            //SO2 排量
            "",
            //NOx
            "03;a21002",
            //NOx 折算值
            "03-ZsAvg;a21002-ZsAvg",
            //NOx 排量
            "",
            //标态流量
            "S02;a01011",
            //氧量
            "S01;a19001",
            //烟温
            "S03;a01012",
            //含湿量
            "S05;a01014",
            //负荷
            "",
            //备注
            "",
    };

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     * @throws ParseException
     */
    @Override
    public void reportD(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) throws IOException {
        final int dataColumnSize = 15;
        final int dataRows = requestRefPar.getIntegerPar("dataRows");
        final int startCheck = requestRefPar.getIntegerPar("startCheck");
        final String type = requestRefPar.getStringPar("type");
        final String pattern = requestRefPar.getStringPar("pattern");
        final Integer nodeId = requestRefPar.getIntegerPar("nodeId");
        final Date dateStr = DateUtil.fromString(requestRefPar.getStringPar("dateStr"), DateUtil.SIMPLE_DATE_FORMAT1);
        final Date dateEnd = DateUtil.fromString(requestRefPar.getStringPar("dateEnd"), DateUtil.SIMPLE_DATE_FORMAT1);

        HbDataModeExample hbDataModeExample = new HbDataModeExample();
        hbDataModeExample.setDataTbale(CommUtil.HB_DATA_CUR + nodeId);
        hbDataModeExample.createCriteria().andDataTypeEqualTo("2061").andDataTimeBetween(dateStr, dateEnd);
        hbDataModeExample.setOrderByClause("DATA_TIME");

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        List<HbDataMode> hbDataModeList = hbDataModeMapper.selectByExample(hbDataModeExample);

        List<ReportTable> reportTableList = new ArrayList<>();
        Map<Integer, List<ReportTableItem>> reportTableItemMap = new HashMap<>();

        int check = startCheck;
        initReportTableItemMap(reportTableItemMap, check, dataColumnSize);
        for (HbDataMode hbDataMode : hbDataModeList) {
            int beCheck = Integer.parseInt(simpleDateFormat.format(hbDataMode.getDataTime()));

            if (beCheck == 0 && "D10".equals(type)) {
                beCheck = 24;
            }
            if (beCheck != check) {
                if (beCheck != check + 1) {
                    for (int gapCheck = check + 1; gapCheck < beCheck; gapCheck++) {
                        reportTableItemMap.put(gapCheck, new ArrayList<>());
                    }
                }
                initReportTableItemMap(reportTableItemMap, beCheck, dataColumnSize);

                check = beCheck;
            }

            readParValueAll(check, D10_PAR, JsonUtil.getObjectMapper().readValue(hbDataMode.getNodeData(), Map.class), reportTableItemMap);
        }
        for (int empty = check + 1; empty <= (startCheck - 1) + dataRows; empty++) {
            reportTableItemMap.put(empty, new ArrayList<>());
        }

        reportTableItemMap.forEach((rowIndex, tableItemList) -> reportTableList.add(getReportTableFromItem(rowIndex, type, "AVG", false, tableItemList)));

        addStatisticsData(dataColumnSize, reportTableList, reportTableItemMap);

        ReportTable reportTableSampleCount = new ReportTable("样本数");
        hbDataModeExample = new HbDataModeExample();
        hbDataModeExample.setDataTbale(CommUtil.HB_DATA_CUR + nodeId);
        hbDataModeExample.createCriteria().andDataTypeEqualTo("2011").andDataTimeBetween(dateStr, dateEnd);
        String sampleCount = String.valueOf(hbDataModeMapper.countByExample(hbDataModeExample));
        reportTableSampleCount.setC2(sampleCount).setC3(sampleCount).setC5(sampleCount).setC6(sampleCount)
                .setC8(sampleCount).setC8(sampleCount).setC9(sampleCount).setC11(sampleCount).setC12(sampleCount).setC13(sampleCount).setC14(sampleCount);
        reportTableList.add(reportTableSampleCount);

        reportTableList.add(new ReportTable("日排放总量(t)"));

        responseData.setTotalCount(reportTableList.size());
        responseData.setData(reportTableList);
    }

    /**
     * @param rowIndex
     */
    public void initReportTableItemMap(Map<Integer, List<ReportTableItem>> reportTableItemMap, int rowIndex, int size) {
        List<ReportTableItem> reportTableItemList = new ArrayList<>();

        for (int index = 1; index <= size; index++) {
            reportTableItemList.add(new ReportTableItem());
        }

        reportTableItemMap.put(rowIndex, reportTableItemList);
    }

    /**
     * @param parName
     * @param rowIndex
     * @param colIndex
     * @param dataMap
     * @param reportTableItemMap
     */
    public void readParValue(String parName, int rowIndex, int colIndex, Map<String, String> dataMap, Map<Integer, List<ReportTableItem>> reportTableItemMap) {
        if (dataMap.containsKey(parName)) {
            reportTableItemMap.get(rowIndex).get(colIndex).addValue(Float.parseFloat(dataMap.get(parName)));
        }
    }

    /**
     * @param rowIndex
     * @param parArray
     * @param dataMap
     * @param reportTableItemMap
     */
    public void readParValueAll(int rowIndex, String[] parArray, Map<String, String> dataMap, Map<Integer, List<ReportTableItem>> reportTableItemMap) {
        for (int colIndex = 0; colIndex < parArray.length; colIndex++) {
            String pars = parArray[colIndex];
            if (!StringUtil.isNullOrEmpty(pars)) {
                for (String par : pars.split(";")) {
                    readParValue(par, rowIndex, colIndex, dataMap, reportTableItemMap);
                }
            }
        }
    }

    /**
     * @param rowIndex
     * @param type
     * @param method
     * @param ignoreZero
     * @param reportTableItemList
     * @return
     */
    private ReportTable getReportTableFromItem(int rowIndex, String type, String method, boolean ignoreZero, List<ReportTableItem> reportTableItemList) {
        ReportTable reportTable = new ReportTable();

        reportTable.setC1(rowIndex, type);
        for (int colIndex = 0; colIndex < reportTableItemList.size(); colIndex++) {
            reportTable.setColumnValue(colIndex + 2, method, ignoreZero, 2, reportTableItemList.get(colIndex));
        }

        return reportTable;
    }

    /**
     * @param dataColumnSize
     * @param reportTableList
     * @param reportTableItemMap
     */
    private void addStatisticsData(int dataColumnSize, List<ReportTable> reportTableList, Map<Integer, List<ReportTableItem>> reportTableItemMap) {
        final List<ReportTableItem> reportTableItemListResult = new ArrayList<>();

        for (int index = 1; index <= dataColumnSize; index++) {
            reportTableItemListResult.add(new ReportTableItem());
        }

        reportTableItemMap.forEach((rowIndex, reportTableItems) -> {
            for (int index = 0; index < reportTableItems.size(); index++) {
                reportTableItemListResult.get(index).addValue(reportTableItems.get(index).getAvgValue(false));
            }
        });

        ReportTable reportTableA = new ReportTable("平均值");
        ReportTable reportTableB = new ReportTable("最大值");
        ReportTable reportTableC = new ReportTable("最小值");

        for (int index = 0; index < reportTableItemListResult.size(); index++) {
            reportTableA.setColumnValue(index + 2, "AVG", true, 2, reportTableItemListResult.get(index));
            reportTableB.setColumnValue(index + 2, "MAX", true, 2, reportTableItemListResult.get(index));
            reportTableC.setColumnValue(index + 2, "MIN", true, 2, reportTableItemListResult.get(index));
        }

        reportTableList.add(reportTableA);
        reportTableList.add(reportTableB);
        reportTableList.add(reportTableC);
    }
}
