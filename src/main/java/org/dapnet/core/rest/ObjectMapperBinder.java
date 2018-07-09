package org.dapnet.core.rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Provides the binder for injection of the Jackson {@link ObjectMapper}
 * instance.
 * 
 * @author Philipp Thiel
 */
public class ObjectMapperBinder extends AbstractBinder {

	private final ObjectMapper objectMapper = new ObjectMapper();

	public ObjectMapperBinder(RestApiConfiguration config) {
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, config.isPrettyPrint());

		SimpleModule module = new SimpleModule("configModule");
		module.addSerializer(new DurationSerializer());
		objectMapper.registerModule(module);
	}

	@Override
	protected void configure() {
		bind(objectMapper);
	}

}
