package org.soneech.practice7.facade;

public class Developer {
    public void doJob(SprintTracker sprintTracker) {
        if (sprintTracker.isActiveSprint()) {
            System.out.println("Developer is solving tasks...");
        }
        else {
            System.out.println("Developer is reading habr...");
        }
    }
}
