package com.itunes.search.service;

import com.itunes.search.dto.model.ItunesResponseDTO;
import com.itunes.search.dto.model.MediaMetadataDTO;
import com.itunes.search.util.ItunesApiQueryKeys;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author TUSHAR
 * This service helps to query the data from the itunes api
 * */

@Slf4j
@Service
public class ItunesQueryService {

    private static String SCHEME;
    private static String HOST;
    private static String PATH;
    private RestTemplate restTemplate;

    @Autowired
    public ItunesQueryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${itunes.scheme}")
    public void setScheme(String scheme){
        SCHEME = scheme;
    }

    @Value("${itunes.host}")
    public void setHost(String host){
        HOST = host;
    }

    @Value("${itunes.path}")
    public void setPath(String path){
        PATH = path;
    }

    /**
     * This service invokes the itunes api to fetch the results based on the query parameters passed to it.
     *
     * */
    List<MediaMetadataDTO> search(final Map<ItunesApiQueryKeys, String> queryParams) {
        String url = getURL(queryParams);
        log.info("Itunes Query = {}", url);
        ItunesResponseDTO itunesResponseDTO = restTemplate.getForObject(url, ItunesResponseDTO.class);
        return Arrays.asList(itunesResponseDTO.getResult())
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
    private String getURL(final Map<ItunesApiQueryKeys, String> params){

        URIBuilder builder = new URIBuilder()
                .setScheme(SCHEME)
                .setHost(HOST)
                .setPath(PATH);
        for(Map.Entry<ItunesApiQueryKeys, String> param:params.entrySet()){
            builder.setParameter(param.getKey().getKey(), param.getValue());
        }
        return builder.toString();
    }
}
