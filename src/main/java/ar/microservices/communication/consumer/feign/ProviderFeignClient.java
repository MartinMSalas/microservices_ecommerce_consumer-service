package ar.microservices.communication.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Author: m
 * Date: 9/22/26
 * Project Name: communication
 * Description: beExcellent
 */
//@FeignClient(name="provider-service", url="http://localhost:9091")
@FeignClient(name="provider-service")
public interface ProviderFeignClient {

    @GetMapping("/instance-info")
    String getInstanceInfo();

}
