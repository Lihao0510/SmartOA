package com.oridway.oridwayoa.entity;

import java.util.List;

/**
 * Created by lihao on 2017/8/9.
 */

public class HistoryDialog {

    public int userID;
    public String userName;
    public List<String> historyContent;
    public String lastTime;
    public String lastSnapshot;

    public HistoryDialog(String userName, String lastTime, String lastSnapshot) {
        this.userName = userName;
        this.lastTime = lastTime;
        this.lastSnapshot = lastSnapshot;
    }
}
