package org.soneech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@ComponentScan("org.soneech")
@EnableJpaRepositories("org.soneech.repository")
@EnableAsync
public class ConfigurationPr18 {
//    @Bean
//    public JavaMailSender javaMailSender() {
//        return new JavaMailSenderImpl();
//    }
}
