package com.crio.buildouts.service;

import com.crio.buildouts.dto.QuestionDto;
import com.crio.buildouts.exchanges.GetQuestionResponse;
import com.crio.buildouts.exchanges.ValidAnswerResponse;
import com.crio.buildouts.exchanges.ValidateAnswersRequest;

import java.util.List;

public interface QuizService {
  public List<QuestionDto> putQuestion(String moduleId, List<QuestionDto> questions);

  public GetQuestionResponse getQuestion(String moduleId);

  public ValidAnswerResponse validateAnswers(String moduleId, ValidateAnswersRequest request);
}