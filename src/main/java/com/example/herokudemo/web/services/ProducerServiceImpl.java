package com.example.herokudemo.web.services;

import com.example.herokudemo.web.model.CommonMessageDTO;
import com.example.herokudemo.web.model.loadtest.LoadTestingParameterDTO;
import com.example.herokudemo.web.model.MessageDTO;
import com.example.herokudemo.web.services.loadtest.*;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final Logger logger = Logger.getLogger(ProducerServiceImpl.class.getName());

    private final ServletContext servletContext;
    private final String CONTEXT_KEY = "LATEST_MESSAGE";

    private final LoadTestClientFactory loadTestClientFactory;

    public ProducerServiceImpl(
            ServletContext servletContext, LoadTestClientFactory loadTestClientFactory) {

        this.servletContext = servletContext;
        this.loadTestClientFactory = loadTestClientFactory;
    }

    @Override
    public CommonMessageDTO getSampleCommonMessage() {
        return CommonMessageDTO.builder()
                .topic("testTopic")
                .desc("testDesc")
                .message(MessageDTO.builder()
                        .brand("testBrand")
                        .email("testEmail")
                        .mobile(98989898)
                        .hkId(UUID.randomUUID().toString()).build()).build();
    }

    @Override
    public void saveMesage(CommonMessageDTO message) {
        this.servletContext.setAttribute(CONTEXT_KEY, message);
    }

    @Override
    public CommonMessageDTO getMessage() {
        return (CommonMessageDTO) this.servletContext.getAttribute(CONTEXT_KEY);
    }

    @Override
    public void startLoadTest(LoadTestingParameterDTO loadTestingParameterDTO) throws InterruptedException {
        LoadTestClient client = this.loadTestClientFactory.getInstance(loadTestingParameterDTO.getTopic());
        int numOfThread = loadTestingParameterDTO.getNumberOfThread();

        logger.info("Number of threads to be created: "+numOfThread);
        for(int i=0;i<numOfThread;i++){
            String threadName = "LoadTestThread-"+i;

            logger.info("Create a timer task.");
            LoadTestTimerTask timerTask = new LoadTestTimerTask(client);

            logger.info("Creating thread: "+threadName);
            LoadTestRunnable runnable = new LoadTestRunnable(timerTask, threadName, loadTestingParameterDTO);
            new Thread(runnable, threadName).start();
            Thread.sleep(5500);
        }

    }

}
