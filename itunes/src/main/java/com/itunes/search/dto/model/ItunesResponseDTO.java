package com.itunes.search.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author TUSHAR
 *
 * This encapsulates the result provided by the invlocation the itunes api
 * */

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItunesResponseDTO implements Serializable {
	@JsonProperty(value ="resultCount")
	private Long resultCount;
	@JsonProperty(value ="results")
	private MediaMetadataDTO[] result;
}
