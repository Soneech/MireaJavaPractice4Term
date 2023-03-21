package org.soneech.practice7.facade;

public class SprintTracker {
    private boolean activeSprint;

    public SprintTracker() {
        activeSprint = false;
    }
    public boolean isActiveSprint() {
        return activeSprint;
    }

    public void startSprint() {
        System.out.println("Sprint started");
        activeSprint = true;
    }

    public void stopSprint() {
        System.out.println("Sprint stopped");
        activeSprint = false;
    }
}
