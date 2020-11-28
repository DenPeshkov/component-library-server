package com.github.denpeshkov.componentlibraryserver.game_statistics.exceptions;

public class NoStatisticsException extends RuntimeException {

  public NoStatisticsException() {
    super("Statistics not found!");
  }

  public NoStatisticsException(String message) {
    super(message);
  }

  public NoStatisticsException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoStatisticsException(Throwable cause) {
    super(cause);
  }

  protected NoStatisticsException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
