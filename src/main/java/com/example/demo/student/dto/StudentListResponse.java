package com.example.demo.student.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StudentListResponse {
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
}
