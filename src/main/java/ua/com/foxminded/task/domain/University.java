package ua.com.foxminded.task.domain;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String title;
    private List<Faculty> faculties = new ArrayList<>();
    private List<Auditory> auditories = new ArrayList<>();
    private Timetable timetable;

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    public void addAuditory(Auditory auditory) {
        auditories.add(auditory);
    }

    public void removeAuditory(Auditory auditory) {
        auditories.remove(auditory);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Auditory> getAuditories() {
        return auditories;
    }

    public void setAuditories(List<Auditory> auditories) {
        this.auditories = auditories;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((auditories == null) ? 0 : auditories.hashCode());
        result = prime * result + ((faculties == null) ? 0 : faculties.hashCode());
        result = prime * result + ((timetable == null) ? 0 : timetable.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        University other = (University) obj;
        if (auditories == null) {
            if (other.auditories != null)
                return false;
        } else if (!auditories.equals(other.auditories))
            return false;
        if (faculties == null) {
            if (other.faculties != null)
                return false;
        } else if (!faculties.equals(other.faculties))
            return false;
        if (timetable == null) {
            if (other.timetable != null)
                return false;
        } else if (!timetable.equals(other.timetable))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "University [title=" + title 
             + ", faculties=" + faculties 
             + ", auditories=" + auditories 
             + ", timetable=" + timetable 
             + "]";
    }

    

}
