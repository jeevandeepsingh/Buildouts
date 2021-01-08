
package com.crio.buildouts.integ.test.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssessmentConfig {
  private String name;
  private String url;
  private String method;
  private String input;
  private int status;
  private String verification;
  private String response;
}
