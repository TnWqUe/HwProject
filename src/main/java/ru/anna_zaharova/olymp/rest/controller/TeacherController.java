package ru.anna_zaharova.olymp.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.anna_zaharova.olymp.rest.dto.request.teacher.EditTeacherRequest;
import ru.anna_zaharova.olymp.rest.dto.request.teacher.NewTeacherRequest;
import ru.anna_zaharova.olymp.rest.dto.response.teacher.TeacherDto;
import ru.anna_zaharova.olymp.service.TeacherService;


@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Long> addNewTeacher(@RequestBody NewTeacherRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.addNewTeacher(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TeacherDto> edit(@PathVariable Long id, @RequestBody EditTeacherRequest request) {
        return ResponseEntity.ok(teacherService.edit(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        teacherService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.findById(id));
    }
}
