package Analyzer.db.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName = "DBinfoStudent")
public class DBinfoStudent {
    public static final String NAME_COLUMN = "name";


    @DatabaseField(generatedId = true)
    private long studentId;

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    @DatabaseField(canBeNull = false)
    private String name;

    private String groupName;

    @DatabaseField()
    private String gender;

    public DBinfoStudent() { }

    public DBinfoStudent(String name , String gender, String groupName) {
        this.name = name;
        this.gender = gender;
        this.groupName = groupName;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "DBinfoStudent{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}