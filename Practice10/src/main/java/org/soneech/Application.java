package org.soneech;

import org.soneech.beans.Drummer;
import org.soneech.beans.Guitarist;
import org.soneech.beans.Trombonist;
import org.soneech.configuration.BeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        Guitarist guitarist = (Guitarist) context.getBean("Guitarist");
        guitarist.doMusic();

        Drummer drummer = (Drummer) context.getBean("Drummer");
        drummer.doMusic();

        Trombonist trombonist = (Trombonist) context.getBean("Trombonist");
        trombonist.doMusic();
    }
}
