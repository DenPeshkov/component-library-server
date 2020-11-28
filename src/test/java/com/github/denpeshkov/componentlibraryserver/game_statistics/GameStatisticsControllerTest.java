package com.github.denpeshkov.componentlibraryserver.game_statistics;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameStatisticsController.class)
@ExtendWith(MockitoExtension.class)
class GameStatisticsControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  GameStatisticsService gameStatisticsService;

  // used to emulate browser send JSON requests
  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  void updateStatistics() throws Exception {
    String request =
        "{\"countOfCorrectAnswers\":0,\"countOfTests\":5,\"difficulty\":0,\"endGameDateTime\":\"2020-11-25T19:42:18.298Z\",\"solvingTime\":1553}";

    when(gameStatisticsService.updateGameStatistics(any())).thenReturn(true);

    mockMvc
        .perform(put("/api/13").contentType(MediaType.APPLICATION_JSON).content(request))
        .andExpect(status().isCreated())
        .andDo(print());

    when(gameStatisticsService.updateGameStatistics(any())).thenReturn(false);

    mockMvc
        .perform(put("/api/13").contentType(MediaType.APPLICATION_JSON).content(request))
        .andExpect(status().isNoContent())
        .andDo(print());
  }

  @Test
  void getStatistics() throws Exception {
    when(gameStatisticsService.getGameStatistics(anyInt()))
        .thenReturn(new GameStatistics(0, Difficulty.EASY, 10, 100, 5,
            LocalDateTime.now()));
    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/13").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print());
  }
}
