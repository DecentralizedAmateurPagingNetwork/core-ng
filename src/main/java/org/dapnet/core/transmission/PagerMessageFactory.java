package org.dapnet.core.transmission;

import java.time.ZonedDateTime;

/**
 * Interface for {@link PagerMessage} factories.
 * 
 * @author Philipp Thiel
 */
interface PagerMessageFactory {

	/**
	 * Creates a message containing the given time.
	 * 
	 * @param time Time to use.
	 * @return Pager message containing the given time.
	 */
	PagerMessage fromTime(ZonedDateTime time);

}
