package com.example.openfeignclient;

import java.util.Map;

public record GetAllSongsResponseDto(Map<Integer, Song> songs) implements Response{

}
