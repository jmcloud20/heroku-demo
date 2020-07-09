package com.example.herokudemo.web.services.loadtest;

import com.example.herokudemo.web.model.loadtest.LoadTestingParameterDTO;

import java.util.Timer;
import java.util.logging.Logger;

public class LoadTestRunnable implements Runnable{

    private final Logger logger = Logger.getLogger(LoadTestRunnable.class.getName());
    private final LoadTestTimerTask timerTask;
    private final String name;
    private final LoadTestingParameterDTO loadTestingParameterDTO;

    public LoadTestRunnable(LoadTestTimerTask timerTask, String name, LoadTestingParameterDTO loadTestingParameterDTO) {
        this.timerTask = timerTask;
        this.name = name;
        this.loadTestingParameterDTO = loadTestingParameterDTO;
    }

    @Override
    public void run() {
        int callsPerThread = this.loadTestingParameterDTO.getTotalCallPerThread();
        int interval = this.loadTestingParameterDTO.getInterval()*1000;
        logger.info("Number of calls per thread: "+callsPerThread);
        for(int i=0;i<callsPerThread;i++) {
            logger.info("milliseconds per call: "+interval);
            Timer timer = new Timer();
            timer.schedule(timerTask,interval);
        }
    }
}
