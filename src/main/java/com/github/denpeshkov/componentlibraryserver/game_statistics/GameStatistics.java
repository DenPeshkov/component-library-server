package com.github.denpeshkov.componentlibraryserver.game_statistics;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "GameStatistics_6")
public class GameStatistics {

  @Id
  @ApiModelProperty(value = "id игры", required = true, example = "0")
  @JsonIgnore
  private int id;

  @ApiModelProperty(value = "Сложность", required = true, example = "0")
  private Difficulty difficulty;

  @ApiModelProperty(value = "Сложность", required = true, example = "0")
  private int countOfCorrectAnswers;

  @ApiModelProperty(
      value = "Среднее время решения здачи в секундах",
      required = true,
      example = "100")
  private int solvingTime;

  @ApiModelProperty(value = "Количество тестов", required = true, example = "5")
  private Integer countOfTests;

  @ApiModelProperty(
      value = "Время окончания игры",
      required = true,
      example = "2020-11-25T19:42:18.298Z")
  private LocalDateTime endGameDateTime;

  public GameStatistics() {}

  public GameStatistics(int id, GameStatistics gameStatistics) {
    this.id=id;
    difficulty = gameStatistics.getDifficulty();
    countOfCorrectAnswers = gameStatistics.getCountOfCorrectAnswers();
    solvingTime = gameStatistics.getSolvingTime();
    countOfTests = gameStatistics.getCountOfTests();
    endGameDateTime = gameStatistics.getEndGameDateTime();
  }

  public GameStatistics(
      int id,
      Difficulty difficulty,
      int countOfCorrectAnswers,
      int solvingTime,
      Integer countOfTests,
      LocalDateTime endGameDateTime) {
    this.id = id;
    this.difficulty = difficulty;
    this.countOfCorrectAnswers = countOfCorrectAnswers;
    this.solvingTime = solvingTime;
    this.countOfTests = countOfTests;
    this.endGameDateTime = endGameDateTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  public int getCountOfCorrectAnswers() {
    return countOfCorrectAnswers;
  }

  public void setCountOfCorrectAnswers(int countOfCorrectAnswers) {
    this.countOfCorrectAnswers = countOfCorrectAnswers;
  }

  public int getSolvingTime() {
    return solvingTime;
  }

  public void setSolvingTime(int solvingTime) {
    this.solvingTime = solvingTime;
  }

  public Integer getCountOfTests() {
    return countOfTests;
  }

  public void setCountOfTests(Integer countOfTests) {
    this.countOfTests = countOfTests;
  }

  public LocalDateTime getEndGameDateTime() {
    return endGameDateTime;
  }

  public void setEndGameDateTime(LocalDateTime endGameDateTime) {
    this.endGameDateTime = endGameDateTime;
  }
}
