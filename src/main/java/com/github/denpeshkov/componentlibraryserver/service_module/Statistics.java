package com.github.denpeshkov.componentlibraryserver.service_module;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "Statistics_6")
public class Statistics {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ApiModelProperty(value = "name", required = true)
  private String name;

  @ApiModelProperty(value = "time", required = true)
  private Integer time;

  public Statistics() {}

  public Statistics(String name, Integer time) {
    this.name = name;
    this.time = time;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
