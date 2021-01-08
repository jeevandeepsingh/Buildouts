package com.crio.buildouts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;


/*
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
public class QuestionDtoTest {

  @Test
  public void serializeAndDeserializeRestaurantJson() throws IOException, JSONException {
    final String jsonString =
        "  {\n" 
          + "    \"questionId\": \"001\",\n"
          + "    \"title\": \"What is the default IP address of localhost?\",\n"
          + "    \"description\": \"General question\",\n"
          + "    \"type\": \"objective-single\",\n"
          + "    \"options\": {\n"
          + "      \"1\": \"0.0.0.0\",\n"
          + "      \"2\": \"192.168.0.12\",\n"
          + "      \"3\": \"127.0.0.1\",\n"
          + "      \"4\": \"255.255.255.255\"\n"
          + "    },\n"
          + "    \"correctAnswer\": [\n"
          + "      \"4\"\n"
          + "    ]\n"
          + "  }";
    
    QuestionDto questiondto = new QuestionDto();    
    questiondto = new ObjectMapper().readValue(jsonString, QuestionDto.class);
    
    String actualJsonString = "";    
    actualJsonString = new ObjectMapper().writeValueAsString(questiondto);
    
    assertEquals("001", questiondto.getQuestionId());
  }
}