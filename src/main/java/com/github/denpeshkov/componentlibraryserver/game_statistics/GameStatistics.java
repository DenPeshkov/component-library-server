package com.github.denpeshkov.componentlibraryserver.game_statistics;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class GameStatistics {
  private final DIFFICULTY difficulty;
  private final int countOfCorrectAnswers;

  @JsonFormat(pattern = "HH:mm:ss")
  @ApiModelProperty(required = true, example = "21:51:08", dataType = "org.joda.time.LocalTime")
  private final LocalTime solvingTime;

  private final Integer countOfTests;

  @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  @ApiModelProperty(required = true, example = "20-11-2020 21:51:08")
  private final LocalDateTime endGameDateTime;

  public GameStatistics(
      DIFFICULTY difficulty,
      int countOfCorrectAnswers,
      LocalTime solvingTime,
      Integer countOfTests,
      LocalDateTime endGameDateTime) {
    this.difficulty = difficulty;
    this.countOfCorrectAnswers = countOfCorrectAnswers;
    this.solvingTime = solvingTime;
    this.countOfTests = countOfTests;
    this.endGameDateTime = endGameDateTime;
  }

  public DIFFICULTY getDifficulty() {
    return difficulty;
  }

  public int getCountOfCorrectAnswers() {
    return countOfCorrectAnswers;
  }

  public LocalTime getSolvingTime() {
    return solvingTime;
  }

  public Integer getCountOfTests() {
    return countOfTests;
  }

  public LocalDateTime getEndGameDateTime() {
    return endGameDateTime;
  }

  public enum DIFFICULTY {
    EASY(0),
    MEDIUM(1),
    HARD(2);

    private final int diffId;

    DIFFICULTY(int diffId) {
      this.diffId = diffId;
    }

    @JsonValue
    public int getDiffId() {
      return diffId;
    }
  }
}
