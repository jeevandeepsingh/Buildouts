package com.crio.buildouts.exchanges;

import com.crio.buildouts.dto.GetQuizQuestion;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetQuestionResponse {
  
  private List<GetQuizQuestion> questions = new ArrayList<>();
} 