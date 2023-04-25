package org.soneech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan("org.soneech")
@EnableJpaRepositories("org.soneech.repository")
public class ConfigurationPr20 { }
