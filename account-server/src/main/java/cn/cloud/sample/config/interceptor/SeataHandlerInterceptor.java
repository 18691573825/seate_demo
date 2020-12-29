//package cn.cloud.sample.config.interceptor;
//
//import io.seata.core.context.RootContext;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///** feign 请求头带参设置
// * @author LLT
// * @Description: feign拦截器
// * @date: 2020/6/9
// */
//
//public class SeataHandlerInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String xid = RootContext.getXID();
//        String rpcXid = request.getHeader("TX_XID");
//        if (xid == null && rpcXid != null) {
//            //设置全局事务编号
//            RootContext.bind(rpcXid);
//        }
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        String rpcXid = request.getHeader("TX_XID");
//        if (!StringUtils.isEmpty(rpcXid)) {
//            String unbindXid = RootContext.unbind();
//            if (!rpcXid.equalsIgnoreCase(unbindXid)) {
//                if (unbindXid != null) {
//                    RootContext.bind(unbindXid);
//            }
//
//        }
//    }
//}
//}
