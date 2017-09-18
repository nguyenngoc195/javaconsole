/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole;

import java.util.ArrayList;
import java.util.Scanner;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;

public class StudentController {

    private StudentModel studentModel = new StudentModel();
// 1. list student.

    public void getList() {
        StudentModel studentModel = new StudentModel();
        ArrayList<Student> listStudent = studentModel.getListStudent();
        for (Student student : listStudent) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Roll number: " + student.getRollnumber());
            System.out.println("Class name: " + student.getClassName());
            System.out.println("Status: " + student.getStatus());
            System.out.println("___________________");
        }

    }
// 2. add student

    public void addStudent() {
        add:
        while (true) {
            System.out.println("enter 1 insert information");
            System.out.println("enter 2 exit");
            Scanner zz = new Scanner(System.in);
            String strChoi = zz.nextLine();

            int choice;
            try {

                choice = Integer.parseInt(strChoi);

            } catch (java.lang.NumberFormatException e) {

                System.err.println("Please enter a number." + e.getMessage());
                continue;

            }

            switch (choice) {

                case 1:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please enter student information.");
                    System.out.println("Please enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Please enter email: ");
                    String email = scanner.nextLine();
                    System.out.println("Please enter roll number: ");
                    String rollNumber = scanner.nextLine();
                    System.out.println("Please enter class name: ");
                    String className = scanner.nextLine();
                    System.out.println("Please enter status: ");
                    String status = scanner.nextLine();
                    //  System.out.println("Name: " + name + ", email: " + email + ", Roll number: " + rollNumber + ", Class name: " + className + ", Status:" + status);

                    Student student = new Student();
                    student.setName(name);
                    student.setEmail(email);
                    student.setRollnumber(rollNumber);
                    student.setClassName(className);
                    student.setStatus(status);
                    student.setId((int) System.currentTimeMillis());

                    studentModel.insert(student);
                    break;

                case 2:
                    break add;
            }

        }

    }
// edit student

    public void editStudent() {
        Scanner scanner = new Scanner(System.in);
        int editID;
        while (true) {

            System.out.println("Pleasr enter student ID");

            String streditID = scanner.nextLine();

            try {
                editID = Integer.parseInt(streditID);
                break;
            } catch (java.lang.NumberFormatException e) {

                System.err.println("Please enter a number.");
                continue;
            }
        }
        Student es = studentModel.getById(editID);
        if (es != null) {
            System.out.println("ID          :" + es.getId());
            System.out.println("Name        :" + es.getName());
            System.out.println("Email       :" + es.getEmail());
            System.out.println("Roll number :" + es.getRollnumber());
            System.out.println("Class name  :" + es.getClassName());
            System.out.println("Status      :" + es.getStatus());

            Student studentx = new Student();
            System.out.println("Enter new name:");
            scanner.nextLine();
            String newName = scanner.nextLine();
            System.out.println("Enter new email:");
            String newMail = scanner.nextLine();
            System.out.println("Enter new roll number:");
            String newRollNumber = scanner.nextLine();
            System.out.println("Enter new class name:");
            String newClassName = scanner.nextLine();
            System.out.println("Enter new status:");
            String newStatus = scanner.nextLine();

            studentx.setId(editID);
            studentx.setName(newName);
            studentx.setEmail(newMail);
            studentx.setRollnumber(newRollNumber);
            studentx.setClassName(newClassName);
            studentx.setStatus(newStatus);

            studentModel.update2(studentx);

        } else {
            System.err.println("studen not found");
        }

    }

  /* public void deleteStudent() {
        while (true) {
            System.out.println("Please enter student ID");
            System.out.println("Enter 0 exit.");
            Scanner scanner = new Scanner(System.in);
            int dltID = scanner.nextInt();
            if (dltID == 0) {
                break;
            }
            Student ds = studentModel.getById(dltID);

            if (ds != null) {
                studentModel.delete2(ds);

            } else {
                System.err.println("studen not found");
            }
        }
    }
*/
    public void dltStudent() {
        int ID = 0;
        int choice = 0;
        dlt:
        while (true) {
            System.out.println("enter ID number");

            Scanner scanne = new Scanner(System.in);
            String str = scanne.nextLine();

            try {
                ID = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                continue;
            }

            Student ds = studentModel.getById(ID);
            if (ds == null) {
                System.out.println("not student");

            } else {
                System.out.println("________________");
                System.out.println("ID: " + ds.getId());
                System.out.println("Name: " + ds.getName());
                System.out.println("Email: " + ds.getEmail());
                System.out.println("Roll number: " + ds.getRollnumber());
                System.out.println("Class name: " + ds.getClassName());
                System.out.println("Status: " + ds.getStatus());
                System.out.println("________________");
                System.out.println("1. Delete student");
                System.out.println("2. Enter ID again");
                System.out.println("3. Exit");
            //  Scanner scanne2 = new Scanner(System.in);
                String str1 = scanne.nextLine();

                try {
                    choice = Integer.parseInt(str1);
                } catch (NumberFormatException e) {
                    System.err.println(e.getMessage());
                }

                switch (choice) {
                    case 1:

                        studentModel.delete2(ds);
                    case 2:

                        break;
                    case 3:
                        break dlt;

                }

            }

        }

    }

}
