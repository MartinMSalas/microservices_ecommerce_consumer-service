package ar.microservices.communication.consumer.restclient;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/*
 * Author: m
 * Date: 9/22/26
 * Project Name: communication
 * Description: beExcellent
 */

@Service
public class ProviderRestClient {

    private final RestClient restClient;

//    public ProviderRestClient(
//            @Qualifier("providerRestClientBean") RestClient restClient) {
//        this.restClient = restClient;
//    }

    public ProviderRestClient(
            RestClient restClient) {
        this.restClient = restClient;
    }
    public String getInstanceInfo() {
        return restClient.get()
                .uri("/instance-info")
                .retrieve()
                .body(String.class);
    }
}