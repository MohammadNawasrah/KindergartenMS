package com.nawasrah.schoolMS.test;

import com.nawasrah.schoolMS.teacherAdmin.TeacherAdminModel;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// "teacherId INTEGER PRIMARY KEY AUTOINCREMENT ," +
//         "name TEXT NOT NULL," +
//         "password TEXT NOT NULL," +
//         "userName  TEXT  Not NUll," +
//         "isLogin TEXT NOT NULL";
@Service
public class ClassInfoExample {
    public static String generateSqlCommand(List<String> column, List<String> sqlData) {
        StringBuilder sqlBuilder = new StringBuilder();
        for (int i = 0; i < column.size(); i++) {
            if (column.size() - 1 > i)
                sqlBuilder.append(column.get(i) + " " + sqlData.get(i) + ",");
            else
                sqlBuilder.append(column.get(i) + " " + sqlData.get(i));
        }
        String sql = sqlBuilder.toString();

        return sql;
    }

    public static String getDataFromModel(Object object) {
        StringBuilder sqlBuilder = new StringBuilder();
        List<String> fields = nameFields(object);
        Class<?> clazz = object.getClass();
//        printEveryThing(fields);
//        "get"+list.get(i).substring(0, 1).toUpperCase() + list.get(i).substring(1)
        sqlBuilder.append("null,");
        for (int i = 1; i < fields.size(); i++) {
            try {
                Method myMethod = clazz.getDeclaredMethod("get" + fields.get(i).substring(0, 1).toUpperCase() + fields.get(i).substring(1));
                myMethod.setAccessible(true);
                Object data = myMethod.invoke(object);
                if (data.getClass().toString().equals("class java.lang.String"))
                    sqlBuilder.append("\""+data+"\",");
                else
                    sqlBuilder.append(data+",");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String sql = sqlBuilder.toString();
        sql=sql.substring(0, sql.length() - 1);

        return sql;
    }

    public static List<String> nameFields(Object object) {
        Class<?> clazz = object.getClass();
        List<String> fieldsName = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            fieldsName.add(field.getName());
        }
        return fieldsName;
    }

    public static List<String> nameMethods(Object object) {
        Class<?> clazz = object.getClass();
        List<String> methodsName = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            methodsName.add(method.getName());
        }
        return methodsName;
    }

    public static void printEveryThing(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("get" + list.get(i).substring(0, 1).toUpperCase() + list.get(i).substring(1));
        }
    }

    public static void main(String[] args) {

        TeacherAdminModel myObject = new TeacherAdminModel();
        myObject.setName("mohammad");
        myObject.setClassNumber(10);
        myObject.setPassword("hell");
        myObject.setUserName("anaa");
        System.out.println(
        getDataFromModel(myObject));
//        List<String> methods = nameFields(myObject);
//        printEveryThing(Collections.singletonList(methods));
//        List<String> sqlData = Arrays.asList(
//                "INTEGER PRIMARY KEY AUTOINCREMENT", "TEXT NOT NULL", "TEXT NOT NULL", "TEXT NOT NULL"
//        );
//        List<String> nameOfFields = ClassInfoExample.nameFields(new TeacherModel());
//        String sql = ClassInfoExample.generateSqlCommand(nameOfFields, sqlData);
//        System.out.println(sql);
//        Object[] arr = {"mohammad", "1233523", 10, "emad"};
//        Collections.sort(methodsName);
//        Collections.sort(fieldsName);
//        int count = 0;
//        for (int i = 0; i < methodsName.size(); i++) {
//
//            try {
//                if (methodsName.get(i).contains("set")) {
//
//                    System.out.print(methodsName.get(i) + " ");
//                    System.out.println(arr[count]);
//
//                    Method myMethod = null;
//
//                    if (arr[count].getClass().toString().equals("class java.lang.Integer"))
//                        myMethod = clazz.getDeclaredMethod(methodsName.get(i), int.class);
//                    if (arr[count].getClass().toString().equals("class java.lang.String"))
//                        myMethod = clazz.getDeclaredMethod(methodsName.get(i), String.class);
//                    myMethod.setAccessible(true);
//                    myMethod.invoke(myObject, arr[count]);
//                    count++;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("get");
//
//        Collections.sort(methodsName);
//        Collections.sort(fieldsName);
//        for (int i = 0; i < methodsName.size(); i++) {
//            try {
//                if (methodsName.get(i).contains("get")) {
//                    Method myMethod = clazz.getDeclaredMethod(methodsName.get(i));
//                    myMethod.setAccessible(true);
//                    System.out.println(myMethod.invoke(myObject));
//                    myMethod.invoke(myObject);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }
}





