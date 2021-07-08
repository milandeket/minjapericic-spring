package com.example.demo.student;

import com.example.demo.student.dto.StudentCreateRequest;
import com.example.demo.student.dto.StudentCreateResponse;
import com.example.demo.student.dto.StudentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentListResponse> list() {
        return studentRepository.findAll()
                .stream()
                .map(studentRep -> StudentListResponse.builder()
                        .age(studentRep.getAge())
                        .dob(studentRep.getDob())
                        .name(studentRep.getName())
                        .email(studentRep.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    public StudentCreateResponse create(StudentCreateRequest studentRequest) {
        System.out.println(studentRequest);
        Optional<Student> studentOptional = findByEmail(studentRequest.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        Student student = mapStudentCreateRequestToEntity(studentRequest);
        student = studentRepository.save(student);

        return mapEntityToStudentCreateResponse(student);
    }

    private StudentCreateResponse mapEntityToStudentCreateResponse(Student student) {
        return StudentCreateResponse.builder()
                .age(student.getAge())
                .dob(student.getDob())
                .name(student.getName())
                .email(student.getEmail())
                .build();
    }

    private Student mapStudentCreateRequestToEntity(StudentCreateRequest studentRequest) {
        return Student.builder()
                .email(studentRequest.getEmail())
                .name(studentRequest.getName())
                .build();
    }

    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
