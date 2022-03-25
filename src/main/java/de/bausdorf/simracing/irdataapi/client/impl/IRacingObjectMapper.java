package de.bausdorf.simracing.irdataapi.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class IRacingObjectMapper extends ObjectMapper {

    public IRacingObjectMapper() {
        super();
        registerModule(new JavaTimeModule());
        enable(SerializationFeature.INDENT_OUTPUT);
    }
}
