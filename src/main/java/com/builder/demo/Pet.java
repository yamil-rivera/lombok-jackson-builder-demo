package com.builder.demo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

@JsonDeserialize(builder = Pet.PetBuilder.class)
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pet {
	private String name;
	private String owner;
	private int age;

	@JsonPOJOBuilder(withPrefix = "")
	public static class PetBuilder {

	}
}
