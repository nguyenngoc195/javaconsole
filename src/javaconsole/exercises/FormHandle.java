/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.exercises;

import java.util.HashMap;
import javaconsole.entity.Student;

/**
 *
 * @author Lan
 */
public class FormHandle {
    public HashMap<String, String> validateAdd(Student stu) {
        HashMap<String, String> errors = new HashMap<>();
        if (stu.getName().isEmpty()) {
            errors.put("txtName", "???");
        }
        if (stu.getEmail().isEmpty()) {
            errors.put("txtEmail", "???");
        }
        if (stu.getPhone().isEmpty()) {
            errors.put("txtPhone", "???");
        }
        if (stu.getBirthday().isEmpty()) {
            errors.put("txtBrithday", "???");
        }
        return errors;
    }
}
