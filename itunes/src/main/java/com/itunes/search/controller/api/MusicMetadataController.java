package com.itunes.search.controller.api;

import com.itunes.search.controller.request.ArtistTracksRequest;
import com.itunes.search.service.MusicMetaDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author TUSHAR
 * This controller provides the endpoints to access the MusicEntity metadata from itunes apis.
 * */

@Slf4j
@RestController
@RequestMapping("/artist")
public class MusicMetadataController {
    final private MusicMetaDataService musicMetaDataService;

    @Autowired
    public MusicMetadataController(final MusicMetaDataService musicMetaDataService) {
        this.musicMetaDataService = musicMetaDataService;
    }

    @GetMapping(path = "/tracks", produces = "application/json")
    public ResponseEntity getTracksByArtist(@Valid ArtistTracksRequest artistTracksRequest){
        String artistName =artistTracksRequest.getFirstName()+" "+artistTracksRequest.getLastName();
        log.info("Request to search tracks for the artist = {}", artistName);
        return ResponseEntity.ok().body(
                musicMetaDataService.getTracksByArtist(artistName));
    }
}
