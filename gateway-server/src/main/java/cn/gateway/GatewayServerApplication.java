package cn.gateway;

import cn.gateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author LLT
 * @Description: gateway网关启动类
 * @date: 2020/5/19
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }


    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
