package wperu;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;



/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("ma fenetre");
        f.setSize(600,200);

        JPanel map = new JPanel();
        map.setMaximumSize(new Dimension(600,200));
        map.setBackground(Color.BLACK);
        f.getContentPane().add(map);
        JPanel container = new JPanel();
        JButton bouton1 = new JButton("NORTH");
        bouton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        container.add(bouton1,BorderLayout.CENTER);
        JPanel container2 = new JPanel();
        container2.setLayout(new BoxLayout(container2,BoxLayout.LINE_AXIS));
        JButton bouton2 = new JButton("WEST");
        JButton bouton3 = new JButton("SOUTH");
        JButton bouton4 = new JButton("EAST");
        container2.add(bouton2);
        container2.add(bouton3);
        container2.add(bouton4);
        JPanel containerhome = new JPanel();
        containerhome.setLayout(new BoxLayout(containerhome,BoxLayout.PAGE_AXIS));
        containerhome.add(container);
        containerhome.add(container2);
        f.getContentPane().add(containerhome,BorderLayout.SOUTH);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(dim.width/2 - f.getWidth()/2,dim.height/2 - f.getHeight()/2);
        f.setVisible(true);
    }   
        
    
}
