package com.example.toygry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {
    public static final String AUTHORIZATION = "Authorization";

    public GlobalFilter() {super(Config.class);}

    @Override
    public GatewayFilter apply(Config config) {
        //Custom Pre Filter
        return (exchange, chain) ->{
            // header 에 authorization 을 넣기위한 노력의 잔재 ,,

//            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

//            request.mutate().header(AUTHORIZATION, Objects.requireNonNull(request.getHeaders().get(AUTHORIZATION)).getFirst()).build();

            //Custom Post Filter
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                if(config.postLogger()) log.info("Gateway global filter : response status code -> {}", response.getStatusCode());
            }));
        };
    }

    public record Config(boolean postLogger) {}
}