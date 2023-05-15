package com.nawasrah.schoolMS.student.repository;

import com.nawasrah.schoolMS.shard.db.sql.SqlHandler;
import com.nawasrah.schoolMS.student.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class StudentRepository implements RepositoryDB<StudentModel> {

    private final static String tableName = "students";
    SqlHandler sqlHandler;
    private String stringConnection = "jdbc:sqlite:src\\main\\java\\com\\nawasrah\\schoolMS\\shard\\db\\data\\myDb.db";

    @Override
    public String addNweStudent(StudentModel studentModel) {
        try {
            String sqlQ = "null,\"%s\",\"%s\",\"%s\",\"%s\",%d";
            String sqlF = String.format(sqlQ,
                    studentModel.getName(),
                    studentModel.getNumberPhone()
                    , studentModel.getDateOfBirth()
                    , studentModel.getIdCode()
                    , studentModel.getTeacherId());
            sqlHandler.insertData(tableName, sqlF);

            return "Congratulation add new student";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Autowired
    StudentRepository() throws SQLException {
        this.sqlHandler = new SqlHandler(stringConnection);
        createStudentTable();
    }

    @Override
    public List<StudentModel> findAll() {
        try {
            ResultSet students = sqlHandler.selectData(tableName);
            List<StudentModel> studentList = new ArrayList<>();
            int count = 0;
            while (students.next()) {
                StudentModel e = new StudentModel();
                count++;
                setStudent(e, students);
                studentList.add(e);
            }
            if (count > 0)
                return studentList;
            else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    StudentModel setStudent(StudentModel studentModel, ResultSet student) {
        try {
            studentModel.setId(student.getLong("id"));
            studentModel.setName(student.getString("name"));
            studentModel.setNumberPhone(student.getString("numberPhone"));
            studentModel.setDateOfBirth(student.getString("dateOfBirth"));
            studentModel.setTeacherId(student.getInt("teacherId"));
            studentModel.setIdCode(student.getString("idCode"));
            return studentModel;
        } catch (Exception exception) {
            System.out.println(exception);
            return null;
        }
    }

    private String createStudentTable() throws SQLException {
        return sqlHandler.createTable("students", "" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "name TEXT NOT NULL," +
                "numberPhone TEXT NOT NULL," +
                "dateOfBirth  TEXT  Not NUll," +
                "idCode TEXT NOT NULL," +
                "teacherId DATE  Not NUll");
    }

    public boolean deleteLastStudent() {
        try {
            sqlHandler.deleteData("students");
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
//
//    Users setUser(Users user, ResultSet users) {
//        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
//        try {
//            CyberPassword cyberPassword = new CyberPassword();
//            user.setUsers_id(users.getLong("users_id"));
//            user.setUsers_name(users.getString("users_name"));
//            user.setUsers_password(cyberPassword.decryption(users.getString("users_password")));
//            user.setUsers_name(users.getString("users_name"));
//            user.setUsers_email(users.getString("users_email"));
//            user.setUser_create(dt1.parse(users.getString("user_create")));
//            user.setUsers_verifycode(users.getInt("users_verifycode"));
//            user.setUsers_approve(users.getBoolean("users_approve"));
//            return user;
//        } catch (Exception exception) {
//            System.out.println(exception);
//            return null;
//        }
//    }
//
//    @Override
//    public List<Users> findAll() {
//        try {
//            String tableName = "users";
//            ResultSet user = sqlHandler.selectData(tableName);
//            List<Users> userList = new ArrayList<>();
//            int count = 0;
//            while (user.next()) {
//                Users e = new Users();
//                count++;
//                setUser(e, user);
//                userList.add(e);
//            }
//            if (count > 0)
//                return userList;
//            else
//                return null;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//
//
//    @Override
//    public Users findByWhere(String column, Object data) {
//        try {
//
//            int count = 0;
//            ResultSet users = sqlHandler.selectDataWhere("users", column, data);
//            Users user = new Users();
//            while (users.next()) {
//                count++;
//                user = setUser(user, users);
//            }
//            if (count > 0)
//                return user;
//            else
//                return null;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public String ifExistsEmail(String email) {
//        List<Users> allUsers = new ArrayList<>();
//        allUsers = findAll();
//        if (allUsers != null)
//            for (Users users : allUsers) {
//                if (users.getUsers_email().equals(email)) {
//                    return "Exist Email";
//                }
//            }
//        return "Not Exist Email";
//    }
//
//    @Override
//    public String insertUser(StudentModel data) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public String insertUser(Users user) throws SQLException {
//        CyberPassword cyberPassword = new CyberPassword();
//        String existsUser = ifExistsEmail(user.getUsers_email());
//        String tableName = "users";
//        if (existsUser.equals("Not Exist Email")) {
//            String sqlQ = "null,\"%s\",\"%s\",\"%s\",0,CURRENT_DATE,false ";
//            String sqlF = String.format(sqlQ, user.getUsers_name()
//                    , cyberPassword.encryption(user.getUsers_password()), user.getUsers_email());
//            sqlHandler.insertData(tableName, sqlF);
//            return "Congratulation Create Email";
//        }
//        return "Email Is Already Exist";
//    }
//
//    public String checkPassword(String email, String password) {
//        CyberPassword cyberPassword = new CyberPassword();
//        List<Users> allUsers = new ArrayList<>();
//        allUsers = findAll();
//        for (Users users : allUsers) {
//            if (users.getUsers_email().equals(email)) {
//                if (password.equals(users.getUsers_password())) {
//                    if (users.isUsers_approve())
//                        return "Correct Password";
//                    else
//                        return "Your Email Not Approve";
//                }
//                    else
//                        return "Not Correct Password";
//
//            }
//        }
//        return "Not Exist Email";
//    }
//    public String checkVerifyCode(String email, Object verifyCode) {
//        List<Users> allUsers = new ArrayList<>();
//        allUsers = findAll();
//        for (Users users : allUsers) {
//            if (users.getUsers_email().equals(email)) {
//                if (verifyCode.equals(users.getUsers_verifycode()))
//                    return "Correct VerifyCode";
//                else
//                    return "Not Correct VerifyCode";
//            }
//        }
//        return "Not Exist Email";
//    }
//
//    @Override
//    public String updateByEmail(String column, Object value, String key, String email) {
//        String existsUser = ifExistsEmail(email);
//        String tableName = "users";
//        if (existsUser.equals("Exist Email")) {
//            sqlHandler.updateData(tableName,column,value,key,email);
//            return "Done Update";
//        }
//        return "Not Exist Email";
//    }
}

// import in.nawasrah.ecommercesystemAPI.core.Cyber.CyberPassword;
// import in.nawasrah.ecommercesystemAPI.database.DbSql;
// import in.nawasrah.ecommercesystemAPI.model.Users;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;

// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.util.ArrayList;
// import java.util.List;

// @Component
// public class UserRepos implements RepositoryDB<Users> {
// private String stringConnection =
// "jdbc:sqlite:C:\\Users\\nawas\\Desktop\\springBoot\\ecommercesystemAPI\\src\\main\\java\\in\\nawasrah\\ecommercesystemAPI\\database\\data\\employee.db";
// @Autowired
// private DbSql dbSql;
// private Connection con;


// public Connection connection() {

// con = dbSql.connection(this.stringConnection);
// String sql = "CREATE TABLE IF NOT EXISTS users (" +
// " users_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
// " users_name TEXT NOT NULL," +
// " users_password TEXT NOT NULL," +
// " users_email TEXT NOT NULL," +
// " users_verifycode INTEGER," +
// " user_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
// " users_approve BOOLEAN DEFAULT 0" +
// ")";
// dbSql.createTable(sql, con);
// return con;
// }


// if (count > 0)
// return user;
// else
// return null;
// }
// return null;
// } catch (Exception e) {
// System.out.println(e.getMessage());
// return null;
// }
// }

// @Override
// public boolean updateById(Users user, long id) {
// try {
// CyberPassword cyberPassword = new CyberPassword();
// String sql = "UPDATE users SET users_name
// ='%s',users_password='%s',users_email='%s' , users_verifycode =%d,
// users_approve =%b WHERE users_id=%d";
// String sqlF = String.format(sql, user.getUsers_name(),
// cyberPassword.encryption(user.getUsers_password()), user.getUsers_email(),
// user.getUsers_verifycode(), user.isUsers_approve()
// , id);
// if (connection() != null) {
// boolean ifUpdate = dbSql.update(sqlF, connection());
// return ifUpdate;
// }
// return false;
// } catch (Exception e) {
// System.out.println(e.getMessage());
// return false;
// }
// }


// public String checkPassword(String email, String password) {
// CyberPassword cyberPassword=new CyberPassword();
// List<Users> allUsers = new ArrayList<>();
// allUsers = findAll();
// for (Users users : allUsers) {
// if (users.getUsers_email().equals(email)) {
// if (password.equals(users.getUsers_password()))
// return "correctPassword";
// else
// return "notCorrectPassword";
// }
// }
// return "not Exist";
// }

// // @Override
// // public boolean remove(long id) {
// // try {
// // String sql = "DELETE FROM employees WHERE id=" + id + "";
// // if (connection() != null) {
// // boolean ifDelete = dbSql.delete(sql, connection());
// // return ifDelete;
// // }
// // return false;
// // } catch (Exception e) {
// // System.out.println(e.getMessage());
// // return false;
// // }
// // }

// @Override
// public boolean insert(Users user) {
// CyberPassword cyberPassword = new CyberPassword();
// try {
// String sql = "INSERT INTO users
// (users_name,users_password,users_email,users_verifycode)VALUES(\"%s\",\"%s\",\"%s\",%d)";
// String sqlF = String.format(sql, user.getUsers_name(),
// cyberPassword.encryption(user.getUsers_password()), user.getUsers_email(),
// user.getUsers_verifycode()
// , user.getUsers_verifycode());
// if (connection() != null) {
// boolean ifInsert = dbSql.insert(sqlF, connection());
// return ifInsert;
// }
// return false;
// } catch (Exception e) {
// System.out.println(e.getMessage());
// return false;
// }
// }
// }
