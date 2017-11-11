package com.aps.env.comm;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <dl>
 * <dt>com.aps.env.comm.ContextPathFilter</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/8</dd>
 * </dl>
 *
 * @author appleshow
 */
public class ContextPathFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String contextPath = ((HttpServletRequest) servletRequest).getContextPath();

        servletRequest.setAttribute(CommUtil.CONTEXT_PATH, contextPath);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
