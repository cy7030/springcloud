package com.yong.zuulfilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author chenYong
 * @ClassName: MyZullFilter
 * @Description: ${TODO}(zuul过滤器)
 * 继承zuulFilter类，重写他的四个方法，
 * @date 2017/10/17 11:23
 */
@Component
public class MyZuulFilter extends ZuulFilter {

    private Logger log = LoggerFactory.getLogger(MyZuulFilter.class);

    /**
     * @Description: ${TODO}(返回的字符串代表过滤的类型)
     * pre:路由之前
     * post: 路由之后
     * routing:路由之时
     * error：发送错误的时候调用
     * @Author chenYong
     * @Date 2017/10/17 13:49
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @Description: ${TODO}(该方法中指定过滤的顺序)
     * @Author chenYong
     * @Date 2017/10/17 13:52
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * @Description: ${TODO}(该方法中可以写逻辑判断，判断是否要过滤)
     * @Author chenYong
     * @Date 2017/10/17 13:52
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * @Description: ${TODO}(过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。)
     * @Author chenYong
     * @Date 2017/10/17 13:53
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        ArrayList<String> list = new ArrayList<>();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            log.warn("token is empty!!");
            context.setSendZuulResponse(false);// 对该请求进行路由
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty !! ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "token is empty!! ";

        }
        log.info("ok!!");
        return null;
    }
}
