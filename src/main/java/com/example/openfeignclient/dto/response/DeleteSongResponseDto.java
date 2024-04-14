package com.example.openfeignclient;

import org.springframework.http.HttpStatus;

public record DeleteSongResponseDto(String message, HttpStatus status) implements Response{
}
