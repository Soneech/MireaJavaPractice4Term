package org.soneech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@ComponentScan("org.soneech")
@EnableJpaRepositories("org.soneech.repository")
@EnableAsync
public class ConfigurationPr21 {

}
