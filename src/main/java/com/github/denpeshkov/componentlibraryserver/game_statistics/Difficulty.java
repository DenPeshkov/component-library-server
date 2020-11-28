package com.github.denpeshkov.componentlibraryserver.game_statistics;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

public enum Difficulty {
  EASY(0),
  MEDIUM(1),
  HARD(2);

  private final int diffId;

  Difficulty(int diffId) {
    this.diffId = diffId;
  }

  @JsonValue
  public int getDiffId() {
    return diffId;
  }

  public static Difficulty of(int diffId) {
    return Stream.of(Difficulty.values()).filter(c -> c.getDiffId() == diffId).findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
