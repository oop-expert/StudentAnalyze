package Analyzer.models.person;

import com.opencsv.bean.CsvBindByPosition;

public class Student extends Person {

    @CsvBindByPosition(position = 1)
    String groupName;

    public String getGroupName() {
        return groupName;
    }

    @CsvBindByPosition(position = 3)
    String excerciseScore;

    @CsvBindByPosition(position = 4)
    String homeworkScore;

    @CsvBindByPosition(position = 2)
    String activityScore;

    public Student(String fullName, String gender, String groupName) {
        super(fullName, gender);
        this.groupName = groupName;
        this.excerciseScore = getExcerciseScore();
        this.homeworkScore = getHomeworkScore().toString();
        this.activityScore = getActivityScore().toString();
    }

    public String getName() {
        return fullName;
    }
    public String getExcerciseScore() {
        return excerciseScore;
    }
    public String getHomeworkScore() {
        return homeworkScore;
    }

    public String getActivityScore() {
        return activityScore;
    }

    public Student() {}

    public String toString() {
        return String.format("%s %s %s %s %s", fullName, groupName, excerciseScore, homeworkScore, activityScore);
    }
}
