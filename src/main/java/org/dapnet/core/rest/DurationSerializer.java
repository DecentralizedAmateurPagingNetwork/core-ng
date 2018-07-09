package org.dapnet.core.rest;

import java.io.IOException;
import java.time.Duration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * Custom serializer for {@link Duration} objects.
 * 
 * @author Philipp Thiel
 */
class DurationSerializer extends StdSerializer<Duration> {

	private static final long serialVersionUID = -2737081640636524141L;

	protected DurationSerializer() {
		super(Duration.class);
	}

	@Override
	public void serialize(Duration value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.toString());
	}

}
