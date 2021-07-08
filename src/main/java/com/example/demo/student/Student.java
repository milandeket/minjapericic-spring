package com.example.demo.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "student_sequence"
    )
    private UUID id;
    private String name;
    private LocalDate dob;

    @Transient
    private Integer age;
    private String email;
}
