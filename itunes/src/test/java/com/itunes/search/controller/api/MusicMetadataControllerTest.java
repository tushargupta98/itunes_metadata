package com.itunes.search.controller.api;

import com.itunes.search.controller.request.ArtistTracksRequest;
import com.itunes.search.dto.model.MediaMetadataDTO;
import com.itunes.search.service.MusicMetaDataService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MusicMetadataControllerTest {

    @Mock
    private MusicMetaDataService mockMusicMetaDataService;

    private MusicMetadataController musicMetadataControllerUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        musicMetadataControllerUnderTest = new MusicMetadataController(mockMusicMetaDataService);
    }

    @Test
    public void testGetTracksByArtist() {
        // Setup
        final ArtistTracksRequest artistTracksRequest = new ArtistTracksRequest();

        // Configure MusicMetaDataService.getTracksByArtist(...).
        final MediaMetadataDTO mediaMetadataDTO = new MediaMetadataDTO();
        mediaMetadataDTO.setArtistName("artistName");
        final List<MediaMetadataDTO> mediaMetadataDTOS = Arrays.asList(mediaMetadataDTO);
        when(mockMusicMetaDataService.getTracksByArtist("artistName")).thenReturn(mediaMetadataDTOS);

        // Run the test
        final ResponseEntity result = musicMetadataControllerUnderTest.getTracksByArtist(artistTracksRequest);

        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        // Verify the results
    }
}
