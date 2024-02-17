package ru.job4j.mapstuct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.mapstuct.dto.StudentDto;
import ru.job4j.mapstuct.model.StudentEntity;

@Mapper
public interface  StudentMapper {
    @Mapping(target = "className", source = "classVal")
    StudentDto getModelFromEntity(StudentEntity student);

    @Mapping(target = "classVal", source = "className")
    StudentEntity detEntityFromDto(StudentDto studentDto);

    default StudentDto getModelFromEntityCustom(StudentEntity studentEntity) {
        StudentDto student = new StudentDto();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setClassName(studentEntity.getClassVal());
        return student;
    }
}