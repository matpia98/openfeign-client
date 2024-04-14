package com.example.openfeignclient.dto.response;

public record UpdateSongResponseDto(String song, String artist) implements Response {
}
