package com.crio.buildouts.service;

import com.crio.buildouts.dto.GetQuizQuestion;
import com.crio.buildouts.dto.QuestionDto;
import com.crio.buildouts.dto.SubmitQuestion;
import com.crio.buildouts.dto.ValidAnswer;
import com.crio.buildouts.exchanges.GetQuestionResponse;
import com.crio.buildouts.exchanges.ValidAnswerResponse;
import com.crio.buildouts.exchanges.ValidateAnswersRequest;
import com.crio.buildouts.models.QuizEntity;
import com.crio.buildouts.repository.QuizRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Provider;
import javax.persistence.metamodel.Type;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.expression.spel.ast.TypeReference;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
@Primary
public class QuizServiceImpl implements QuizService {
  
  @Autowired
  private MongoTemplate mongoTemplate;
  @Autowired
  private Provider<ModelMapper> modelMapperProvider;
  @Autowired
  private QuizRepository quizrepository;

  @Override
  public List<QuestionDto> putQuestion(String moduleId, List<QuestionDto> questions) 
      throws NullPointerException {

    mongoTemplate.getDb().drop();
    ModelMapper modelMapper = modelMapperProvider.get();

    List<QuestionDto> answerId = new ArrayList<>();
    for (QuestionDto question : questions) {
      answerId.add(question);
      QuizEntity a = modelMapper.map(question,QuizEntity.class); 
      mongoTemplate.save(a);
    }
    return answerId;
  }

  @Override
  public GetQuestionResponse getQuestion(String moduleId) {
    List<QuizEntity> questionentity = mongoTemplate.findAll(QuizEntity.class);
    GetQuestionResponse getQuestionResponse = new GetQuestionResponse();
    List<GetQuizQuestion> x = new ArrayList<>();
    for (QuizEntity i : questionentity) {
      GetQuizQuestion getQuizQuestion = new GetQuizQuestion();
      getQuizQuestion.setQuestionId(i.getQuestionId());
      getQuizQuestion.setTitle(i.getTitle());
      getQuizQuestion.setOptions(i.getOptions());
      getQuizQuestion.setType(i.getType());
      x.add(getQuizQuestion);
    }
    getQuestionResponse.setQuestions(x);
    return getQuestionResponse;
  }

  @Override
  public ValidAnswerResponse validateAnswers(String moduleId, ValidateAnswersRequest request) {

    List<QuizEntity> quizQuestions = mongoTemplate.findAll(QuizEntity.class);

    Map<String,Integer> summary = new HashMap<>();
    summary.put("score", 0);
    summary.put("total", quizQuestions.size());
    
    ValidAnswerResponse validAnswerResponse = new ValidAnswerResponse();
    List<ValidAnswer> validAnswers = new ArrayList<>();

    for (SubmitQuestion i : request.getResponses()) {

      String questionid = i.getQuestionId();

      for (QuizEntity j : quizQuestions) {

        if (j.getQuestionId().equals(questionid)) {
          
          ValidAnswer temp = new ValidAnswer();
          temp.setQuestionId(j.getQuestionId());
          temp.setTitle(j.getTitle());
          temp.setDescription(j.getDescription());
          temp.setType(j.getType());
          temp.setOptions(j.getOptions());
          temp.setCorrect(j.getCorrectAnswer());
          temp.setUserAnswer(i.getUserResponse());
          temp.setExplanation(null);

          if (j.getCorrectAnswer().equals(i.getUserResponse())) {
            summary.put("score", summary.get("score") + 1);
            temp.setAnswerCorrect(true);
          } else {
            temp.setAnswerCorrect(false);
          }
          validAnswers.add(temp);
        }

      }

    }

    validAnswerResponse.setSummary(summary);
    validAnswerResponse.setQuestions(validAnswers);
    return validAnswerResponse;
  }

}