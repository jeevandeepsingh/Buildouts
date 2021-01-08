package com.crio.buildouts.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidAnswer {
  String questionId;
  String title;
  String description;
  String type;
  Map<String,String> options;
  List<String> userAnswer;
  List<String> correct;
  String explanation;
  Boolean answerCorrect;
}