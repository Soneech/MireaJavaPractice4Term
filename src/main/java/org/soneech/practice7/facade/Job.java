package org.soneech.practice7.facade;

public class Job {
    private boolean isActive;
    public void startJob() {
        System.out.println("Job in progress...");
        isActive = true;
    }
    public void stopJob() {
        System.out.println("Job has stopped");
    }
}
