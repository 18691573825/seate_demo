package cn.cloud.sample.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/** feign 设置请求头参数Xid传递 全局回滚编码Xid
 * @author LLT
 * @Description:
 * @date: 2020/6/9
 */
@Component
public class SeataRestTemplateInterceptor implements RequestInterceptor {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 将全局事务编码Xid设置到请求头中
        String xid = RootContext.getXID();
        requestTemplate.header(RootContext.KEY_XID, xid);
        if (httpServletRequest != null) {
            requestTemplate.header(RootContext.KEY_XID, xid);
        }
    }
}
