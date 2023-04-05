package org.soneech.beans;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Student {
    @Value("${student.name}")
    private String name;
    @Value("${student.last_name}")
    private String lastName;
    @Value("${student.group}")
    private String group;

    @PostConstruct
    public void printInfo() {
        System.out.println(name);
        System.out.println(lastName);
        System.out.println(group);
    }
}
