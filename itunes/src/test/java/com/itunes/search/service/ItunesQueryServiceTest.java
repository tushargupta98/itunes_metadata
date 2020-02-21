package com.itunes.search.service;

import com.itunes.search.dto.model.ItunesResponseDTO;
import com.itunes.search.dto.model.MediaMetadataDTO;
import com.itunes.search.util.ItunesApiQueryKeys;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ItunesQueryServiceTest {

    @Mock
    private RestTemplate mockRestTemplate;

    private ItunesQueryService itunesQueryServiceUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        itunesQueryServiceUnderTest = new ItunesQueryService(mockRestTemplate);
    }

    @Test
    public void testSearch() {

        final Map<ItunesApiQueryKeys, String> queryParams = new HashMap<>();
        final MediaMetadataDTO mediaMetadataDTO = new MediaMetadataDTO();
        mediaMetadataDTO.setArtistName("artistName");
        final List<MediaMetadataDTO> expectedResult = Arrays.asList(mediaMetadataDTO);

        final ItunesResponseDTO itunesResponseDTO = new ItunesResponseDTO();
        final MediaMetadataDTO[] mediaMetadataDTOS = {mediaMetadataDTO};
        itunesResponseDTO.setResult(mediaMetadataDTOS);
        itunesResponseDTO.setResultCount(1L);
        final String url = "https://itunes.apple.com/search";
        when(mockRestTemplate.getForObject(url, ItunesResponseDTO.class)).thenReturn(itunesResponseDTO);

        // Run the test
        final List<MediaMetadataDTO> result = itunesQueryServiceUnderTest.search(queryParams);

        // Verify the results
        assertEquals(expectedResult.size(), result.size());
    }

}
