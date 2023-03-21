package org.soneech.configuration;

import org.soneech.beans.Drummer;
import org.soneech.beans.Guitarist;
import org.soneech.beans.Trombonist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
public class BeanConfiguration {
    @Bean("Drummer")
    public Drummer drummer() {
        return new Drummer();
    }

    @Bean("Guitarist")
    public Guitarist guitarist() {
        return new Guitarist();
    }

    @Bean("Trombonist")
    public Trombonist trombonist() {
        return new Trombonist();
    }
}
