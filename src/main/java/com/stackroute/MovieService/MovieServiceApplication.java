package com.stackroute.MovieService;

import com.stackroute.MovieService.domain.Movie;
import com.stackroute.MovieService.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Arrays;
import java.util.List;
@EnableDiscoveryClient
//@EnableEurekaClient
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MovieServiceApplication  {

	public static void main(String[] args) {

		SpringApplication.run(MovieServiceApplication.class, args);

	}
//	private MovieRepository movieRepository;
//	@Autowired
//	public MovieServiceApplication(MovieRepository movieRepository) {
//		this.movieRepository = movieRepository;
//	}
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//
//		movieRepository.save(new Movie(1,"Harry Potter"));
//		movieRepository.save(new Movie(2,"Fast & Furious"));
//	}

}
