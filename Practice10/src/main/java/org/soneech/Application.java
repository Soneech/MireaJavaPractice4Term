package org.soneech;

import org.soneech.beans.Drummer;
import org.soneech.beans.Guitarist;
import org.soneech.beans.Trombonist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        Guitarist guitarist = context.getBean(Guitarist.class);
        guitarist.doMusic();

        Drummer drummer = context.getBean("drummer", Drummer.class);
        drummer.doMusic();

        Trombonist trombonist = context.getBean("trombonist", Trombonist.class);
        trombonist.doMusic();
    }
}
