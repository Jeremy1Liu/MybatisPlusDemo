package com.infosharing.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.infosharing.project.mapper")
public class InfoSharingProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(InfoSharingProjectApplication.class, args);
  }

}
