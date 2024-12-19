package com.aluracourse.literalura.service;

import com.aluracourse.literalura.interfaces.DataConverterInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonParseService implements DataConverterInterface {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> className) {
        try {
            return objectMapper.readValue(json,className);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}