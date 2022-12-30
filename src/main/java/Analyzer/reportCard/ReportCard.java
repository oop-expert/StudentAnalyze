package Analyzer.reportCard;

import Analyzer.models.person.Student;

import java.util.ArrayList;
import java.util.List;

public class ReportCard {
    private final ArrayList<Student> students;

    public ReportCard(ArrayList<Student> students) {
        this.students = students;
    }

//    public String getScoreForStudent(String name) {
//        return students.stream()
//                .filter(student -> student.getName().equals(name))
//                .findFirst()
//                .orElseThrow()
//                .getExcerciseScore();
//    }

    public List<Student> getStudentsList() {
        return students;
    }
}
