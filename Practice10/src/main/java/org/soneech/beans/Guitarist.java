package org.soneech.beans;

import org.springframework.stereotype.Component;

//@Component
public class Guitarist implements Musician {
    @Override
    public void doMusic() {
        System.out.println("I'm a guitarist and I play the guitar...");
    }
}
