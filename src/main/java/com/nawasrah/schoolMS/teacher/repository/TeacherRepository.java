package com.nawasrah.schoolMS.teacher.repository;

import com.nawasrah.schoolMS.shard.db.connection.DbConnectionImp;
import com.nawasrah.schoolMS.shard.db.sql.SqlHandler;
import com.nawasrah.schoolMS.student.StudentModel;
import com.nawasrah.schoolMS.teacher.TeacherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherRepository {
    private final static String tableName = "teachers";
    SqlHandler sqlHandler;
    private String stringConnection = "jdbc:sqlite:src\\main\\java\\com\\nawasrah\\schoolMS\\shard\\db\\data\\myDb.db";
    @Autowired
    TeacherRepository() throws SQLException {
        DbConnectionImp.closeConnection();
        this.sqlHandler = new SqlHandler(stringConnection);
    }
    private String createStudentTable() throws SQLException {
        return sqlHandler.createTable(tableName, "" +
                "teacherId INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "name TEXT NOT NULL," +
                "password TEXT NOT NULL," +
                "userName  TEXT  Not NUll," +
                "isLogin TEXT NOT NULL");
    }
    TeacherModel setTeacher(TeacherModel teacherModel, ResultSet teacher) {
        try {
            teacherModel.setTeacherId(teacher.getInt("teacherId"));
            teacherModel.setName(teacher.getString("name"));
            teacherModel.setUserName(teacher.getString("userName"));
            teacherModel.setPassword(teacher.getString("password"));
            teacherModel.setLogin(teacher.getBoolean("isLogin"));
            return teacherModel;
        } catch (Exception exception) {
            System.out.println(exception);
            return null;
        }
    }
    public List<TeacherModel> findAll() {
        try {
            ResultSet teachers = sqlHandler.selectData(tableName);
            List<TeacherModel> teacherList = new ArrayList<>();
            int count = 0;
            while (teachers.next()) {
                TeacherModel e = new TeacherModel();
                count++;
                setTeacher(e, teachers);
                teacherList.add(e);
            }
            if (count > 0)
                return teacherList;
            else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public TeacherModel findByWhere(String column, Object data) {
        try {
            int count = 0;
            ResultSet teacherList = sqlHandler.selectDataWhere(tableName, column, data);
            TeacherModel teacherModel = new TeacherModel();
            while (teacherList.next()) {
                count++;
                teacherModel = setTeacher(teacherModel, teacherList);
            }
            if (count > 0)
                return teacherModel;
            else
                return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
