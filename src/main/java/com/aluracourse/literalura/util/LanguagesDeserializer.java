package com.aluracourse.literalura.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.List;

public class LanguagesDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        if (p.isExpectedStartArrayToken()) {
            List<String> languages = p.readValueAs(List.class);
            return String.join(", ", languages); // Concatenar los valores
        }
        return p.getValueAsString();
    }
}
