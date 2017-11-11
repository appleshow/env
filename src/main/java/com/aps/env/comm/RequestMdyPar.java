package com.aps.env.comm;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.comm.RequestMdyPar</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/7</dd>
 * </dl>
 *
 * @author appleshow
 */
public class RequestMdyPar {

    private int parCount;
    private List<Map<String, String>> inPar;

    /**
     * @throws @since 1.0.0
     * @Title: getType
     * @Description: TODO
     * @param: @param
     * rowData
     * @param: @return
     * @return: String
     */
    public String getType(Map<String, String> rowData) {
        String type = "";

        if (rowData.containsKey(CommUtil.REQUEST_SQL_DML_TYPE)) {
            type = rowData.get(CommUtil.REQUEST_SQL_DML_TYPE);
            rowData.remove(CommUtil.REQUEST_SQL_DML_TYPE);
        }

        return type;
    }

    /**
     * @throws @since 1.0.0
     * @Title: getPersonId
     * @Description: TODO
     * @param: @param
     * session
     * @param: @param
     * now
     * @param: @param
     * rowData
     * @param: @return
     * @return: int
     */
    public int getPersonId(HttpSession session, Date now, Map<String, String> rowData) {
        int personId = Integer.parseInt(String.valueOf(session.getAttribute(CommUtil.SESSION_PERSON_ID)));

        rowData.put("utime", DateUtil.formatString(now, DateUtil.SIMPLE_DATE_FORMAT1));
        rowData.put("uperson", String.valueOf(personId));

        return personId;
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
     * @return: List<Map<String,String>>
     * @since 1.0.0
     */

    public List<Map<String, String>> getInPar() {
        return inPar;
    }

    /**
     * @Title: setInPar
     * @Description:
     * @return: List<Map<String,String>>
     * @since 1.0.0
     */
    public void setInPar(List<Map<String, String>> inPar) {
        this.inPar = inPar;
    }
}
