package com.example.openfeignclient.dto.response;

import com.example.openfeignclient.model.Song;

public record GetSongResponseDto(Song song) implements Response {

}
