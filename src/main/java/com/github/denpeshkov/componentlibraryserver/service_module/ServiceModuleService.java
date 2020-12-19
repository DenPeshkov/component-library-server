package com.github.denpeshkov.componentlibraryserver.service_module;

import org.springframework.stereotype.Service;

@Service
public class ServiceModuleService {
  final ServiceModuleRepository serviceModuleRepository;

  public ServiceModuleService(ServiceModuleRepository serviceModuleRepository) {
    this.serviceModuleRepository = serviceModuleRepository;
  }

  public void saveServiceModuleStatistics(Statistics statistics) {
    serviceModuleRepository.save(statistics);
  }
}
