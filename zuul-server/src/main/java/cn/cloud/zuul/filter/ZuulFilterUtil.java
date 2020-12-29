package cn.cloud.zuul.filter;

import cn.hutool.core.util.ObjectUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LLT
 * @Description: zuul网关过滤器
 * @date: 2020/5/14
 */
@Slf4j
@Component
public class ZuulFilterUtil extends ZuulFilter {
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
        return true;
    }

    @SneakyThrows
    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s ", request.getMethod(), request.getRequestURL().toString()));
        Object token = request.getHeader("token");
        if(ObjectUtil.isNull(token)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.getResponse().getWriter().write("token is empty");
        }
        return null;
    }
}
