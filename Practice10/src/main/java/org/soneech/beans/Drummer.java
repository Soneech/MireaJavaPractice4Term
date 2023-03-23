package org.soneech.beans;

import org.springframework.stereotype.Component;

@Component
public class Drummer implements Musician {
    @Override
    public void doMusic() {
        System.out.println("I'm a drummer and I play drums...");
    }
}
