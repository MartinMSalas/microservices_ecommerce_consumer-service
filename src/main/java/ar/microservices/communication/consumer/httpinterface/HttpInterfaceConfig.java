package ar.microservices.communication.consumer.httpinterface;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/*
 * Author: m
 * Date: 23/9/26
 * Project Name: Communication
 * Description: beExcellent
 */
@Configuration
public class HttpInterfaceConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }



    //  . Bean con @LoadBalanced, con un nombre único.
    //    Tu código lo usará para hablar con "http://provider-service".
    @Bean
    @LoadBalanced
    public RestClient.Builder loadBalancedHttpInterfaceRestClientBuilder() {
        return RestClient.builder();
    }
    // 1. Bean normal, marcado como @Primary.
    //    Eureka lo usará por defecto para hablar con localhost:8761.
//    @Bean
//    @Primary
//    public RestClient.Builder restClientBuilder() {
//        return RestClient.builder();
//    }


    @Bean
    public ProviderWebClientHttpInterface webClientHttpInterface( @Qualifier("loadBalancedWebClientBuilder") WebClient.Builder builder) {
        WebClient webClient = builder.baseUrl("http://provider-service").build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        ProviderWebClientHttpInterface service = factory.createClient(ProviderWebClientHttpInterface.class);

        //WebCLientAdapter
        return service;
    }

    @Bean
    public ProviderRestClientHttpInterface restClientHttpInterface(@Qualifier("loadBalancedHttpInterfaceRestClientBuilder")  RestClient.Builder builder) {

        RestClient restClient = builder.baseUrl("http://provider-service").build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        ProviderRestClientHttpInterface service = factory.createClient(ProviderRestClientHttpInterface.class);


        return service;
    }

}
