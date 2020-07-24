package com.builder.demo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

@JsonDeserialize(builder = Cat.CatBuilder.class)
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cat {
	private Pet pet;
	private int lives;

	@JsonPOJOBuilder(withPrefix = "")
	public static class CatBuilder {

	}
}
