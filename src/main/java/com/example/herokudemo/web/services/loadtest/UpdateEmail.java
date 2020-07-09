package com.example.herokudemo.web.services.loadtest;

import com.example.herokudemo.web.client.MulesoftClient;
import com.example.herokudemo.web.model.CommonMessageDTO;
import org.springframework.stereotype.Component;

@Component
public class UpdateEmail implements LoadTestClient {

    private CommonMessageDTO commonMessageDTO;
    private final MulesoftClient webClientImpl;

    public UpdateEmail(MulesoftClient webClientImpl) {
        this.webClientImpl = webClientImpl;
    }


    @Override
    public void setMessage(CommonMessageDTO commonMessageDTO) {
        this.commonMessageDTO = commonMessageDTO;
    }

    @Override
    public void send() {
        this.webClientImpl.sendCustomerUpdateEmail(commonMessageDTO);
    }
}
