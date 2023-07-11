package com.example.RikMastersTest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableKafka
@EnableScheduling

public class RikMastersTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RikMastersTestApplication.class, args);
	}
	@Bean
	public JsonDeserializer jsonDeserializer() {
		return new JsonDeserializer() {
			@Override
			public Object deserialize(JsonParser p, DeserializationContext context) throws IOException {
				return null;
			}
		};
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
