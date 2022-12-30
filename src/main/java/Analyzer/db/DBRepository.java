package Analyzer.db;

import Analyzer.db.models.DBinfoStudent;
import Analyzer.models.person.Person;
import Analyzer.models.person.Student;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.*;

public class DBRepository {
    private final String URL = "jdbc:sqlite:rawdata/base.db";

    private ConnectionSource connectionSource = null;

    private Dao<DBinfoStudent, String> studentDao = null;

    public void connect() throws SQLException {
        connectionSource = new JdbcConnectionSource(URL);

        studentDao = DaoManager.createDao(connectionSource, DBinfoStudent.class);
    }

    public void createTable() throws SQLException {
        TableUtils.createTable(connectionSource, DBinfoStudent.class);
    }
    public void dropTable() throws SQLException {
        TableUtils.dropTable(connectionSource, DBinfoStudent.class, false);
    }

    public void saveStudents(HashMap<Student, Person> students, List<Student> studentsList) throws SQLException {
        Random random = new Random();
        for (var student: students.values()) {
            for (var name : studentsList) {
                if (Objects.equals(student.getFullName(), name.getFullName())){
                    studentDao.create(new DBinfoStudent(student.getFullName(), student.getGender(), name.getGroupName()));
                }
            }
        }
    }

    public List<DBinfoStudent> getStudents() throws SQLException {
        return studentDao.queryForAll();
    }
    public DBinfoStudent getStudentsByName(String name) throws SQLException {
        return studentDao.queryBuilder()
                .where()
                .eq(DBinfoStudent.NAME_COLUMN, name)
                .query().get(0);
    }

    public void creatTableIfNotExist() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, DBinfoStudent.class);
    }
    public void close() throws Exception {
        connectionSource.close();
    }
}