package com.example.demo.annotations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PropertiesProvider {
	
	private static Logger logger = LoggerFactory.getLogger(PropertiesProvider.class);

	private static Properties props = new Properties();

	static String getProperty(String key) {
		if (props.isEmpty()) {
			synchronized (props) {
				if (props.isEmpty()) {
					logger.info("Loading properties from: {}", Dictionary.PROPS_FILE_PATH);
					try (InputStream inStream = new FileInputStream(Dictionary.PROPS_FILE_PATH)) {
						props.load(inStream);
					} catch (FileNotFoundException e) {
						throw new RuntimeException(e);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		assert(props.get(key) != null);
		return props.get(key).toString();
	}
}
