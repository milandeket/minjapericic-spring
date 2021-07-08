package com.example.demo.student;

import com.example.demo.student.dto.StudentCreateRequest;
import com.example.demo.student.dto.StudentCreateResponse;
import com.example.demo.student.dto.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentListResponse>> getStudents() {
        return ResponseEntity.ok(studentService.list());
    }

    @PostMapping
    public ResponseEntity<StudentCreateResponse> registerNewStudent(@Valid @RequestBody StudentCreateRequest student) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.create(student));
    }

}
