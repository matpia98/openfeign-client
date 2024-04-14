package com.example.openfeignclient.client;

import com.example.openfeignclient.config.FeignClientConfig;
import com.example.openfeignclient.dto.request.CreateSongRequestDto;
import com.example.openfeignclient.dto.request.PartiallyUpdateSongRequestDto;
import com.example.openfeignclient.dto.request.UpdateSongRequestDto;
import com.example.openfeignclient.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "songify-client", configuration = FeignClientConfig.class)
public interface ServerProxy {

    @GetMapping("/songs")
    GetAllSongsResponseDto fetchAllSongs();

    @GetMapping("/songs/{id}")
    GetSongResponseDto getSongById(
            @PathVariable Integer id
    );

    @PostMapping("/songs")
    CreateSongResponseDto postSong(@RequestBody CreateSongRequestDto createSongRequestDto);

    @DeleteMapping("/songs/{id}")
    DeleteSongResponseDto deleteSongById(@PathVariable Integer id);

    @PutMapping("/songs/{id}")
    UpdateSongResponseDto updateSong(@PathVariable Integer id, @RequestBody UpdateSongRequestDto request);

    @PatchMapping("/songs/{id}")
    PartiallyUpdateSongResponseDto partiallyUpdateSong(@PathVariable Integer id, @RequestBody PartiallyUpdateSongRequestDto request);

}
