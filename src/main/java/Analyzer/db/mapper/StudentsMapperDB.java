package Analyzer.db.mapper;

import Analyzer.db.models.DBinfoStudent;
import Analyzer.models.person.Person;

public class StudentsMapperDB {
    public static Person map(DBinfoStudent student) {
        return new Person(student.getName(), student.getGender());
    }
}
