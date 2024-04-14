package com.example.openfeignclient.dto.response;

import com.example.openfeignclient.model.Song;

public record PartiallyUpdateSongResponseDto(Song updatedSong) implements Response {
}
