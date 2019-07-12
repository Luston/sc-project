package com.springcloud.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class DefineFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest=ctx.getRequest();
        String url=httpServletRequest.getRequestURI();
        if("/sc-client/hi".equals(url)){
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest=ctx.getRequest();
        String token=httpServletRequest.getParameter("token");
        if(token==null){
            ctx.setSendZuulResponse(false);
            //ctx.setResponseStatusCode(401);
            ctx.setResponseBody("token is null");
            return null;
        }
        return null;
    }
}
