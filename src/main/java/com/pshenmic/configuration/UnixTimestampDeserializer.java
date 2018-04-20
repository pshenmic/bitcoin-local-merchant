package com.pshenmic.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Instant;

public class UnixTimestampDeserializer extends JsonDeserializer {

    private final Logger log = LoggerFactory.getLogger(UnixTimestampDeserializer.class);


    @Override
    public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String timestampSeconds = jsonParser.getText().trim();

        try {
            return Instant.ofEpochSecond(Long.parseLong(timestampSeconds));
            //return LocalDateTime.ofEpochSecond(Long.parseLong(timestamp), 0, ZoneOffset.of(ZoneId.systemDefault().getId()));
        } catch (NumberFormatException e) {
            log.warn("Unable to deserialize timestamp: " + timestampSeconds, e);
            return null;
        }
    }
}
