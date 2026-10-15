package ar.microservices.communication.consumer.restclient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;

/*
 * Author: m
 * Date: 9/22/26
 * Project Name: communication
 * Description: beExcellent
 */
@Configuration
public class RestClientConfig {

    // 1. Bean normal, marcado como @Primary.
    //    Eureka lo usará por defecto para hablar con localhost:8761.
    @Bean
    @Primary
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    // 2. Bean con @LoadBalanced, con un nombre único.
    //    Tu código lo usará para hablar con "http://provider-service".
    @Bean
    @LoadBalanced
    public RestClient.Builder loadBalancedRestClientBuilder() {
        return RestClient.builder();
    }

    // 3. Tu RestClient de provider, construido con el builder correcto.
    @Bean
    public RestClient providerRestClientBean(
            @Qualifier("loadBalancedRestClientBuilder") RestClient.Builder builder) {
        return builder
                .baseUrl("http://provider-service")
                .build();
    }
}
