/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.exercises;

import java.util.ArrayList;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lan
 */
public class Table extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public Table() {
        table = new JTable();
        tableModel = new DefaultTableModel();
        table.setLayout(null);
        setSize(780, 500);
        setLayout(null);

        tableModel.addColumn("Id");
        tableModel.addColumn("Name");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone");
        tableModel.addColumn("Birthday");

        StudentModel studentModel = new StudentModel();
        ArrayList<Student> list = studentModel.getListStudent();
        for (Student student : list) {
            Object[] str = new Object[]{student.getId(), student.getName(), student.getEmail(), student.getPhone(), student.getBirthday()};
            tableModel.addRow(str);

        }
        table.setModel(tableModel);
        table.setRowHeight(40);
       
        //  
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 760, 480);

        this.add(scrollPane);
        setVisible(true);
    }

}
