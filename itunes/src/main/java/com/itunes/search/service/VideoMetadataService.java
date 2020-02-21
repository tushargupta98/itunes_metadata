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
 * This service provides the metadata for the music videos
 * */

@Slf4j
@Service
public class VideoMetadataService {

    private ItunesQueryService itunesQueryService;

    @Autowired
    public VideoMetadataService(ItunesQueryService itunesQueryService) {
        this.itunesQueryService = itunesQueryService;
    }

    /**
     * This method provides the meta data for all the music video tracks available with Itunes for aa given artist
     * */
    @Cacheable("videosByArtist")
    public List<MediaMetadataDTO> getTracksByArtist(final String artistName) {
        log.info("Query Parameter: Artist Name = {}", artistName);
        final Map<ItunesApiQueryKeys, String> params = new HashMap<>();
        params.put(ItunesApiQueryKeys.TERM, artistName);
        params.put(ItunesApiQueryKeys.ENTITY, "musicVideo");
        params.put(ItunesApiQueryKeys.ATTRIBUTE, "allArtistTerm");
        return itunesQueryService.search(params);
    }


}
