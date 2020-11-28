package com.github.denpeshkov.componentlibraryserver.game_statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStatisticsRepository extends JpaRepository<GameStatistics, Integer> {

}
