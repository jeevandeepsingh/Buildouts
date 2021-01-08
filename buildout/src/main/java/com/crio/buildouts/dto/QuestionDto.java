package com.crio.buildouts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
// Complete the class such that it produces the following JSON during serialization.
{
    "questionId": "001",
    "title": "What is the default IP address of localhost?",
    "description": "General question",
    "type": "objective-single",
    "options": {
      "1": "0.0.0.0",
      "2": "192.168.0.12",
      "3": "127.0.0.1",
      "4": "255.255.255.255"
    },
    "correctAnswer": [
      "4"
    ]
  }
*/


@Builder
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class QuestionDto {
  // @JsonIgnore
  private String moduleId;
  @NotNull
  private String questionId;
  @NotNull
  private String title;
  @NotNull
  private String description;
  @NotNull
  private String type;
  @NotNull
  Map<String,String> options;
  @NotNull
  List<String> correctAnswer;
}