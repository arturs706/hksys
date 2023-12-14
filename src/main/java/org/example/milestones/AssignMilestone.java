package org.example.milestones;

public class AssignMilestone implements MilestoneCommand {
    private MilestoneReceiver receiver;

    public AssignMilestone(MilestoneReceiver receiver){

        this.receiver = receiver;
    }
    @Override
    public void exe() {
        receiver.assignMilestone();
    }
}
