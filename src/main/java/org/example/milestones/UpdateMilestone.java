package org.example.milestones;

public class UpdateMilestone implements MilestoneCommand {
    private MilestoneReceiver receiver;

    public UpdateMilestone(MilestoneReceiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void exe() {
        receiver.updateMilestoneStatus();
    }
}
