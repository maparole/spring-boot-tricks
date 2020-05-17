package com.example.demo.annotations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

class WebAndMobileUriProvider implements ArgumentsProvider {

	private static final String[] PROPS_KEYS = { Dictionary.WEB, Dictionary.MOBILE };

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context)
			throws FileNotFoundException, IOException {
		return Arrays.stream(PROPS_KEYS)
				.map(PropertiesProvider::getProperty)
				.map(PlaformBaseUri::new)
				.map(Arguments::of);
	}
}