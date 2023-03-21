package org.soneech.beans;

import org.springframework.stereotype.Component;

//@Component
public class Trombonist implements Musician {
    @Override
    public void doMusic() {
        System.out.println("I'm a trombonist and I play the trombone...");
    }
}
