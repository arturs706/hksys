package org.example.historyinfo;

// Example concrete command in historyinfo package
public class ImpHistoryInfoCom implements HistoryCommand {
    private ImpHistoryInfoCom historyInfo;

    public ImpHistoryInfoCom(ImpHistoryInfoCom info) {
        this.historyInfo = info;
    }

    @Override
    public void execute() {
        // Implement the logic to execute the command using ImportantHistoryInfo
        historyInfo.execute();
    }
}
