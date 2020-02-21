package com.itunes.search.service;

import com.itunes.search.dto.model.MediaMetadataDTO;
import com.itunes.search.util.ItunesApiQueryKeys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TUSHAR
 *
 * This service provides the access to the metadata of all the music tracks available at itunes
 * */

@Slf4j
@Service
public class MusicMetaDataService {

    private ItunesQueryService itunesQueryService;
    @Autowired
    public MusicMetaDataService(ItunesQueryService itunesQueryService) {
        this.itunesQueryService = itunesQueryService;
    }

    /**
     * This service provides the access to all the music track metadata belonging to an artist.
     * */
    @Cacheable(value = "musicByArtist", key="{#artistName}")
    public List<MediaMetadataDTO> getTracksByArtist(final String artistName) {
        log.info("Query Parameter: Artist Name = {}", artistName);
        final Map<ItunesApiQueryKeys, String> params = new HashMap<>();
        params.put(ItunesApiQueryKeys.TERM, artistName);
        params.put(ItunesApiQueryKeys.ENTITY, "musicTrack");
        params.put(ItunesApiQueryKeys.ATTRIBUTE, "artistTerm");
        return itunesQueryService.search(params);
    }

}
