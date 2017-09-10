package com.niu.yumao.action;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤掉百度上传插件
 */
public class MyStrutsFilter extends StrutsPrepareAndExecuteFilter {

    @Override

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getRequestURI();
        if (url.substring(url.lastIndexOf(".") + 1).equals("css") || url.substring(url.lastIndexOf(".") + 1).equals("js") || url.contains("/bdeditor/jsp/")) {
            chain.doFilter(request, res);
        } else {
            super.doFilter(req, res, chain);
        }
    }
}
