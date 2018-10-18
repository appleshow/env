package com.aps.env.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * <dl>
 * <dt>com.aps.env.entity.ReportTableItem</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2018/8/9</dd>
 * </dl>
 *
 * @author appleshow
 */
public class ReportTableItem {
    private String columnName;
    private String cloumnNameCheck;
    private List<Float> values;

    public ReportTableItem() {
        this.values = new ArrayList<>();
    }

    public ReportTableItem addValue(float value) {
        this.values.add(value);

        return this;
    }

    public float getAvgValue(boolean ignoreZero) {
        float sum = 0;
        int count = 0;

        for (float value : this.values) {
            sum += value;
            if (value != 0) {
                count++;
            }
        }

        return this.values.size() > 0 && count > 0 ? sum / (ignoreZero ? count : this.values.size()) : sum;
    }

    public float getMinValue(boolean ignoreZero) {
        float minValue = Float.MAX_VALUE;
        boolean find = false;

        for (float value : this.values) {
            if (value == 0 && ignoreZero) {
                continue;
            }
            if (value < minValue) {
                minValue = value;
                find = true;
            }
        }

        return this.values.size() > 0 && find ? minValue : 0;
    }

    public float getMaxValue(boolean ignoreZero) {
        float maxValue = Float.MIN_VALUE;
        boolean find = false;

        for (float value : this.values) {
            if (value == 0 && ignoreZero) {
                continue;
            }
            if (value > maxValue) {
                maxValue = value;
                find = true;
            }
        }

        return this.values.size() > 0 && find ? maxValue : 0;
    }

    public String getColumnName() {
        return columnName;
    }

    public ReportTableItem setColumnName(String columnName) {
        this.columnName = columnName;

        return this;
    }

    public String getCloumnNameCheck() {
        return cloumnNameCheck;
    }

    public ReportTableItem setCloumnNameCheck(String cloumnNameCheck) {
        this.cloumnNameCheck = cloumnNameCheck;

        return this;
    }

    public List<Float> getValues() {
        return values;
    }

    public ReportTableItem setValues(List<Float> values) {
        this.values = values;

        return this;
    }
}
