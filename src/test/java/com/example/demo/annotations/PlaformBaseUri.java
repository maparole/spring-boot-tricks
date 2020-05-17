package com.example.demo.annotations;

public class PlaformBaseUri {
	
	private String basePath;

	public PlaformBaseUri(String baseUri) {
		this.basePath = baseUri;
	}
	
	public String get() {
		return basePath;
	}
	
	@Override
	public String toString() {
		return get();
	}
}
