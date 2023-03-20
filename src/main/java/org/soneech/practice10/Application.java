package org.soneech.practice10;

import org.soneech.practice10.beans.Drummer;
import org.soneech.practice10.beans.Guitarist;
import org.soneech.practice10.beans.Trombonist;
import org.soneech.practice10.configuration.BeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        Guitarist guitarist = context.getBean(Guitarist.class);
        guitarist.doMusic();

        Drummer drummer = context.getBean(Drummer.class);
        drummer.doMusic();

        Trombonist trombonist = context.getBean(Trombonist.class);
        trombonist.doMusic();
    }
}
