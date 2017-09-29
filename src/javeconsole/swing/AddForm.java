/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javeconsole.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.HashMap;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * /**
 *
 * @author Lan
 */
public class AddForm extends JFrame {

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

    private JButton btnSubmit;
    private JButton btnReset;

    private JLabel lblTotalMessage;
    private JLabel lblNameMessage;
    private JLabel lblEmailMessage;
    private JLabel lblPhoneMessage;
    private JLabel lblBrithdayMessage;

    public AddForm() throws ParseException {
        this.setSize(450, 600);
        this.setLocationRelativeTo(null);

        this.lblId = new JLabel("Id");
        this.lblName = new JLabel("Name");
        this.lblEmail = new JLabel("Email");
        this.lblPhone = new JLabel("Phone");
        this.lblBrithday = new JLabel("Brithday");

        this.lblId.setFont(new Font("Arial", 2, 15));
        this.lblName.setFont(new Font("Arial", 2, 15));
        this.lblEmail.setFont(new Font("Arial", 2, 15));
        this.lblPhone.setFont(new Font("Arial", 2, 15));
        this.lblBrithday.setFont(new Font("Arial", 2, 15));

        this.txtId = new JTextField();
        this.txtName = new JTextField();
        this.txtEmail = new JTextField();
        this.txtPhone = new JFormattedTextField(new MaskFormatter("#### ### ####"));
        this.txtBrithday = new JFormattedTextField(new MaskFormatter("## #######"));
        this.txtBrithday.setText("14/12/1995");
        this.btnSubmit = new JButton("Submit");
        this.btnReset = new JButton("Reset");

        this.lblId.setBounds(60, 50, 60, 40);
        this.lblName.setBounds(60, 100, 60, 40);
        this.lblEmail.setBounds(60, 150, 60, 40);
        this.lblPhone.setBounds(60, 200, 60, 40);
        this.lblBrithday.setBounds(60, 250, 60, 40);

        this.txtId.setBounds(150, 50, 200, 30);
        this.txtName.setBounds(150, 100, 200, 30);
        this.txtEmail.setBounds(150, 150, 200, 30);
        this.txtPhone.setBounds(150, 200, 200, 30);
        this.txtBrithday.setBounds(150, 250, 200, 30);

        this.btnSubmit.setBounds(120, 310, 80, 30);
        this.btnReset.setBounds(220, 310, 80, 30);

        this.lblTotalMessage = new JLabel();  // cho nay chua khoi tao nay.
        this.lblNameMessage = new JLabel();  // cho nay chua khoi tao nay.
        this.lblEmailMessage = new JLabel();  // cho nay chua khoi tao nay.
        this.lblPhoneMessage = new JLabel();  // cho nay chua khoi tao nay.
        this.lblBrithdayMessage = new JLabel();  // cho nay chua khoi tao nay.

        this.lblTotalMessage.setFont(new Font("Arial", 2, 16));
        this.lblTotalMessage.setBounds(50, 10, 300, 30);
        this.lblNameMessage.setBounds(370, 100, 30, 20);
        this.lblEmailMessage.setBounds(370, 150, 30, 20);
        this.lblPhoneMessage.setBounds(370, 200, 30, 20);
        this.lblBrithdayMessage.setBounds(370, 250, 30, 20);

        this.btnSubmit.addActionListener(new SubmitHandle());
        this.btnReset.addActionListener(new ResetHandle());

        this.add(this.lblId);
        this.add(this.lblName);
        this.add(this.lblEmail);
        this.add(this.lblPhone);
        this.add(this.lblBrithday);
        this.add(this.txtId);
        this.add(this.txtName);
        this.add(this.txtEmail);
        this.add(this.txtPhone);
        this.add(this.txtBrithday);
        this.add(this.btnSubmit);
        this.add(this.btnReset);
        this.add(this.lblTotalMessage);
        this.add(this.lblNameMessage);
        this.add(this.lblEmailMessage);
        this.add(this.lblPhoneMessage);
        this.add(this.lblBrithdayMessage);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class SubmitHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
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
            student.setBrithday(day);

            HashMap<String, String> errors = new FormHandle().validateAdd(student);
            int result = 99999;
            if (errors.size() == 0) {
                resetMessage();
                result = JOptionPane.showConfirmDialog(null, "Thêm dữ liệu vào danh sách?"
                        + "\nID : " + txtId.getText()
                        + "\nNAME : " + txtName.getText()
                        + "\nEMAIL : " + txtEmail.getText()
                        + "\nPHONE : " + txtPhone.getText()
                        + "\nBRITHDAY : " + txtBrithday.getText());
                //      + "\nCLASSNUMBER : " + txtClassNumber.getText());

                if (result == 0) {
                    StudentModel studentModel = new StudentModel();
                    studentModel.insert(student);
                    JOptionPane.showMessageDialog(null, "Them du lieu thanh cong");

                }
            } else {
                showError(errors);
            }
            System.out.println(result);
        }

    }

    class ResetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            txtName.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtBrithday.setText("");
        }

    }

    private void showError(HashMap<String, String> errors) {
        lblTotalMessage.setForeground(Color.red);
        lblTotalMessage.setText("* Nhập đầy đủ thông tin theo mẫu.");
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

    private void resetMessage() {
        lblTotalMessage.setText("");
        lblNameMessage.setText("");
        lblEmailMessage.setText("");
        lblPhoneMessage.setText("");
        lblBrithdayMessage.setText("");

    }

}
