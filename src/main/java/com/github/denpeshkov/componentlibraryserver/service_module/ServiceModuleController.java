package com.github.denpeshkov.componentlibraryserver.service_module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apps")
public class ServiceModuleController {
    final ServiceModuleService serviceModuleService;

    public ServiceModuleController(ServiceModuleService serviceModuleService) {
        this.serviceModuleService = serviceModuleService;
    }

    @PostMapping
    public void postStatistics(@RequestBody Statistics statistics) {
        serviceModuleService.saveServiceModuleStatistics(statistics);
    }
}
