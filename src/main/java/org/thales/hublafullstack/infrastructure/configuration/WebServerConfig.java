package org.thales.hublafullstack.infrastructure.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.thales"})
public class WebServerConfig {
  public WebServerConfig() {
  }
}