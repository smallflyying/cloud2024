package com.atguigu.cloud.mygateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 面试题：统计接口调用耗时情况，如何落地，谈谈设计思路
 *      通过自定义全局过滤器搞定上述需求
 * @author LiHongFei
 * @version 1.0
 * @since 2024/7/24
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    public static final String BEGIN_VISIT_TIME = "begin_visit_time";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1 先记录下访问接口的开始时间
        exchange.getAttributes().put(BEGIN_VISIT_TIME, System.currentTimeMillis());
        // 2 返回统计的各个结果给后台
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long beginVisitTime = exchange.getAttribute(BEGIN_VISIT_TIME);
            if (beginVisitTime != null) {
                log.info("访问接口主机：" + exchange.getRequest().getURI().getHost());
                log.info("访问接口端口：" + exchange.getRequest().getURI().getPort());
                log.info("访问接口URL：" + exchange.getRequest().getURI().getPath());
                log.info("访问接口URL后面参数：" + exchange.getRequest().getURI().getRawQuery());
                log.info("访问接口时长：" + (System.currentTimeMillis() - beginVisitTime) + "毫秒");
                log.info("====================分割线============================");
                System.out.println();
            }
        }));
    }

    /**
     * 数字越小，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
