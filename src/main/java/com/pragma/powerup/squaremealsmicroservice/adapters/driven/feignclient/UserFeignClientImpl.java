package com.pragma.powerup.squaremealsmicroservice.adapters.driven.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-users", url = "http://localhost:8090/user")
public interface UserFeignClientImpl {
    @GetMapping("/{id}")
    public boolean isOwnerUser(@PathVariable("id") Long id);
}
