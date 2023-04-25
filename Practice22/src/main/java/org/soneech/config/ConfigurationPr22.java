package org.soneech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@ComponentScan("org.soneech")
@EnableJpaRepositories("org.soneech.repository")
@EnableScheduling
public class ConfigurationPr22 {

}
