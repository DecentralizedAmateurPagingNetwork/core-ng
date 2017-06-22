package org.dapnet.core.transmission;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.dapnet.core.transmission.PagerMessage.MessagePriority;
import org.dapnet.core.transmission.PagerMessage.MessageType;

final class SkyperMessageFactory implements PagerMessageFactory {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("HHmmss   ddMMyy");
	private static final int TIME_ADDRESS = 2504;
	private static final int RUBRIC_ADDRESS = 4512;
	private static final int NEWS_ADDRESS = 4520;

	@Override
	public PagerMessage fromTime(ZonedDateTime time) {
		return new PagerMessage(DATE_FORMATTER.format(time), MessagePriority.TIME, MessageType.NUMERIC, TIME_ADDRESS);
	}

}
