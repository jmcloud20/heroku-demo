package com.example.herokudemo.web.services;

import com.example.herokudemo.web.model.CommonMessageDTO;
import com.example.herokudemo.web.model.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DemoServiceImpl implements DemoService {


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

    }

    @Override
    public void forwardMessage(CommonMessageDTO message) {

    }
}
