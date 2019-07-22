package ua.com.foxminded.task.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import ua.com.foxminded.task.dao.impl.GroupDaoImpl;
import ua.com.foxminded.task.dao.impl.StudentDaoImpl;
import ua.com.foxminded.task.domain.Group;
import ua.com.foxminded.task.domain.Student;
import ua.com.foxminded.task.domain.repository.GroupModelRepository;
import ua.com.foxminded.task.domain.repository.StudentModelRepository;

@RunWith(JUnitPlatform.class)
public class StudentDaoTest {

    private static StudentDao studentDao;
    private static GroupDao groupDao;
    private static final Student STUDENT1 = StudentModelRepository.getModel1();
    private static final Student STUDENT2 = StudentModelRepository.getModel2();
    private static final Student STUDENT3 = StudentModelRepository.getModel3();
    private static final Student STUDENT4 = StudentModelRepository.getModel4();
    private static final Student STUDENT5 = StudentModelRepository.getModel5();
    private static final Student STUDENT6 = StudentModelRepository.getModel6();
    private static final Group GROUP11 = GroupModelRepository.getModel11();
    private static final Group GROUP12 = GroupModelRepository.getModel12();
    private static final Group GROUP13 = GroupModelRepository.getModel13();

    @BeforeAll
    public static void createRecords() {
        DaoFactory.getInstance().createTables();
        studentDao = new StudentDaoImpl();
        groupDao = new GroupDaoImpl();
        groupDao.create(GROUP11);
        groupDao.create(GROUP12);
        groupDao.create(GROUP13);
        studentDao.create(STUDENT1);
        studentDao.create(STUDENT2);
        studentDao.create(STUDENT3);
        studentDao.create(STUDENT4);
        studentDao.create(STUDENT5);
        studentDao.create(STUDENT6);
    }

    @Test
    public void WhenPutAtTableDbStudentObjects_thenGetThisObjectsFindById() {
        int id = STUDENT2.getId();
        assertTrue(studentDao.findById(id).equals(STUDENT2));
    }

    @Test
    public void WhenPutAtTableDbStudentObjects_thenGetThisObjects() {
        assertTrue(studentDao.findAll().containsAll(Arrays.asList(STUDENT1, STUDENT2, STUDENT3, STUDENT4, STUDENT5, STUDENT6)));
    }

    @Test
    public void WhenPutAtTableDbStudentObjects_thenGetThisObjectsFindByTitle() {
        int idFees = STUDENT3.getIdFees();
        assertTrue(studentDao.findByIdFees(idFees).equals(STUDENT3));
    }

    @Test
    public void WhenPutAtTableDbGroupObjects_thenGetThisObjectsFindByTitle() {
        String title = GROUP13.getTitle();
        assertTrue(groupDao.findByTitle(title).equals(GROUP13));
    }

    @Test
    public void WhenPutAtTableDbStudentObject_thenGetGroupFromStudent() {
        Group group = STUDENT5.getGroup();
        int idFees = STUDENT5.getIdFees();
        Student student = studentDao.findByIdFees(idFees);
        assertTrue(student.getGroup().equals(group));
    }

    @AfterAll
    public static void removeCreatedTables() {
        DaoFactory.getInstance().removeTables();
    }
}
