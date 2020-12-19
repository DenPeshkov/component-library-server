package com.github.denpeshkov.componentlibraryserver.service_module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceModuleRepository extends JpaRepository<Statistics, Long> {}
