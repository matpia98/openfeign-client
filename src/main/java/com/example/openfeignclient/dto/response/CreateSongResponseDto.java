package com.example.openfeignclient.dto.response;

import com.example.openfeignclient.model.Song;

public record CreateSongResponseDto(Song song) implements Response {

}
