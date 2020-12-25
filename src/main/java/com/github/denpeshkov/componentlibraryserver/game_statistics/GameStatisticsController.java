package com.github.denpeshkov.componentlibraryserver.game_statistics;

import com.github.denpeshkov.componentlibraryserver.game_statistics.exceptions.NoStatisticsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class GameStatisticsController {

  private final GameStatisticsService gameStatisticsService;

  @Autowired
  public GameStatisticsController(GameStatisticsService gameStatisticsService) {
    this.gameStatisticsService = gameStatisticsService;
  }

  @PostMapping("/{id}")
  public ResponseEntity<GameStatistics> updateStatistics(
      @PathVariable int id, @RequestBody GameStatistics gameStatistics) {
    gameStatistics.setGame_id(id);
    gameStatisticsService.saveGameStatistics(gameStatistics);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public GameStatistics getStatistics(@PathVariable int id) {
    try {
      return gameStatisticsService.getGameStatistics(id);
    } catch (NoStatisticsException e) {
      throw new ResponseStatusException(HttpStatus.OK, e.getLocalizedMessage(), e);
    }
  }
}
