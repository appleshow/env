package com.aps.env.entity;

import com.aps.env.comm.StringUtil;

/**
 * <dl>
 * <dt>com.aps.env.entity.ReportTable</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2018/8/9</dd>
 * </dl>
 *
 * @author appleshow
 */
public class ReportTable {
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private String c5;
    private String c6;
    private String c7;
    private String c8;
    private String c9;
    private String c10;
    private String c11;
    private String c12;
    private String c13;
    private String c14;
    private String c15;
    private String c16;
    private String c17;
    private String c18;
    private String c19;
    private String c20;
    private String c21;
    private String c22;
    private String c23;
    private String c24;
    private String c25;

    public ReportTable() {

    }

    public ReportTable(String c1) {
        this.c1 = c1;
    }

    public ReportTable setColumnValue(int colIndex, String method, boolean ignoreZero, int precision, ReportTableItem reportTableItem) {
        float valueInput;
        String value;

        switch (method) {
            case "MIN":
                valueInput = reportTableItem.getMinValue(ignoreZero);
                break;
            case "MAX":
                valueInput = reportTableItem.getMaxValue(ignoreZero);
                break;
            default:
                valueInput = reportTableItem.getAvgValue(ignoreZero);
                break;
        }
        value = valueInput == 0 ? "" : String.format("%." + precision + "f", valueInput);

        switch (colIndex) {
            case 1:
                this.setC1(value);
                break;
            case 2:
                this.setC2(value);
                break;
            case 3:
                this.setC3(value);
                break;
            case 4:
                this.setC4(value);
                break;
            case 5:
                this.setC5(value);
                break;
            case 6:
                this.setC6(value);
                break;
            case 7:
                this.setC7(value);
                break;
            case 8:
                this.setC8(value);
                break;
            case 9:
                this.setC9(value);
                break;
            case 10:
                this.setC10(value);
                break;
            case 11:
                this.setC11(value);
                break;
            case 12:
                this.setC12(value);
                break;
            case 13:
                this.setC13(value);
                break;
            case 14:
                this.setC14(value);
                break;
            case 15:
                this.setC15(value);
                break;
            case 16:
                this.setC16(value);
                break;
            case 17:
                this.setC17(value);
                break;
            case 18:
                this.setC18(value);
                break;
            case 19:
                this.setC19(value);
                break;
            case 20:
                this.setC20(value);
                break;
            case 21:
                this.setC21(value);
                break;
            case 22:
                this.setC22(value);
                break;
            case 23:
                this.setC23(value);
                break;
            case 24:
                this.setC24(value);
                break;
            case 25:
                this.setC25(value);
                break;
            default:
                break;
        }
        return this;
    }

    public String getC1() {
        return c1;
    }

    public ReportTable setC1(String c1) {
        this.c1 = c1;

        return this;
    }

    public ReportTable setC1(int c1, String type) {
        switch (type) {
            case "D10":
                this.setC1(String.format("%s-%s", StringUtil.getLpad(c1 - 1, 2, "0"), StringUtil.getLpad(c1, 2, "0")));
                break;
            case "D11":
                this.setC1(String.format("%s日", String.valueOf(c1)));
                break;
            case "D12":
                this.setC1(String.format("%s月", String.valueOf(c1)));
                break;
            case "D13":
                this.setC1(String.format("%s月", String.valueOf(c1)));
                break;
            default:
                break;
        }


        return this;
    }

    public String getC2() {
        return c2;
    }

    public ReportTable setC2(String c2) {
        this.c2 = c2;

        return this;
    }

    public String getC3() {
        return c3;
    }

    public ReportTable setC3(String c3) {
        this.c3 = c3;

        return this;
    }

    public String getC4() {
        return c4;
    }

    public ReportTable setC4(String c4) {
        this.c4 = c4;

        return this;
    }

    public String getC5() {
        return c5;
    }

    public ReportTable setC5(String c5) {
        this.c5 = c5;

        return this;
    }

    public String getC6() {
        return c6;
    }

    public ReportTable setC6(String c6) {
        this.c6 = c6;

        return this;
    }

    public String getC7() {
        return c7;
    }

    public ReportTable setC7(String c7) {
        this.c7 = c7;

        return this;
    }

    public String getC8() {
        return c8;
    }

    public ReportTable setC8(String c8) {
        this.c8 = c8;

        return this;
    }

    public String getC9() {
        return c9;
    }

    public ReportTable setC9(String c9) {
        this.c9 = c9;

        return this;
    }

    public String getC10() {
        return c10;
    }

    public ReportTable setC10(String c10) {
        this.c10 = c10;

        return this;
    }

    public String getC11() {
        return c11;
    }

    public ReportTable setC11(String c11) {
        this.c11 = c11;

        return this;
    }

    public String getC12() {
        return c12;
    }

    public ReportTable setC12(String c12) {
        this.c12 = c12;

        return this;
    }

    public String getC13() {
        return c13;
    }

    public ReportTable setC13(String c13) {
        this.c13 = c13;

        return this;
    }

    public String getC14() {
        return c14;
    }

    public ReportTable setC14(String c14) {
        this.c14 = c14;

        return this;
    }

    public String getC15() {
        return c15;
    }

    public ReportTable setC15(String c15) {
        this.c15 = c15;

        return this;
    }

    public String getC16() {
        return c16;
    }

    public ReportTable setC16(String c16) {
        this.c16 = c16;

        return this;
    }

    public String getC17() {
        return c17;
    }

    public ReportTable setC17(String c17) {
        this.c17 = c17;

        return this;
    }

    public String getC18() {
        return c18;
    }

    public ReportTable setC18(String c18) {
        this.c18 = c18;

        return this;
    }

    public String getC19() {
        return c19;
    }

    public ReportTable setC19(String c19) {
        this.c19 = c19;

        return this;
    }

    public String getC20() {
        return c20;
    }

    public ReportTable setC20(String c20) {
        this.c20 = c20;

        return this;
    }

    public String getC21() {
        return c21;
    }

    public ReportTable setC21(String c21) {
        this.c21 = c21;

        return this;
    }

    public String getC22() {
        return c22;
    }

    public ReportTable setC22(String c22) {
        this.c22 = c22;

        return this;
    }

    public String getC23() {
        return c23;
    }

    public ReportTable setC23(String c23) {
        this.c23 = c23;

        return this;
    }

    public String getC24() {
        return c24;
    }

    public ReportTable setC24(String c24) {
        this.c24 = c24;

        return this;
    }

    public String getC25() {
        return c25;
    }

    public ReportTable setC25(String c25) {
        this.c25 = c25;

        return this;
    }
}
