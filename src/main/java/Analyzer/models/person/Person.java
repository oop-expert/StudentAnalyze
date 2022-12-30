package Analyzer.models.person;


import com.opencsv.bean.CsvBindByPosition;

public class Person {

    @CsvBindByPosition(position = 0, required = true)
    String fullName;
    String gender;

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public Person(String fullName, String gender) {
        this.fullName = fullName;
        this.gender = gender;
    }

    public Person() {}

    public Person(String name, String gender, String cityOfStudent, String bdate) {
    }

    @Override
    public String toString() {
        return String.format("%s", fullName);
    }
}
