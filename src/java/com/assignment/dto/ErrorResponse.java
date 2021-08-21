package com.assignment.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {

  int code;

  String error;

}
