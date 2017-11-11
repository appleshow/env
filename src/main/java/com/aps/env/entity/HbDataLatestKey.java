package com.aps.env.entity;

import java.util.Date;

public class HbDataLatestKey {
    private String nodeMn;

    private Date dataTime;

    public String getNodeMn() {
        return nodeMn;
    }

    public void setNodeMn(String nodeMn) {
        this.nodeMn = nodeMn == null ? null : nodeMn.trim();
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }
}