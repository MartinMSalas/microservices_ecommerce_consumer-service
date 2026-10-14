package ar.microservices.communication.consumer.resttemplate;

import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;



/*
 * Author: m
 * Date: 9/16/26
 * Project Name: communication
 * Description: beExcellent
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced // Esta anotación es la que le da la capacidad de resolver nombres de servicio
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
