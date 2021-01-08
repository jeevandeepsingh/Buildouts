package com.crio.buildouts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crio.buildouts.dto.QuestionDto;
import com.crio.buildouts.models.QuizEntity;
import com.crio.buildouts.repository.QuizRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class QuizServiceImplTest {

  @Mock
  private QuizServiceImpl quizservice;
  
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
    System.out.println(questiondto1);

    Mockito.doReturn(questions).when(quizservice).putQuestion("1", questions);
    
    List<QuestionDto> ans = quizservice.putQuestion("1", questions);
    assertEquals(2, ans.size());
    assertEquals("001", ans.get(0).getQuestionId());
    assertEquals("002", ans.get(1).getQuestionId());
  }
}