/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaconsole.entity.Student;

public class StudentModel {

    private static ArrayList<Student> listStudent;

    public void getList() {

    }
// insert thông tin sinh viên vào db

    public void searchStudent() {

    }

    public static void insert(Student student) {
        if (listStudent == null) {
            listStudent = new ArrayList<>();
        }
        listStudent.add(student);
    }

    public void update(Student oldStudent, Student newStudent) {
        listStudent.remove(oldStudent);
        listStudent.add(newStudent);
    }

    public void delete(Student student) {
        listStudent.remove(student);
    }

    //truy ván dữ liệu
    public ArrayList<Student> getListStudent() {
        ArrayList<Student> listStudents = new ArrayList<>();

        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rc = stt.executeQuery("select * from student");
            while (rc.next()) {
                Student student = new Student();
                student.setId(rc.getInt("id"));
                student.setName(rc.getString("name"));
                student.setEmail(rc.getString("email"));

                listStudents.add(student);

            }

        } catch (SQLException exc) {

        }
        return listStudents;
    }

    public static void main(String[] args) {
        StudentModel studentModel = new StudentModel();
        Student student = new Student();

        listStudent = studentModel.getListStudent();

        for (Student x : listStudent) {
            System.out.println(x.getId() + x.getName() + x.getEmail());
        }

    }

}
