/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.exercises;

import javax.swing.JFrame;


public class Menu {
    private JFrame frame;
    private Table table = new Table();
    private Application application = new Application();
    
    
    
    
    public Menu() {
    frame = new JFrame();
    frame.setSize(800, 800);
    
    
    
    frame.add(application);
    frame.add(table);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    
    }
    
    public static void main(String[] args) {
        Menu menu = new Menu();
    }
    
}
