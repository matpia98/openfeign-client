package com.example.openfeignclient;

import com.example.openfeignclient.client.ServerProxy;
import com.example.openfeignclient.dto.request.CreateSongRequestDto;
import com.example.openfeignclient.dto.request.PartiallyUpdateSongRequestDto;
import com.example.openfeignclient.dto.request.UpdateSongRequestDto;
import com.example.openfeignclient.dto.response.*;
import com.example.openfeignclient.utility.JsonFormatter;
import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@Log4j2
@SpringBootApplication
@EnableFeignClients
public class OpenfeignClientApplication {

	ServerProxy serverProxy;

	JsonFormatter jsonFormatter;

	public OpenfeignClientApplication(ServerProxy serverProxy, JsonFormatter jsonFormatter) {
		this.serverProxy = serverProxy;
		this.jsonFormatter = jsonFormatter;
	}

	public static void main(String[] args) {
		SpringApplication.run(OpenfeignClientApplication.class, args);
	}

	@EventListener(ApplicationStartedEvent.class)
	public void start() {
		try {
			CreateSongResponseDto createSongResponseDto = serverProxy.postSong(new CreateSongRequestDto("Umbrella", "Rihanna"));
			jsonFormatter.logCreateSongResponse(createSongResponseDto);

			GetAllSongsResponseDto getAllSongsResponseDto = serverProxy.fetchAllSongs();
			jsonFormatter.logGetAllSongsResponse(getAllSongsResponseDto);

			GetSongResponseDto songById = serverProxy.getSongById(5);
			jsonFormatter.logGetSongResponse(songById);

			UpdateSongResponseDto updateSongResponseDto = serverProxy.updateSong(5, new UpdateSongRequestDto("New Song", "New Artist"));
			jsonFormatter.logUpdateSongResponse(updateSongResponseDto);

			PartiallyUpdateSongResponseDto updateResponse = serverProxy.partiallyUpdateSong(5, new PartiallyUpdateSongRequestDto("New Song Name", null));
			jsonFormatter.logPartiallyUpdateSongResponse(updateResponse);

			DeleteSongResponseDto deleteSongResponseDto = serverProxy.deleteSongById(5);
			jsonFormatter.logDeleteSongResponseDto(deleteSongResponseDto);

			jsonFormatter.logGetAllSongsResponse(serverProxy.fetchAllSongs());
		} catch (FeignException.FeignClientException feignException) {
			log.error("client exception: " + feignException.status() + ", " + feignException.getMessage());
		} catch (FeignException.FeignServerException feignException) {
			System.out.println("server exception: " + feignException.status() + ", " + feignException.getMessage());
		} catch (RetryableException retryableException) {
			System.out.println("retrayable exception: " + retryableException.getMessage());
		} catch (FeignException feignException) {
			System.out.println(feignException.getMessage());
			System.out.println(feignException.status());
		}



	}

}
