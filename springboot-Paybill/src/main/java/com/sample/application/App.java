package com.sample.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.sample"})
public class App extends SpringBootServletInitializer {
  public static void main(String[] args) {
      SpringApplication.run(App.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(App.class);
  }
}