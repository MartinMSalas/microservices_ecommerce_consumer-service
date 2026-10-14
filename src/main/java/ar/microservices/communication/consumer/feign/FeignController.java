package ar.microservices.communication.consumer.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Author: m
 * Date: 9/22/26
 * Project Name: communication
 * Description: beExcellent
 */
@RestController
@RequestMapping("/api/feign")
@RequiredArgsConstructor
public class FeignController {

    private final ProviderFeignClient providerFeignClient;

    @GetMapping("/instance")
    public String getInstance() {

        return providerFeignClient.getInstanceInfo();

    }


}
