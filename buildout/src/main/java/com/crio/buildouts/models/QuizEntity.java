package com.crio.buildouts.models;

import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Quiz_DB")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizEntity {
  
  @Id
  private String index;
  // @NotNull
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
