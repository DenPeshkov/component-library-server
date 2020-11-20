package com.github.denpeshkov.componentlibraryserver.game_statistics;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/api")
public class GameStatisticsController {
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void updateStatistics(@PathVariable String id, @RequestBody GameStatistics gameStatistics) {}

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  GameStatistics getStatistics(@PathVariable String id) {
    return new GameStatistics(
        GameStatistics.DIFFICULTY.EASY, 1, LocalTime.now(), 4, LocalDateTime.now());
  }
}
