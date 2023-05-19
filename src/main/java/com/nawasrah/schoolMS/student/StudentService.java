package com.nawasrah.schoolMS.student;

import com.nawasrah.schoolMS.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String addNewS(StudentModel studentModel) {
        return studentRepository.addNweStudent(studentModel);
    }
    public List<StudentModel> getAllStudent() {

        return studentRepository.findAll();

    }
    public void deleteStudent() {
        studentRepository.deleteLastStudent();
    }

}
