package com.example.herokudemo.web.services.loadtest;

import java.util.TimerTask;

public class LoadTestTimerTask extends TimerTask {

    private final LoadTestClient loadTestClient;

    public LoadTestTimerTask(LoadTestClient loadTestClient) {
        this.loadTestClient = loadTestClient;
    }

    @Override
    public void run() {
        this.loadTestClient.send();
    }
}
