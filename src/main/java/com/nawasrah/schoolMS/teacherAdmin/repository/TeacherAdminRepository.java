package com.nawasrah.schoolMS.teacherAdmin.repository;

import com.nawasrah.schoolMS.core.ConstantData;
import com.nawasrah.schoolMS.shard.db.connection.DbConnectionImp;
import com.nawasrah.schoolMS.shard.db.sql.SqlHandler;
import com.nawasrah.schoolMS.teacher.TeacherModel;
import com.nawasrah.schoolMS.teacherAdmin.TeacherAdminModel;
import com.nawasrah.schoolMS.test.ClassInfoExample;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TeacherAdminRepository {

    private final static String tableName = "teacherAdmin";
    SqlHandler sqlHandler;
    private String stringConnection = "jdbc:sqlite:" + ConstantData.pathDatabase + ConstantData.kg;

    TeacherAdminRepository() throws SQLException {
        DbConnectionImp.closeConnection();
        this.sqlHandler = new SqlHandler(stringConnection);
        createTeacherAdminTable();
    }

    private String createTeacherAdminTable() throws SQLException {
        List<String> sqlData = Arrays.asList(
                "INTEGER PRIMARY KEY AUTOINCREMENT", "TEXT NOT NULL", "TEXT NOT NULL", "TEXT NOT NULL", "INTEGER NOT NULL"
        );
        List<String> nameOfFields = ClassInfoExample.nameFields(new TeacherAdminModel());
        String sql = ClassInfoExample.generateSqlCommand(nameOfFields, sqlData);
        return sqlHandler.createTable(tableName, sql);
    }

    public String addNweTeacherOrAdmin(TeacherAdminModel teacherAdminModel) {
        try {
            sqlHandler.insertData(tableName, ClassInfoExample.getDataFromModel(teacherAdminModel));
            return "Congratulation add new teacher";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    TeacherModel setTeacher(TeacherModel teacherModel, ResultSet teacher) {
        try {
            teacherModel.setTeacherId(teacher.getInt("teacherId"));
            teacherModel.setName(teacher.getString("name"));
            teacherModel.setUserName(teacher.getString("userName"));
            teacherModel.setPassword(teacher.getString("password"));
//            teacherModel.setLogin(teacher.getBoolean("isLogin"));
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


