package com.aps.env.entity;

/**
 * <dl>
 * <dt>com.aps.env.entity.HbTypeItemException</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/12/17</dd>
 * </dl>
 *
 * @author appleshow
 */
public class HbTypeItemException {
    private String itemId;
    private String itemName;
    private int valueMinCount;
    private int valueMaxCount;
    private int valueAla1Count;
    private int valueAla2Count;
    private int valueAla3Count;
    private HbTypeItemNode hbTypeItemNode;

    public HbTypeItemException(HbTypeItemNode hbTypeItemNode) {
        this.valueMinCount = 0;
        this.valueMaxCount = 0;
        this.valueAla1Count = 0;
        this.valueAla2Count = 0;
        this.valueAla3Count = 0;
        this.hbTypeItemNode = hbTypeItemNode;
    }

    /**
     * @return
     */
    public HbTypeItemException increaseValueMinCount() {
        this.valueMinCount++;
        return this;
    }

    /**
     * @return
     */
    public HbTypeItemException increaseValueMaxCount() {
        this.valueMaxCount++;
        return this;
    }

    /**
     * @return
     */
    public HbTypeItemException increaseValueAla1Count() {
        this.valueAla1Count++;
        return this;
    }

    /**
     * @return
     */
    public HbTypeItemException increaseValueAla2Count() {
        this.valueAla2Count++;
        return this;
    }

    /**
     * @return
     */
    public HbTypeItemException increaseValueAla3Count() {
        this.valueAla3Count++;
        return this;
    }

    /**
     * @return
     */
    public boolean hasException() {
        return this.valueMinCount + this.valueMaxCount + this.valueAla1Count + this.valueAla2Count + this.valueAla3Count > 0 ? true : false;
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

    public int getValueMinCount() {
        return valueMinCount;
    }

    public void setValueMinCount(int valueMinCount) {
        this.valueMinCount = valueMinCount;
    }

    public int getValueMaxCount() {
        return valueMaxCount;
    }

    public void setValueMaxCount(int valueMaxCount) {
        this.valueMaxCount = valueMaxCount;
    }

    public int getValueAla1Count() {
        return valueAla1Count;
    }

    public void setValueAla1Count(int valueAla1Count) {
        this.valueAla1Count = valueAla1Count;
    }

    public int getValueAla2Count() {
        return valueAla2Count;
    }

    public void setValueAla2Count(int valueAla2Count) {
        this.valueAla2Count = valueAla2Count;
    }

    public int getValueAla3Count() {
        return valueAla3Count;
    }

    public void setValueAla3Count(int valueAla3Count) {
        this.valueAla3Count = valueAla3Count;
    }

    public HbTypeItemNode getHbTypeItemNode() {
        return hbTypeItemNode;
    }

    public void setHbTypeItemNode(HbTypeItemNode hbTypeItemNode) {
        this.hbTypeItemNode = hbTypeItemNode;
    }
}
