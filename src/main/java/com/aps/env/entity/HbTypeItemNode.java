package com.aps.env.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

/**
 * <dl>
 * <dt>com.aps.env.entity.HbTypeItemNode</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/11</dd>
 * </dl>
 *
 * @author appleshow
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HbTypeItemNode {
    private Integer nodeId;

    private String itemId;

    private String itemName;

    private String itemUnit;

    private String itemUnitConvert;

    private BigDecimal itemVmin;

    private BigDecimal itemVmax;

    private BigDecimal itemVsta;

    private BigDecimal itemVala1;

    private BigDecimal itemVala2;

    private BigDecimal itemVala3;

    private String itemConvertFormat;

    private Integer itemSelect;
    /**
     * 是否为监测参数
     */
    private Integer itemMonitor;

    private Integer itemAlarm;

    private Integer itemOperating;

    private Integer itemLog;

    private Integer itemShowMain;

    @JsonIgnore
    public boolean isSelectMonitorItem() {
        return null != this.getItemSelect() && null != this.getItemMonitor() && 1 == this.getItemSelect() && 1 == this.getItemMonitor() ? true : false;
    }

    @JsonIgnore
    public boolean isAlarmItem() {
        return null != this.getItemAlarm() && 1 == this.getItemAlarm() ? true : false;
    }

    @JsonIgnore
    public boolean isShowMainItem() {
        return null != this.getItemShowMain() && 1 == this.getItemShowMain() ? true : false;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemUnitConvert() {
        return itemUnitConvert;
    }

    public void setItemUnitConvert(String itemUnitConvert) {
        this.itemUnitConvert = itemUnitConvert;
    }

    public BigDecimal getItemVmin() {
        return itemVmin;
    }

    public void setItemVmin(BigDecimal itemVmin) {
        this.itemVmin = itemVmin;
    }

    public BigDecimal getItemVmax() {
        return itemVmax;
    }

    public void setItemVmax(BigDecimal itemVmax) {
        this.itemVmax = itemVmax;
    }

    public BigDecimal getItemVsta() {
        return itemVsta;
    }

    public void setItemVsta(BigDecimal itemVsta) {
        this.itemVsta = itemVsta;
    }

    public BigDecimal getItemVala1() {
        return itemVala1;
    }

    public void setItemVala1(BigDecimal itemVala1) {
        this.itemVala1 = itemVala1;
    }

    public BigDecimal getItemVala2() {
        return itemVala2;
    }

    public void setItemVala2(BigDecimal itemVala2) {
        this.itemVala2 = itemVala2;
    }

    public BigDecimal getItemVala3() {
        return itemVala3;
    }

    public void setItemVala3(BigDecimal itemVala3) {
        this.itemVala3 = itemVala3;
    }

    public String getItemConvertFormat() {
        return itemConvertFormat;
    }

    public void setItemConvertFormat(String itemConvertFormat) {
        this.itemConvertFormat = itemConvertFormat;
    }

    public Integer getItemSelect() {
        return itemSelect;
    }

    public void setItemSelect(Integer itemSelect) {
        this.itemSelect = itemSelect;
    }

    public Integer getItemMonitor() {
        return itemMonitor;
    }

    public void setItemMonitor(Integer itemMonitor) {
        this.itemMonitor = itemMonitor;
    }

    public Integer getItemOperating() {
        return itemOperating;
    }

    public void setItemOperating(Integer itemOperating) {
        this.itemOperating = itemOperating;
    }

    public Integer getItemLog() {
        return itemLog;
    }

    public void setItemLog(Integer itemLog) {
        this.itemLog = itemLog;
    }

    public Integer getItemAlarm() {
        return itemAlarm;
    }

    public void setItemAlarm(Integer itemAlarm) {
        this.itemAlarm = itemAlarm;
    }

    public Integer getItemShowMain() {
        return itemShowMain;
    }

    public void setItemShowMain(Integer itemShowMain) {
        this.itemShowMain = itemShowMain;
    }
}
