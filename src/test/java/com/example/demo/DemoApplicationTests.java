package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.annotations.PlaformBaseUri;
import com.example.demo.annotations.WebAndMobile;
import com.example.demo.annotations.WebOnly;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

	static String lol;

	@BeforeAll
	public static void beforeAll() {
		lol = "LOL";
	}

	@WebAndMobile
	@ParameterizedTest
	void getSomethingFromBoth(PlaformBaseUri baseUri) {
		assertThat(String.format("%s", baseUri)).isIn(Arrays.asList("/api/web", "/api/mobile"));
		assertThat(lol).isEqualTo("LOL");
	}

	@WebAndMobile
	@ParameterizedTest
	void getSomethingAgainFromBoth(PlaformBaseUri baseUri) {
		assertThat(baseUri + "").isIn(Arrays.asList("/api/web", "/api/mobile"));
		assertThat(lol).isEqualTo("LOL");
	}

	@WebOnly
	@ParameterizedTest
	void getSomethingAgainFromWebOnly(PlaformBaseUri baseUri) {
		assertThat(baseUri.get()).isEqualTo("/api/web");
	}
}
