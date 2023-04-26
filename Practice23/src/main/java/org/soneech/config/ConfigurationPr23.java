package org.soneech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableJpaRepositories("org.soneech.repository")
@EnableScheduling
@EnableWebMvc
public class ConfigurationPr23 { }
