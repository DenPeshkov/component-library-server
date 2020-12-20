package com.github.denpeshkov.componentlibraryserver.service_module;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/apps")
public class ServiceModuleController {
  final ServiceModuleService serviceModuleService;

  public ServiceModuleController(ServiceModuleService serviceModuleService) {
    this.serviceModuleService = serviceModuleService;
  }

  @PostMapping
  public void postStatistics(@RequestBody Statistics[] statistics) {
    for (Statistics statistic : statistics) {
      serviceModuleService.saveServiceModuleStatistics(statistic);
    }
  }
}
