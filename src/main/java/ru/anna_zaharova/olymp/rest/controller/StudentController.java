package ru.anna_zaharova.olymp.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anna_zaharova.olymp.rest.dto.request.student.EditStudentRequest;
import ru.anna_zaharova.olymp.rest.dto.request.student.NewStudentRequest;
import ru.anna_zaharova.olymp.rest.dto.response.student.StudentDto;
import ru.anna_zaharova.olymp.service.StudentService;


@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Long> addNewStudent(@RequestBody NewStudentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addNewStudent(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> edit(@PathVariable Long id, @RequestBody EditStudentRequest request) {
        return ResponseEntity.ok(studentService.edit(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }
}
