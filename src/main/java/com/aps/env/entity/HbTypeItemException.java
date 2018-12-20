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
    private Double valueMin;
    private Double valueMax;
    private Double valueSum;
    private Double valueAvg;
    private int valueTotalCount;
    private int valueMinCount;
    private int valueMaxCount;
    private int valueAla1Count;
    private int valueAla2Count;
    private int valueAla3Count;
    private HbTypeItemNode hbTypeItemNode;

    public HbTypeItemException(HbTypeItemNode hbTypeItemNode) {
        this.valueMin = null;
        this.valueMax = null;
        this.valueSum = null;
        this.valueAvg = null;
        this.valueTotalCount = 0;
        this.valueMinCount = 0;
        this.valueMaxCount = 0;
        this.valueAla1Count = 0;
        this.valueAla2Count = 0;
        this.valueAla3Count = 0;
        this.hbTypeItemNode = hbTypeItemNode;
    }

    /**
     * @param hbTypeItemException
     * @param hbTypeItemNode
     * @param itemValue
     */
    public static void checkItemValue(HbTypeItemException hbTypeItemException, HbTypeItemNode hbTypeItemNode, float itemValue) {
        if (null != hbTypeItemNode.getItemVmin()) {
            if (Float.valueOf(hbTypeItemNode.getItemVmin().toString()) > itemValue) {
                hbTypeItemException.increaseValueMinCount();
            }
        }
        if (null != hbTypeItemNode.getItemVmax()) {
            if (Float.valueOf(hbTypeItemNode.getItemVmax().toString()) < itemValue) {
                hbTypeItemException.increaseValueMaxCount();
            }
        }
        if (null != hbTypeItemNode.getItemVala3()) {
            if (Float.valueOf(hbTypeItemNode.getItemVala3().toString()) < itemValue) {
                hbTypeItemException.increaseValueAla3Count();
            }
        } else if (null != hbTypeItemNode.getItemVala2()) {
            if (Float.valueOf(hbTypeItemNode.getItemVala2().toString()) < itemValue) {
                hbTypeItemException.increaseValueAla2Count();
            }
        } else if (null != hbTypeItemNode.getItemVala1()) {
            if (Float.valueOf(hbTypeItemNode.getItemVala1().toString()) < itemValue) {
                hbTypeItemException.increaseValueAla1Count();
            }
        }
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
     * @param value
     * @return
     */
    public HbTypeItemException putValue(Double value) {
        this.valueTotalCount++;
        if (null == this.valueSum) {
            this.valueSum = value;
        } else {
            this.valueSum += value;
        }
        this.setValueMax(value);
        this.setValueMin(value);

        return this;
    }

    public String getValueMinCountRate() {
        if (0 == this.getValueMinCount()) {
            return "";
        } else {
            return Math.round((this.getValueMinCount() / (this.getValueTotalCount() * 1.0)) * 10000) / 100.0 + "%";
        }
    }

    public String getValueMaxCountRate() {
        if (0 == this.getValueMaxCount()) {
            return "";
        } else {
            return Math.round((this.getValueMaxCount() / (this.getValueTotalCount() * 1.0)) * 10000) / 100.0 + "%";
        }
    }

    public String getValueAla1CountRate() {
        if (0 == this.getValueAla1Count()) {
            return "";
        } else {
            return Math.round((this.getValueAla1Count() / (this.getValueTotalCount() * 1.0)) * 10000) / 100.0 + "%";
        }
    }

    public String getValueAla2CountRate() {
        if (0 == this.getValueAla2Count()) {
            return "";
        } else {
            return Math.round((this.getValueAla2Count() / (this.getValueTotalCount() * 1.0)) * 10000) / 100.0 + "%";
        }
    }

    public String getValueAla3CountRate() {
        if (0 == this.getValueAla3Count()) {
            return "";
        } else {
            return Math.round((this.getValueAla3Count() / (this.getValueTotalCount() * 1.0)) * 10000) / 100.0 + "%";
        }
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

    public Double getValueMin() {
        return valueMin;
    }

    public HbTypeItemException setValueMin(Double valueMin) {
        if (null == this.valueMin) {
            this.valueMin = valueMin;
        } else {
            this.valueMin = this.valueMin > valueMin ? valueMin : this.valueMin;
        }
        return this;
    }

    public Double getValueMax() {
        return valueMax;
    }

    public HbTypeItemException setValueMax(Double valueMax) {
        if (null == this.valueMax) {
            this.valueMax = valueMax;
        } else {
            this.valueMax = this.valueMax < valueMax ? valueMax : this.valueMax;
        }
        return this;
    }

    public Double getValueSum() {
        return valueSum;
    }

    public Double getValueAvg() {
        if (null != this.getValueSum() && 0 != this.getValueTotalCount()) {
            return Math.round((this.getValueSum() / this.getValueTotalCount()) * 1000) / 1000.0;
        } else {
            return valueAvg;
        }
    }

    public int getValueTotalCount() {
        return valueTotalCount;
    }

    public int getValueMinCount() {
        return valueMinCount;
    }

    public int getValueMaxCount() {
        return valueMaxCount;
    }

    public int getValueAla1Count() {
        return valueAla1Count;
    }

    public int getValueAla2Count() {
        return valueAla2Count;
    }

    public int getValueAla3Count() {
        return valueAla3Count;
    }

    public HbTypeItemNode getHbTypeItemNode() {
        return hbTypeItemNode;
    }
}
