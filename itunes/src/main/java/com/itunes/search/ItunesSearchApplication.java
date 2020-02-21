package com.itunes.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author TUSHAR
 *
 * This application provides services to get metadata of the tracks available at Itunes
 * */

@SpringBootApplication
@EnableCaching
public class ItunesSearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItunesSearchApplication.class, args);
	}


}
