package com.app.network.errorhandlers;

import java.io.IOException;


public final class OfflineException extends IOException {
  private final Throwable throwable;

  public OfflineException(final Throwable throwable) {
    super("");
    this.throwable = throwable;
  }

  public OfflineException(final String message, final Throwable throwable) {
    super(message);
    this.throwable = throwable;
  }


}
