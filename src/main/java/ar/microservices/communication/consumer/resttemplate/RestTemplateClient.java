package ar.microservices.communication.consumer.resttemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * Author: m
 * Date: 9/16/26
 * Project Name: communication
 * Description: beExcellent
 */
@Service
@RequiredArgsConstructor
public class RestTemplateClient {

    // private static final String PROVIDER_URL = "http://localhost:9091";
    private static final String PROVIDER_URL = "http://provider-service";

    private final RestTemplate restTemplate;

    public String getInstanceInfo() {

        return restTemplate.getForObject(PROVIDER_URL + "/instance-info", String.class);
    }
}
