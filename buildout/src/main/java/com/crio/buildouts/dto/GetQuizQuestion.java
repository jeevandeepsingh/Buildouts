package com.crio.buildouts.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetQuizQuestion {
  
  private String questionId;
  private String title; 
  private String type;
  private Map<String,String> options;
}