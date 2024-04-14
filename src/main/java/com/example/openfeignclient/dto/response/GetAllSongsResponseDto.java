package com.example.openfeignclient.dto.response;

import com.example.openfeignclient.model.Song;

import java.util.Map;

public record GetAllSongsResponseDto(Map<Integer, Song> songs) implements Response {

}
