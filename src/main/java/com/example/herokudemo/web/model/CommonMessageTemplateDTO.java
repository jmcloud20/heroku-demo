package com.example.herokudemo.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonMessageTemplateDTO {
    private String topic;
    private String desc;
    private MessageTemplateDTO message;
}
