package org.dapnet.core.events;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/**
 * An asynchronous event dispatcher implementation. Events are dispatched via an
 * executor.
 * 
 * @author Philipp Thiel
 */
class AsyncEventDispatcher extends EventDispatcher {

	private final Executor executor;
	private Consumer<Throwable> exceptionHandler;

	/**
	 * Creates an event dispatcher using the given executor.
	 * 
	 * @param executor
	 *            Executor to use.
	 */
	public AsyncEventDispatcher(Executor executor) {
		this.executor = Objects.requireNonNull(executor);
	}

	/**
	 * Gets the currently registered exception handler.
	 * 
	 * @return Exception handler (may be {@code null}).
	 */
	public Consumer<Throwable> getExceptionHandler() {
		return exceptionHandler;
	}

	/**
	 * Sets the exception handler that should handle uncaught exceptions.
	 * 
	 * @param exceptionHandler
	 *            Exception handler to use.
	 */
	public void setExceptionHandler(Consumer<Throwable> exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	@Override
	public <T extends Event> void dispatchEvent(EventListenerSet<T> listeners, Object sender, T event) {
		executor.execute(() -> {
			try {
				listeners.dispatchEvent(sender, event);
			} catch (Throwable t) {
				handleException(t);
			}
		});
	}

	private void handleException(Throwable cause) {
		Consumer<Throwable> theHandler = exceptionHandler;
		if (theHandler != null) {
			theHandler.accept(cause);
		}
	}

}
