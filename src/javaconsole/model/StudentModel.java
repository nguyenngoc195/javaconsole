/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javaconsole.entity.Student;

public class StudentModel {

    //   insert
    public void insert(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            Statement stt = cnn.createStatement();

            StringBuilder sqlQueryBuilder = new StringBuilder();
            sqlQueryBuilder.append("INSERT INTO");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append(" student");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("(name, email, phone, brithday");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("VALUES");
            sqlQueryBuilder.append(" ");
            sqlQueryBuilder.append("(");
            sqlQueryBuilder.append("'" + student.getName() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getEmail() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getPhone() + "'");
            sqlQueryBuilder.append(",");
            sqlQueryBuilder.append("'" + student.getBrithday() + "'");
         //   sqlQueryBuilder.append(",");
         //   sqlQueryBuilder.append("'" + student.getStatus() + "'");
            sqlQueryBuilder.append(");");

           
        //    System.out.println(sqlQueryBuilder.toString());
       

            stt.execute(sqlQueryBuilder.toString());
            System.out.println("Add student!");

        } catch (SQLException e) {
            System.err.println("err...." + e.getMessage());
        }
    }

    //truy ván dữ liệu
    public ArrayList<Student> getListStudent() {
        ArrayList<Student> listStudents = new ArrayList<>();

        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rc = stt.executeQuery("SELECT * FROM student;");
            
            while (rc.next()) {
                Student student = new Student();
                student.setId(rc.getInt("id"));
                student.setName(rc.getString("name"));
                student.setEmail(rc.getString("email"));
                student.setPhone(rc.getString("phone"));
                student.setBrithday(rc.getString("brithday"));
            //    student.setStatus(rc.getString("status"));
                
                listStudents.add(student);

            }

        } catch (SQLException exc) {
            System.err.println("Get list erorr" + exc.getMessage());
        }
        return listStudents;
    }

    public void update1(String name, String email, String phone, String brithday, int id) throws SQLException {

        try {
            String sqlQuery = "update student set name=?, email=?, phoner=?, brithday=? where id=?";
            PreparedStatement stm = DAO.getConnection().prepareStatement(sqlQuery);
            stm.setString(1, name);
            stm.setString(2, email);
            stm.setString(3, phone);
            stm.setString(4, brithday);
           // stm.setInt(5, status);
            stm.setLong(6, id);

            int rowUpdate = stm.executeUpdate();
            if (rowUpdate > 0) {
                System.out.println("update okey");
            }
        } catch (SQLException e) {
            System.out.println("lỗi update" + e.getMessage());
        }

    }

    public void update2(Student student) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("UPDATE student SET name=?, email=? ,phone=?, brithday=? where id=?");
            preStt.setString(1, student.getName());
            preStt.setString(2, student.getEmail());
            preStt.setString(3, student.getPhone());
            preStt.setString(4, student.getBrithday());
        //    preStt.setString(5, student.getStatus());
            preStt.setInt(6, student.getId());
            
            preStt.execute();
            
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public Student getById(int id) {
        Student student = new Student();
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("SELECT * FROM student WHERE id=?;");
            preStt.setInt(1, id);
            ResultSet rc = preStt.executeQuery();
            if (rc.next()) {
                
                student.setId(rc.getInt("id"));
                student.setName(rc.getString("name"));
                student.setEmail(rc.getString("email"));
                student.setPhone(rc.getString("phone"));
                student.setBrithday(rc.getString("brithday"));
             //   student.setStatus(rc.getString("status"));
               return student;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void delete2(Student student) {
        try {
            String sqlQuery = "delete from student where id=?";
            PreparedStatement stm = DAO.getConnection().prepareStatement(sqlQuery);
            stm.setInt(1, student.getId());
            int rowsDeleted = stm.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Email: " + student.getEmail());
                System.out.println("Roll number: " + student.getPhone());
                System.out.println("Class name: " +student.getBrithday());
             //   System.out.println("Status: " + student.getStatus());
                System.out.println("Successfully deleted students!");
            }
        } catch (SQLException e) {
            System.err.println("error during deletion" + e.getMessage());
        }

    }

    public ArrayList<Object> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Student student = new Student();
    }

    
}
