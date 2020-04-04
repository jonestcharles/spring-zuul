package com.thoughtmechanix.zuulsvr.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class CustomErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1; // Probably order doesn't matter because it runs on demand
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext()
                .getThrowable() != null;
    }

    @Override
    public Object run() {
        try {
            System.out.println("Custom error filter running ");
            RequestContext ctx = RequestContext.getCurrentContext();

            Throwable throwable = ctx.getThrowable();
            if (throwable != null) {
                System.out.println("Zuul failure detected: " + throwable.getMessage() + throwable.toString());
                ctx.setResponseBody("Zuul exception:" + throwable.getMessage() + " cause: " + throwable.getCause()); // just for development purposes
                ctx.getResponse()
                        .setContentType("application/json");
                ctx.setResponseStatusCode(500);
            }
        } catch (Exception ex) {
            System.out.println("Exception filtering in custom error filter" + ex.getMessage());
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }
}
