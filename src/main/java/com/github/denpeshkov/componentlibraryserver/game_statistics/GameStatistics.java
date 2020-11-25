package com.github.denpeshkov.componentlibraryserver.game_statistics;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class GameStatistics {
  @ApiModelProperty(
          value = "Сложность",
          required = true,
          example = "0")
  private final DIFFICULTY difficulty;

  @ApiModelProperty(
          value = "Количество правильных ответов",
          required = true,
          example = "3")
  private final int countOfCorrectAnswers;

  @ApiModelProperty(
      value = "Среднее время решения здачи в секундах",
      required = true,
      example = "100")
  private final int solvingTime;

  @ApiModelProperty(
          value = "Количество тестов",
          required = true,
          example = "5")
  private final Integer countOfTests;

  @ApiModelProperty(
      value = "Время окончания игры",
      required = true,
      example = "2020-11-25T19:42:18.298Z")
  private final LocalDateTime endGameDateTime;

  public GameStatistics(
      DIFFICULTY difficulty,
      int countOfCorrectAnswers,
      int solvingTime,
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

  public int getSolvingTime() {
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
