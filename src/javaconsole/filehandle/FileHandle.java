/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.filehandle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Lan
 */
public class FileHandle {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("file.txt");
            FileOutputStream fos = new FileOutputStream("ngok.txt");
                    
            int b;
            while((b=fis.read()) != -1 ){
                System.out.print((char) b);
                fos.write(b);
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
        } catch (IOException ex){
        }
    }
}
