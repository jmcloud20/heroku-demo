package com.example.herokudemo.web.mapper;

import com.example.herokudemo.web.model.CommonMessageDTO;
import com.example.herokudemo.web.model.CommonMessageTemplateDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CommonMessageMapper {
    CommonMessageTemplateDTO regularToTemplate(CommonMessageDTO commonMessageDTO);
}
