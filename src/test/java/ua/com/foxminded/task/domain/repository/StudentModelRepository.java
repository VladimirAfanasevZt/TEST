package ua.com.foxminded.task.domain.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.task.domain.Student;

public class StudentModelRepository {

    private static Student student;
    private static List<Student> students;

    public static Student getModel(TestModel testModel) {
        switch (testModel) {
        case MODEL_1:
            createModel1();
            break;
        case MODEL_2:
            createModel2();
            break;
        case MODEL_3:
            createModel3();
            break;
        case MODEL_4:
            createModel4();
            break;
        case MODEL_5:
            createModel5();
            break;
        case MODEL_6:
            createModel6();
            break;
        }
        return student;
    }

    public static List<Student> getList(TestModel testModel) {
        students = new ArrayList<>();
        switch (testModel) {
        case MODEL_1:
            createModel1();
            students.add(student);
            createModel2();
            students.add(student);
            break;
        case MODEL_2:
            createModel2();
            students.add(student);
            createModel3();
            students.add(student);
            break;
        case MODEL_3:
            createModel1();
            students.add(student);
            createModel6();
            students.add(student);
            break;
        case MODEL_4:
            createModel4();
            students.add(student);
            createModel5();
            students.add(student);
            break;
        case MODEL_5:
            createModel3();
            students.add(student);
            createModel6();
            students.add(student);
            break;
        case MODEL_6:
            createModel3();
            students.add(student);
            createModel5();
            students.add(student);
            break;
        }
        return students;
    }

    private static void createModel1() {
        student = new Student();
        student.setId(1);
        student.setFirstName("firstName1");
        student.setMiddleName("middleName1");
        student.setLastName("lastName1");
        student.setBirthday(Date.valueOf("2018-06-25"));
        student.setIdFees(1111111111);
        student.setGroup(null);
        // TODO set group

    }

    private static void createModel2() {
        student = new Student();
        student.setId(2);

    }

    private static void createModel3() {
        student = new Student();
        student.setId(3);

    }

    private static void createModel4() {
        student = new Student();
        student.setId(4);

    }

    private static void createModel5() {
        student = new Student();
        student.setId(5);

    }

    private static void createModel6() {
        student = new Student();
        student.setId(6);

    }

}
