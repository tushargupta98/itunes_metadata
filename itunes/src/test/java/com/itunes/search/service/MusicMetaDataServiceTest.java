package com.itunes.search.service;

import com.itunes.search.dto.model.MediaMetadataDTO;
import com.itunes.search.util.ItunesApiQueryKeys;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MusicMetaDataServiceTest {

    @Mock
    private ItunesQueryService mockItunesQueryService;

    private MusicMetaDataService musicMetaDataServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        musicMetaDataServiceUnderTest = new MusicMetaDataService(mockItunesQueryService);
    }

    @Test
    public void testGetTracksByArtist() {
        // Setup
        final MediaMetadataDTO mediaMetadataDTO = new MediaMetadataDTO();
        mediaMetadataDTO.setArtistName("artistName");
        final List<MediaMetadataDTO> expectedResult = Arrays.asList(mediaMetadataDTO);

        // Configure ItunesQueryService.search(...).
        final MediaMetadataDTO mediaMetadataDTO1 = new MediaMetadataDTO();
        mediaMetadataDTO1.setArtistName("artistName");
        final List<MediaMetadataDTO> mediaMetadataDTOS = Arrays.asList(mediaMetadataDTO1);
        Map<ItunesApiQueryKeys, String> params = new HashMap<>();
        params.put(ItunesApiQueryKeys.TERM, "artistName");
        params.put(ItunesApiQueryKeys.ENTITY, "musicTrack");
        params.put(ItunesApiQueryKeys.ATTRIBUTE, "artistTerm");
        when(mockItunesQueryService.search(params)).thenReturn(mediaMetadataDTOS);

        // Run the test
        final List<MediaMetadataDTO> result = musicMetaDataServiceUnderTest.getTracksByArtist("artistName");

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
