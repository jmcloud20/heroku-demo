package com.example.herokudemo.web.services.loadtest;

import com.example.herokudemo.web.model.CommonMessageDTO;

public interface LoadTestClient {
    void setMessage(CommonMessageDTO commonMessageDTO);
    void send();
}
