package com.example.openfeignclient;

public record UpdateSongResponseDto(String song, String artist) implements Response {
}
