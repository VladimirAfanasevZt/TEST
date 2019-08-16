package ua.com.foxminded.task.service.converter;

import ua.com.foxminded.task.domain.Group;
import ua.com.foxminded.task.domain.Student;
import ua.com.foxminded.task.domain.dto.GroupDto;
import ua.com.foxminded.task.domain.dto.StudentDto;

public final class ConverterToDtoService {

    private ConverterToDtoService() {
    }

    public static StudentDto convert(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setMiddleName(student.getMiddleName());
        studentDto.setBirthday(student.getBirthday());
        studentDto.setIdFees(student.getIdFees());
        studentDto.setGroupTitle(student.getGroup().getTitle());
        return studentDto;
    }

    public static GroupDto convert(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setTitle(group.getTitle());
        groupDto.setYearEntry(group.getYearEntry());
        return groupDto;
    }
}
