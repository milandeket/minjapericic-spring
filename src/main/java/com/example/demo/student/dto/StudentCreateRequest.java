package com.example.demo.student.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudentCreateRequest {

    @NotNull
    @NotEmpty
    private String name;
    @Email
    private String email;
}
