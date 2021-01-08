package com.crio.buildouts.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
{
    "questionId": "001",
    "userResponse": ["1"]
}
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitQuestion {

  private String questionId;
  List<String> userResponse = new ArrayList<>();  
}