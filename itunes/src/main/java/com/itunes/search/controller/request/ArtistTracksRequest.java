package com.itunes.search.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author TUSHAR
 *
 * This class encapsulates the request paraments provide to the get endpoint to query track metadata
 *
 * */

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistTracksRequest {
	@NotNull
	@Size(min = 1)
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;


}
