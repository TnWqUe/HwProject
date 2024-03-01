package ru.anna_zaharova.olymp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anna_zaharova.olymp.entity.Teacher;
import ru.anna_zaharova.olymp.exception.exceptions.NullIdException;
import ru.anna_zaharova.olymp.exception.exceptions.user.UserNotFoundException;
import ru.anna_zaharova.olymp.repo.TeacherRepo;
import ru.anna_zaharova.olymp.repo.UserRepo;
import ru.anna_zaharova.olymp.rest.dto.teacher.NewTeacherRequest;
import ru.anna_zaharova.olymp.service.TeacherService;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo teacherRepo;
    private final UserRepo userRepo;

    @Override
    public NewTeacherRequest add(NewTeacherRequest request) {
        if (request.getUserId()==null){
            throw new NullIdException("The teacher cannot be created with user whose id = null");
        }

        if (!userRepo.existsById(request.getUserId())){
            throw new UserNotFoundException(
                    String.format( "The teacher cannot be created with user who is not in the database. User id = %d",
                            request.getUserId())
            );
        }

        Teacher teacher = Teacher.builder()
                .mpeiUrl(request.getMpeiUrl())
                .user(userRepo.findById(request.getUserId()).get())
                .build();

        teacher.setId(request.getUserId());

        Teacher addedTeacher = teacherRepo.save(teacher);

        return NewTeacherRequest.builder()
                .userId(addedTeacher.getUser().getId())
                .mpeiUrl(addedTeacher.getMpeiUrl())
                .build();
    }
}
