package com.itunes.search.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author TUSHAR
 *
 * Generic medatadata dto fetch the results from itunes api. specifically the track metadata.
 * It can be used accross various services.
 * */

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaMetadataDTO implements Serializable {
	@JsonProperty(value="artistName")
	private String artistName;
	@JsonProperty(value="kind")
	private String kind;
	@JsonProperty(value="collectionName")
	private String artistAlbum;
	@JsonProperty(value="collectionPrice")
	private Float albumPrice;
	@JsonProperty(value="trackName")
	private String trackName;
	@JsonProperty(value="primaryGenreName")
	private String primaryGenre;
}
