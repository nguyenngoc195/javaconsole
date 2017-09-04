/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole;

import java.util.Scanner;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;


public class StudentController {

    private StudentModel studentModel = new StudentModel();

    public void getList() {
        System.out.println("Get list");
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter student information.");
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter email: ");
        String email = scanner.nextLine();
        System.out.println("Name: " + name + ", email: " + email);

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setId(System.currentTimeMillis());

        studentModel.insert(student);
    }

    public void editStudent() {
        System.out.println("Edit");
    }

    public void deleteStudent() {
        System.out.println("Delete");
    }

}
