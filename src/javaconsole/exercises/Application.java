/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.exercises;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javeconsole.swing.FormHandle;

/**
 *
 * @author Lan
 */
public class Application extends JPanel {

    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblBrithday;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtBrithday;

    private JButton search;
    private JButton add;
    private JButton edit;
    private JButton delete;

    private JLabel lblIdMessage;
    private JLabel lblNameMessage;
    private JLabel lblEmailMessage;
    private JLabel lblPhoneMessage;
    private JLabel lblBrithdayMessage;

    public Application() {

        setBounds(20, 500, 960, 300);

        lblId = new JLabel("Id");
        lblName = new JLabel("Name");
        lblEmail = new JLabel("Email");
        lblPhone = new JLabel("Phone");
        lblBrithday = new JLabel("Birthday");

        txtId = new JTextField();
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtPhone = new JTextField();
        txtBrithday = new JTextField();

        search = new JButton("Search");
        add = new JButton("Add");
        edit = new JButton("Edit");
        delete = new JButton("Delete");

        lblIdMessage = new JLabel();
        lblNameMessage = new JLabel();
        lblEmailMessage = new JLabel();
        lblPhoneMessage = new JLabel();
        lblBrithdayMessage = new JLabel();

        lblId.setBounds(60, 20, 50, 30);
        lblName.setBounds(200, 20, 100, 30);
        lblEmail.setBounds(340, 20, 100, 30);
        lblPhone.setBounds(480, 20, 100, 30);
        lblBrithday.setBounds(620, 20, 100, 30);

        txtId.setBounds(40, 80, 50, 30);
        txtName.setBounds(155, 80, 140, 30);
        txtEmail.setBounds(295, 80, 140, 30);
        txtPhone.setBounds(435, 80, 140, 30);
        txtBrithday.setBounds(575, 80, 140, 30);

        search.setBounds(30, 150, 80, 30);
        add.setBounds(320, 150, 80, 30);
        edit.setBounds(460, 150, 80, 30);
        delete.setBounds(600, 150, 80, 30);

        lblIdMessage.setBounds(70, 120, 100, 30);
        lblNameMessage.setBounds(210, 120, 100, 30);
        lblEmailMessage.setBounds(350, 120, 100, 30);
        lblPhoneMessage.setBounds(490, 120, 100, 30);
        lblBrithdayMessage.setBounds(630, 120, 100, 30);

        search.addActionListener(new Search());
        add.addActionListener(new Add());
        edit.addActionListener(new Edit());
        delete.addActionListener(new Delete());

        this.setLayout(null);
        add(lblId);
        add(lblName);
        add(lblEmail);
        add(lblPhone);
        add(lblBrithday);

        add(txtId);
        add(txtName);
        add(txtEmail);
        add(txtPhone);
        add(txtBrithday);

        add(search);
        add(add);
        add(edit);
        add(delete);

        add(lblIdMessage);
        add(lblNameMessage);
        add(lblEmailMessage);
        add(lblPhoneMessage);
        add(lblBrithdayMessage);

        setVisible(true);

    }

    private StudentModel stuModel = new StudentModel();

    private Student getStudent() {

        int Id = Integer.parseInt(txtId.getText());
        Student es = stuModel.getById(Id);
        return es;
    }

    private void Reset() {
        lblId.setText("");
        lblNameMessage.setText("");
        lblEmailMessage.setText("");
        lblPhoneMessage.setText("");
        lblBrithdayMessage.setText("");

    }

    class Search implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            
       
//          //  Student s = new Student();
//      String id = String.valueOf(txtId.getText());
//            if (id != null) {
//                 Student es = getStudent();
//                if (es != null) {
//                    txtName.setText(es.getName());
//                    txtEmail.setText(es.getEmail());
//                    txtPhone.setText(es.getPhone());
//                    txtBrithday.setText(es.getBirthday());
//
//                }else{
//                lblIdMessage.setText("not found");
//                }
//                
//            }else{
//            lblIdMessage.setText("Enter Id");
//            }
            Reset();
            int Id;
         
            Student es = getStudent();
            if (es != null) {
                txtName.setText(es.getName());
                txtEmail.setText(es.getEmail());
                txtPhone.setText(es.getPhone());
                txtBrithday.setText(es.getBirthday());

            }

        }
    }

    class Edit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Reset();
            Student es = getStudent();
            es.setName(txtName.getText());
            es.setEmail(txtEmail.getText());
            es.setPhone(txtPhone.getText());
            es.setBirthday(txtBrithday.getText());
            stuModel.update2(es);
            JOptionPane.showMessageDialog(null, "Edit student");

        }

    }

    class Delete implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Reset();
            Student es = getStudent();
            int choice;
            choice = JOptionPane.showConfirmDialog(null, "Delete student");
            if (choice == 0) {
                stuModel.delete2(es);
                Reset();
            }

        }

    }

    class Add implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Reset();
            Student student = new Student();
            try {
                student.setId(Integer.parseInt(txtId.getText()));
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
            String name = txtName.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();
            String day = txtBrithday.getText();

            student.setName(name);
            student.setEmail(email);
            student.setPhone(phone);
            student.setBirthday(day);

            HashMap<String, String> errors = new FormHandle().validateAdd(student);
            int result = 99999;
            if (errors.size() == 0) {
                resetMessage();
                result = JOptionPane.showConfirmDialog(null, "Add student ???"
                        + "\nNAME : " + txtName.getText()
                        + "\nEMAIL : " + txtEmail.getText()
                        + "\nPHONE : " + txtPhone.getText()
                        + "\nBRITHDAY : " + txtBrithday.getText());

                if (result == 0) {
                    StudentModel studentModel = new StudentModel();
                    studentModel.insert(student);
                    JOptionPane.showMessageDialog(null, "Add new studen");

                }
            } else {
                showError(errors);
            }
            System.out.println(result);
        }
    }

    private void showError(HashMap<String, String> errors) {

        if (errors.containsKey("txtName")) {
            lblNameMessage.setForeground(Color.red);
            lblNameMessage.setText(errors.get("txtName"));
        } else {
            lblNameMessage.setForeground(Color.green);
            lblNameMessage.setText("Hợp lệ.");
        }
        if (errors.containsKey("txtEmail")) {
            lblEmailMessage.setForeground(Color.red);
            lblEmailMessage.setText(errors.get("txtEmail"));
        } else {
            lblEmailMessage.setForeground(Color.green);
            lblEmailMessage.setText("Hợp lệ.");
        }
        if (errors.containsKey("txtPhone")) {
            lblPhoneMessage.setForeground(Color.red);
            lblPhoneMessage.setText(errors.get("txtPhone"));
        } else {
            lblPhoneMessage.setForeground(Color.green);
            lblPhoneMessage.setText("Hợp lệ.");
        }
        if (errors.containsKey("txtBrithday")) {
            lblBrithdayMessage.setForeground(Color.red);
            lblBrithdayMessage.setText(errors.get("txtBrithday"));
        } else {
            lblBrithdayMessage.setForeground(Color.green);
            lblBrithdayMessage.setText("Hợp lệ.");
        }

    }

    private Void resetMessage() {
        // lblIdMessage.setText("");
        lblNameMessage.setText("");
        lblEmailMessage.setText("");
        lblPhoneMessage.setText("");
        lblBrithdayMessage.setText("");
        return null;

    }
}
