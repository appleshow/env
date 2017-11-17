package com.aps.env.comm;

import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.comm.RequestRefPar</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2017/11/7</dd>
 * </dl>
 *
 * @author appleshow
 */
public class RequestRefPar {
    private int parCount = 0;
    private Map<String, String> inPar;
    private int page;
    private int rows;

    /**
     * @throws
     * @Title: hasPar
     * @Description: TODO
     * @param: @return
     * @return: boolean
     * @since 1.0.0
     */
    public boolean hasPar() {
        return parCount > 0 ? true : false;
    }

    /**
     * @throws
     * @Title: getStringPar
     * @Description: TODO
     * @param: @param name
     * @param: @return
     * @return: String
     * @since 1.0.0
     */
    public String getStringPar(String name) {
        if (hasPar()) {
            if (inPar.containsKey(name)) {
                return inPar.get(name);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * @throws
     * @Title: getIntegerPar
     * @Description: TODO
     * @param: @param name
     * @param: @return
     * @return: Integer
     * @since 1.0.0
     */
    public Integer getIntegerPar(String name) {
        if (hasPar()) {
            if (inPar.containsKey(name)) {
                try {
                    int par = Integer.parseInt(inPar.get(name));

                    return par;
                } catch (Exception e) {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * @throws
     * @Title: getFloatPar
     * @Description: TODO
     * @param: @param name
     * @param: @return
     * @return: Float
     * @since 1.0.0
     */
    public Float getFloatPar(String name) {
        if (hasPar()) {
            if (inPar.containsKey(name)) {
                try {
                    float par = Float.parseFloat(inPar.get(name));

                    return par;
                } catch (Exception e) {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * @throws
     * @Title: getDoublePar
     * @Description: TODO
     * @param: @param name
     * @param: @return
     * @return: Double
     * @since 1.0.0
     */
    public Double getDoublePar(String name) {
        if (hasPar()) {
            if (inPar.containsKey(name)) {
                try {
                    double par = Double.parseDouble(inPar.get(name));

                    return par;
                } catch (Exception e) {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * @Title: getParCount
     * @Description:
     * @return: int
     * @since 1.0.0
     */

    public int getParCount() {
        return parCount;
    }

    /**
     * @Title: setParCount
     * @Description:
     * @return: int
     * @since 1.0.0
     */
    public void setParCount(int parCount) {
        this.parCount = parCount;
    }

    /**
     * @Title: getInPar
     * @Description:
     * @return: Map<String,String>
     * @since 1.0.0
     */

    public Map<String, String> getInPar() {
        return inPar;
    }

    /**
     * @Title: setInPar
     * @Description:
     * @return: Map<String,String>
     * @since 1.0.0
     */
    public void setInPar(Map<String, String> inPar) {
        this.inPar = inPar;
    }

    /**
     * @return
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }
}
