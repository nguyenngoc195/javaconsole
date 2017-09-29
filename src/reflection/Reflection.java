/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflection;

import java.lang.reflect.Field;
import javaconsole.entity.Student;

/**
 *
 * @author Lan
 */
public class Reflection {
    public static void main(String[] args) {
      Student td = new Student();
      td.setId(12);
      td.setName("ngoc");
      td.setPhone("12356");
      td.setBrithday("3562627");
      td.setEmail("hgkjhjh");
      
        demoReflection(td);
              
    }
    
    
    public static void demoReflection(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        System.out.println("thuoc class" + obj.getClass().getName());
        
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println("ten: "+ field.getName());
                System.out.println("kieu du lieu:" + field.getType().getSimpleName());
                System.out.println("gia tri: " + field.get(obj));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
