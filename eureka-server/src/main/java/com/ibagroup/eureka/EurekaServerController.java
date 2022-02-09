package com.ibagroup.eureka;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.eureka.EurekaServerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "eureka-server")
public class EurekaServerController {

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getServices(){
        return "ok";
    }

}
