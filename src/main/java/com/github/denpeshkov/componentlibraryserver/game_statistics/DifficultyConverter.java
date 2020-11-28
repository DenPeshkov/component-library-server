package com.github.denpeshkov.componentlibraryserver.game_statistics;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DifficultyConverter implements AttributeConverter<Difficulty, Integer> {

  @Override
  public Integer convertToDatabaseColumn(Difficulty difficulty) {
    return difficulty == null ? null : difficulty.getDiffId();
  }

  @Override
  public Difficulty convertToEntityAttribute(Integer diffId) {
    return Difficulty.of(diffId);
  }
}
