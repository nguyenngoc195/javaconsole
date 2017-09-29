/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.filehandle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;

/**
 *
 * @author Lan
 */
public class FileHnadleDemo {

    public void importFile() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            String str;
            fr = new FileReader("test.txt");
            br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                System.out.println(br.readLine());
                System.out.println(br.readLine());
                System.out.println(br.readLine());
                System.out.println(br.readLine());
                System.out.println(br.readLine());
                System.out.println("_________________");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {
            System.out.println(ex);

        } finally {
            try {
                br.close();

            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    public void writeToFile() {
        ArrayList<Student> listStudent = new ArrayList<>();
        StudentModel studentModel = new StudentModel();
        listStudent = studentModel.getListStudent();
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("test.txt");
            bw = new BufferedWriter(fw);
            for (Student studentx : listStudent) {
                bw.write("ID: " + studentx.getId());
                bw.newLine();
                bw.write("Name: " + studentx.getName());
                bw.newLine();
                bw.write("email: " + studentx.getEmail());
                bw.newLine();
                bw.write("phoner: " + studentx.getPhone());
                bw.newLine();
                bw.write("brithday: " + studentx.getBrithday());
           //     bw.newLine();
           //     bw.write("status: " + studentx.getStatus());
                bw.newLine();

            }

        } catch (IOException e) {
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
            }
        }
        System.out.println("success");
    }

}
