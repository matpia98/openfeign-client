package com.example.openfeignclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonFormatter {

    private final ObjectMapper mapper;

    public JsonFormatter(ObjectMapper mapper) {
        this.mapper = mapper;
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void logCreateSongResponse(CreateSongResponseDto response) {
        log.info("New song created: " + formatToJson(response));
    }

    public void logGetAllSongsResponse(GetAllSongsResponseDto response) {
        log.info("Songs list: " + formatToJson(response));
    }

    public void logGetSongResponse(GetSongResponseDto response) {
        log.info(formatToJson(response));
    }

    public void logUpdateSongResponse(UpdateSongResponseDto response) {
        log.info("Song updated: " + formatToJson(response));
    }

    public void logPartiallyUpdateSongResponse(PartiallyUpdateSongResponseDto response) {
        log.info("Partially updated Song: " + formatToJson(response));
    }

    public void logDeleteSongResponseDto(DeleteSongResponseDto response) {
        log.info(formatToJson(response));
    }

    private String formatToJson(Response response) {
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            log.error("Error while formatting JSON", e);
            return "{}";
        }
    }

}
