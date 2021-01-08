package com.crio.buildouts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crio.buildouts.dto.QuestionDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuizControllerTest {
  
  @Mock
  QuizController quizController;

  @Test
  public void putQuestion() {

    QuestionDto questiondto1 = QuestionDto.builder()
          .correctAnswer(Collections.singletonList("abc"))
          .description("gdf")
          .questionId("001")
          .title("dds")
          .type("cdf")
          .build();

    QuestionDto questiondto2 = QuestionDto.builder()
        .correctAnswer(Collections.singletonList("def"))
        .description("gdasf")
        .questionId("002")
        .title("ddsc")
        .type("cdfwe")
        .build();

    List<QuestionDto> questions = new ArrayList<>();
    questions.add(questiondto1);
    questions.add(questiondto2);

    String response = quizController.putQuestion("1", questions);

    assertEquals(null, response);
  }

}