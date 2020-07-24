package com.builder.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Test
	void builderTest() throws JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();

		// Build
		Pet pet = new Pet.PetBuilder().name("Maya").owner("Yamil").age(2).build();
		Cat cat = new Cat.CatBuilder().pet(pet).lives(9).build();

		// Serialize
		String jsonString = objectMapper.writeValueAsString(cat);

		Assertions.assertEquals(
        "{\"pet\":{\"name\":\"Maya\",\"owner\":\"Yamil\",\"age\":2},\"lives\":9}", jsonString);

		// Deserialize
		cat = objectMapper.readValue(jsonString, Cat.class);

		Assertions.assertEquals("Maya", cat.getPet().getName());
		Assertions.assertEquals("Yamil", cat.getPet().getOwner());
		Assertions.assertEquals(2, cat.getPet().getAge());
		Assertions.assertEquals(9, cat.getLives());


	}

}
