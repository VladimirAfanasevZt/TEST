package ua.com.foxminded.task.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;

import ua.com.foxminded.task.domain.Student;

@DBRider
@SpringBootTest
public class StudentRepositoryIntegrationTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DataSource dataSource;

    @Rule
    public DBUnitRule dbUnitRule = DBUnitRule.instance(() -> dataSource.getConnection());

    @Test
    @DataSet(cleanBefore = true, skipCleaningFor = "flyway_schema_history")
    public void whenRepositoryHasNotRecords_thenReturnEmptyList() {
        List<Student> students = studentRepository.findAll();
        assertThat(students).isNotNull().isEmpty();
    }

    @Test
    @DataSet(value = "student/students.yml", 
             cleanBefore = true, 
             skipCleaningFor = "flyway_schema_history")
    @ExpectedDataSet(value = "student/expectedStudents.yml")
    public void whenRepositoryHasRecords_thenReturnNonEmptyList() {
        List<Student> students = studentRepository.findAll();
        assertThat(students).isNotNull().isNotEmpty().hasSize(3);
    }

    @Test
    @DataSet(value = "student/students.yml", 
             cleanBefore = true, 
             skipCleaningFor = "flyway_schema_history")
    public void whenPutAtTableDbStudentObjects_thenGetThisObjectsFindById() {
        Student expectedStudent = new Student();
        expectedStudent.setFirstName("firstname3");
        expectedStudent.setLastName("lastname3");
        expectedStudent.setMiddleName("middlename3");
        expectedStudent.setBirthday(LocalDate.of(1993, 02, 01));
        expectedStudent.setIdFees(111111113);
        Student student = studentRepository.findById(3).get();
        assertThat(student).isEqualTo(expectedStudent);
    }

    @Test
    @DataSet(value = "student/students.yml", 
             cleanBefore = true, 
             skipCleaningFor = "flyway_schema_history")
    public void whenFindByIdFees_thenGetExitsStudent() {
        int idFees = 111111113;
        Student studentActually = studentRepository.findByIdFees(idFees);
        assertThat(studentActually.getIdFees()).isEqualTo(idFees);
    }

    @Test
    @DataSet(cleanBefore = true, skipCleaningFor = "flyway_schema_history")
    @ExpectedDataSet(value = "student/expectedStudent.yml")
    public void whenSaveObject_thenExpectRecord() {
        Student student = new Student();
        student.setFirstName("firstname3");
        student.setLastName("lastname3");
        student.setMiddleName("middlename3");
        student.setBirthday(LocalDate.of(1993, 02, 01));
        student.setIdFees(111111113);
        Student studentActually = studentRepository.saveAndFlush(student);
        assertThat(studentActually).isNotNull();
    }

    @Test
    @DataSet(value = "student/student.yml", 
             cleanBefore = true, 
             skipCleaningFor = "flyway_schema_history")
    @ExpectedDataSet(value = "student/expectedStudent.yml")
    public void whenUpdateObject_thenExpectUpdatedRecord() {
        Student student = new Student();
        student.setId(1);
        student.setFirstName("firstname3");
        student.setLastName("lastname3");
        student.setMiddleName("middlename3");
        student.setBirthday(LocalDate.of(1993, 02, 01));
        student.setIdFees(111111113);
        Student studentActually = studentRepository.saveAndFlush(student);
        assertThat(studentActually).isNotNull();
    }

    @Test
    @DataSet(value = "student/studentsWithGroups.yml", 
             cleanBefore = true, 
             skipCleaningFor = "flyway_schema_history")
    public void whenFindByGroupId_thenReturnTwoRecords() {
        List<Student> students = studentRepository.findAllByGroupId(2);
        assertThat(students).isNotNull().isNotEmpty().hasSize(3);
    }

    @Test
    @DataSet(value = "student/studentsWithGroups.yml", 
             cleanBefore = true, 
             skipCleaningFor = "flyway_schema_history")
    public void whenCountByGroupId_thenReturnTwoRecords() {
        long count = studentRepository.countByGroupId(2);
        assertThat(count).isEqualTo(3L);
    }

    @Test
    @DataSet(value = "student/studentsWithGroups.yml", 
             cleanBefore = true, 
             skipCleaningFor = "flyway_schema_history")
    public void whenCheckExistStudentByIdAndGroupId_thenReturnTrue() {
        boolean isExists = studentRepository.existsStudentByIdAndGroupId(3, 2);
        assertTrue(isExists);
    }

}
