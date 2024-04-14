package com.example.openfeignclient;

public record PartiallyUpdateSongResponseDto(Song updatedSong) implements Response {
}
