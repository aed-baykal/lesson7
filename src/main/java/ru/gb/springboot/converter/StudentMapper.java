package ru.gb.springboot.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gb.springboot.dto.StudentDto;
import ru.gb.springboot.model.Student;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    @Mapping(source = "id", target = "id")
    public abstract StudentDto studentToStudentDto(Student student);

    @Mapping(source = "id", target = "id")
    public abstract Student studentDtoToStudent(StudentDto studentDto);

}
