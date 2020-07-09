package com.example.herokudemo.web.services.loadtest;

import com.example.herokudemo.web.client.MulesoftClient;
import com.example.herokudemo.web.model.CommonMessageDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerOpt implements LoadTestClient {

    private CommonMessageDTO commonMessageDTO;
    private final MulesoftClient webClientImpl;

    public CustomerOpt(MulesoftClient webClientImpl) {
        this.webClientImpl = webClientImpl;
    }


    @Override
    public void setMessage(CommonMessageDTO commonMessageDTO) {
        this.commonMessageDTO = commonMessageDTO;
    }

    @Override
    public void send() {
        this.webClientImpl.sendCustomerOpt(this.commonMessageDTO);
    }
}
