package org.soneech.practice7.facade;

public class Workflow {
    private Job job;
    private SprintTracker sprintTracker;
    private Developer developer;

    public Workflow() {
        job = new Job();
        sprintTracker = new SprintTracker();
        developer = new Developer();
    }
    public void start() {
        sprintTracker.startSprint();
        job.startJob();
        developer.doJob(sprintTracker);
    }
    public void stop() {
        job.stopJob();
        sprintTracker.stopSprint();
        developer.doJob(sprintTracker);
    }
}
