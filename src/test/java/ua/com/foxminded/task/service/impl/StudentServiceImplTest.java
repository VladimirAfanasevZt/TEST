package ua.com.foxminded.task.service.impl;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;

import ua.com.foxminded.task.dao.GroupRepository;
import ua.com.foxminded.task.dao.StudentRepository;
import ua.com.foxminded.task.dao.exception.EntityAlreadyExistsException;
import ua.com.foxminded.task.dao.exception.EntityNotValidException;
import ua.com.foxminded.task.domain.Student;
import ua.com.foxminded.task.domain.dto.StudentDto;
import ua.com.foxminded.task.domain.repository.StudentModelRepository;
import ua.com.foxminded.task.domain.repository.dto.StudentDtoModelRepository;

public class StudentServiceImplTest {

    @Mock
    private Logger logger;
    @Mock
    private GroupRepository groupRepository;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void whenFindById_thenFindStudentAndConvertItToDto() {
        Student student = StudentModelRepository.getModel1();
        StudentDto studentDtoExpected = StudentDtoModelRepository.getModel1();
        doReturn(student).when(studentRepository).getOne(1);

        StudentDto studentDtoActually = studentService.findByIdDto(1);

        verify(studentRepository, times(1)).getOne(any(Integer.class));
        assertEquals(studentDtoExpected, studentDtoActually);
    }

    @Test
    void whenFindByAll_thenFindStudentsAndConvertItToDto() {
        List<Student> students = StudentModelRepository.getModels1();
        List<StudentDto> studentDtosExpected = StudentDtoModelRepository.getModels1();
        doReturn(students).when(studentRepository).findAll();

        List<StudentDto> studentDtosActually = studentService.findAllDto();

        verify(studentRepository, times(1)).findAll();
        assertEquals(studentDtosExpected, studentDtosActually);
    }

    @Test
    void whenCreate_thenInvocCreateDaoClass() {
        Student student = StudentModelRepository.getModel1();
        StudentDto studentDto = StudentDtoModelRepository.getModel1();
        doReturn(student).when(studentRepository).saveAndFlush(student);
        doReturn(student.getGroup()).when(groupRepository).getOne(student.getGroup().getId());

        StudentDto studentDtoActually = studentService.create(studentDto);

        verify(studentRepository, times(1)).saveAndFlush(student);
        verify(groupRepository, times(1)).getOne(student.getGroup().getId());
        assertEquals(studentDto, studentDtoActually);
    }

    @Test
    void whenUpdate_thenInvocUpdateDaoClass() {
        Student student = StudentModelRepository.getModel1();
        StudentDto studentDto = StudentDtoModelRepository.getModel1();
        studentDto.setId(1);
        student.setId(1);
        doReturn(student).when(studentRepository).saveAndFlush(student);
        doReturn(true).when(studentRepository).existsById(studentDto.getId());
        doReturn(student).when(studentRepository).getOne(student.getId());
        doReturn(student.getGroup()).when(groupRepository).getOne(student.getGroup().getId());

        StudentDto studentDtoActually = studentService.update(studentDto);

        verify(studentRepository, times(1)).saveAndFlush(student);
        verify(studentRepository, times(1)).getOne(student.getId());
        verify(groupRepository, times(1)).getOne(student.getGroup().getId());
        assertEquals(studentDto, studentDtoActually);
    }
    
    @Test
    public void whenFindByIdFees_thenInvokeMethod() {
        Integer idFees = 111111111;
        studentService.findByIdFees(idFees);
        
        verify(studentRepository, times(1)).findByIdFees(idFees);
    }
    
    @Test
    public void whenCountByGroupId_thenInvokeMethod() {
        Integer id = 1;
        studentService.countByGroupId(id);
        
        verify(studentRepository, times(1)).countByGroupId(id);
    }
    
    @Test
    public void whenCheckExistsStudentByIdAndGroupId_thenInvokeMethod() {
        Integer studentId = 1;
        Integer groupId = 1;
        studentService.existsStudentByIdAndGroupId(studentId, groupId);
        
        verify(studentRepository, times(1)).existsStudentByIdAndGroupId(studentId, groupId);
    }
    
    @Test
    public void whenCreateRecordEntityWithId_thenThrowException() {
        StudentDto student = new StudentDto();
        student.setId(1);

        assertThatThrownBy(() -> studentService.create(student))
             .isInstanceOf(EntityAlreadyExistsException.class)
             .hasMessage("create() studentDto: %s", student);
    }
    
    @Test
    public void whenCreateRecordWithNotValidEntity_thenThrowException() {
        StudentDto studentDto = StudentDtoModelRepository.getModel1();
        Student student = StudentModelRepository.getModel1();
        doReturn(student.getGroup()).when(groupRepository).getOne(student.getGroup().getId());
        doThrow(DataIntegrityViolationException.class).when(studentRepository).saveAndFlush(student);

        assertThatThrownBy(() -> studentService.create(studentDto))
             .isInstanceOf(EntityNotValidException.class)
             .hasMessageContaining("create() student: " + student);
    }
    
    @Test
    public void whenUpdateRecordWithNotValidEntity_thenThrowException() {
        StudentDto studentDto = StudentDtoModelRepository.getModel1();
        Student student = StudentModelRepository.getModel1();
        doReturn(student.getGroup()).when(groupRepository).getOne(student.getGroup().getId());
        doThrow(DataIntegrityViolationException.class).when(studentRepository).saveAndFlush(student);
        doReturn(true).when(studentRepository).existsById(student.getId());

        assertThatThrownBy(() -> studentService.update(studentDto))
             .isInstanceOf(EntityNotValidException.class)
             .hasMessageContaining("update() student: " + student);
    }
}
