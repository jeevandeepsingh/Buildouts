package com.crio.buildouts.exchanges;

import com.crio.buildouts.dto.ValidAnswer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidAnswerResponse {
  
  List<ValidAnswer> questions = new ArrayList<>();
  Map<String,Integer> summary = new HashMap<>();
} 