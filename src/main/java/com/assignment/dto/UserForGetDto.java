package com.assignment.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserForGetDto {

  Long id;

  @NotNull
  String name;

  @NotNull
  String phone;

}
