package com.example.herokudemo.web.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageTemplateDTO {
    private String userId;
    private String mobile;
    private String email;
    private String hkId;
    private String brand;
    @JsonProperty("opt-out")
    private boolean optOut;
}
