package com.github.denpeshkov.componentlibraryserver.game_statistics;

import com.github.denpeshkov.componentlibraryserver.game_statistics.exceptions.NoStatisticsException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class GameStatisticsService {

  private final GameStatisticsRepository gameStatisticsRepository;

  @Autowired
  public GameStatisticsService(
      GameStatisticsRepository gameStatisticsRepository) {
    this.gameStatisticsRepository = gameStatisticsRepository;
  }

  public GameStatistics getGameStatistics(int id) throws NoStatisticsException {
    Optional<GameStatistics> gameStatisticsOptional = gameStatisticsRepository.findById(id);

    if (gameStatisticsOptional.isEmpty()) {
      throw new NoStatisticsException(
          String.format("Statistics for game with id %d not found!", id));
    }

    return gameStatisticsOptional.get();
  }

  public void saveGameStatistics(GameStatistics gameStatistics) {
    gameStatisticsRepository.save(gameStatistics);
  }

  /**
   * @param gameStatistics game's statistics
   * @return {@code true} if created, {@code false} if updated
   */
  public boolean updateGameStatistics(GameStatistics gameStatistics) {
    if (!gameStatisticsRepository.existsById(gameStatistics.getId())) {
      saveGameStatistics(gameStatistics);
      return true;
    }

    GameStatistics gameStatisticsOld = gameStatisticsRepository.findById(gameStatistics.getId())
        .get();
    GameStatistics gameStatisticsNew = new GameStatistics(gameStatisticsOld.getId(),
        gameStatistics);

    gameStatisticsRepository.save(gameStatisticsNew);

    return false;
  }

}
