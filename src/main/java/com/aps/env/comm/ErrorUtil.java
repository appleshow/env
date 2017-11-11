package com.aps.env.comm;

/**
 * <dl>
 * <dt>com.aps.env.comm.ErrorUtil</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    DXC Technology </dd>
 * <dd>CreateDate: 2017/11/7</dd>
 * </dl>
 *
 * @author appleshow
 */
public class ErrorUtil {


    /**
     *
     * @Title: nomarlException
     * @Description: TODO
     * @param: @param e
     * @param: @return
     * @return: String
     * @throws
     * @since 1.0.0
     */
    public static String nomarlException(Exception e) {
        int code = -800;
        String message;

        if (StringUtil.isNullOrEmpty(e.getMessage())) {
            message = "未来知异常:" + e.getClass().getName();
        } else {
            message = e.getMessage();
        }

        return createError(code, message);
    }

    /**
     *
     * @Title: createError
     * @Description: TODO
     * @param: @param code
     * @param: @param message
     * @param: @return
     * @return: String
     * @throws
     * @since 1.0.0
     */
    private static String createError(int code, String message) {

        return "{\"code\":" + code + ",\"message\":" + message + "}";
    }
}
