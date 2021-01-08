package com.crio.buildouts.controller;

import com.crio.buildouts.dto.QuestionDto;
import com.crio.buildouts.exchanges.GetQuestionResponse;
import com.crio.buildouts.exchanges.ValidAnswerResponse;
import com.crio.buildouts.exchanges.ValidateAnswersRequest;
import com.crio.buildouts.service.QuizService;

import java.util.List;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequestMapping("/quiz/{moduleId}")
@RestController
public class QuizController {

  public static final String QUIZ_API = "/questions/{moduleID}";

  @Autowired
  private QuizService quizservice;

  @PutMapping
  public String putQuestion(@PathVariable String moduleId, 
      @RequestBody List<QuestionDto> questions) {
    quizservice.putQuestion(moduleId, questions);
    return "";
  }

  @GetMapping
  public ResponseEntity<GetQuestionResponse> getQuestion(@PathVariable String moduleId) {
    return ResponseEntity.ok().body(quizservice.getQuestion(moduleId));
  }

  @PostMapping
  public ResponseEntity<ValidAnswerResponse> validateAnswers(@PathVariable String moduleId,
      @RequestBody ValidateAnswersRequest request) {
    return ResponseEntity.ok().body(quizservice.validateAnswers(moduleId, request));
  }

}