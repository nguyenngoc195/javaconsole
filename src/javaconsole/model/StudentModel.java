/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.util.ArrayList;
import javaconsole.entity.Student;

public class StudentModel {

    private static ArrayList<Student> listStudent;

    public void getList() {

    }

    public void insert(Student student) {
        if (listStudent == null) {
            listStudent = new ArrayList<>();
        }
        listStudent.add(student);

    }

    public void update() {

    }

    public void delete() {

    }

}
