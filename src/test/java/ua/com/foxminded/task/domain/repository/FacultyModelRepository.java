package ua.com.foxminded.task.domain.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.com.foxminded.task.domain.Faculty;

public class FacultyModelRepository {

    public static List<Faculty> getModels() {
        List<Faculty> faculties = Arrays.asList(getModel1(), getModel2(), getModel3(), getModel4(), getModel5(), getModel6());
        return new ArrayList<>(faculties);
    }

    public static Faculty getEmptyModel1() {
        Faculty faculty = new Faculty();
        faculty.setId(1);
        faculty.setTitle("faculty1");
        return faculty;
    }

    public static Faculty getModel1() {
        Faculty faculty = new Faculty();
        faculty.setId(1);
        faculty.setTitle("faculty1");
        faculty.setDepartments(DepartmentModelRepository.getModels());
        return faculty;
    }

    private static Faculty getModel2() {
        Faculty faculty = new Faculty();
        faculty.setId(2);
        faculty.setTitle("faculty2");
        faculty.setDepartments(DepartmentModelRepository.getModels());
        return faculty;
    }

    private static Faculty getModel3() {
        Faculty faculty = new Faculty();
        faculty.setId(3);
        faculty.setTitle("faculty3");
        faculty.setDepartments(DepartmentModelRepository.getModels());
        return faculty;
    }

    private static Faculty getModel4() {
        Faculty faculty = new Faculty();
        faculty.setId(4);
        faculty.setTitle("faculty4");
        faculty.setDepartments(DepartmentModelRepository.getModels());
        return faculty;
    }

    private static Faculty getModel5() {
        Faculty faculty = new Faculty();
        faculty.setId(5);
        faculty.setTitle("faculty5");
        faculty.setDepartments(DepartmentModelRepository.getModels());
        return faculty;
    }

    private static Faculty getModel6() {
        Faculty faculty = new Faculty();
        faculty.setId(6);
        faculty.setTitle("faculty6");
        faculty.setDepartments(DepartmentModelRepository.getModels());
        return faculty;
    }

}
