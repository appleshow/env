package com.aps.env.service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.PreLoginHandler</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/8</dd>
 * </dl>
 *
 * @author appleshow
 */
public interface PreLoginHandler {

    /**
     * 前置处理
     *
     * @param httpSession
     * @return
     * @throws Exception
     */
    Map<?, ?> handle(HttpSession httpSession) throws Exception;
}
