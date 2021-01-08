package com.crio.buildouts.exchanges;

import com.crio.buildouts.dto.SubmitQuestion;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateAnswersRequest {
  List<SubmitQuestion> responses = new ArrayList<>();
}