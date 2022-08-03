package com.kc.gateway.filter;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.util.Date;

/**
 * 过滤器
 * @author kc
 * @date 2022年4月9日
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String info = String.format("Method:{%s} Host:{%s} Path:{%s} Query:{%s}",
                exchange.getRequest().getMethod().name(),
                exchange.getRequest().getURI().getHost(),
                exchange.getRequest().getURI().getPath(),
                exchange.getRequest().getQueryParams());

        System.out.println(info);

        exchange.getAttributes().put("START_TIME", System.currentTimeMillis());
        return chain.filter(exchange).then( Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute("START_TIME");
            if (startTime != null) {
                Long executeTime = (System.currentTimeMillis() - startTime);
                System.out.println(exchange.getRequest().getURI().getRawPath() + " : " + executeTime + "ms");
            }
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
