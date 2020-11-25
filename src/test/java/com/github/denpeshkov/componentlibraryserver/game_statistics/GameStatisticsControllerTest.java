package com.github.denpeshkov.componentlibraryserver.game_statistics;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GameStatisticsController.class)
@ExtendWith(MockitoExtension.class)
class GameStatisticsControllerTest {
  @Autowired private MockMvc mockMvc;

  // used to emulate browser send JSON requests
  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  void updateStatistics() throws Exception {
    String request =
        "{\"countOfCorrectAnswers\":0,\"countOfTests\":5,\"difficulty\":0,\"endGameDateTime\":\"2020-11-25T19:42:18.298Z\",\"solvingTime\":1553}";

    mockMvc
        .perform(put("/api/13").contentType(MediaType.APPLICATION_JSON).content(request))
        .andExpect(status().isNoContent())
        .andDo(print());
  }

  @Test
  void getStatistics() throws Exception {
    mockMvc
            .perform(MockMvcRequestBuilders.get("/api/13").contentType(MediaType.APPLICATION_JSON))
            .andDo(print());
  }
}
