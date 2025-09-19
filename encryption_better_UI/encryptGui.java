import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JPanel;
/**
 * Write a description of class encryptGui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class encryptGui extends JFrame
{
    public encryptGui(){
        main(null);
    }

    /**
     * Constructor for objects of class encryptGui
     */
    public static void main(String[] args) 
    {   

        JFrame frame = new JFrame("KES");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.toFront();

        frame.setResizable(false);

        frame.setVisible(true);

        JPanel panel1 = new JPanel();

        JLabel firstText = new JLabel("you have selected encrypt please enter your string bellow");
        panel1.add(firstText);

        JPanel panel2 = new JPanel();
        JTextField enterTextField= new JTextField(20);
        panel2.add(enterTextField);

        JButton submitButton = new JButton("Submit");
        panel2.add(submitButton);

        JPanel panel3 = new JPanel();
        JLabel text = new JLabel("your key is:");
        panel3.add(text);

        JTextField keyTextField= new JTextField("N/A",20);
        panel3.add(keyTextField);
        
        JButton copyButton1 = new JButton("Copy");
        panel3.add(copyButton1);

        JPanel panel4 = new JPanel();
        JLabel stringText = new JLabel("your string is:");
        panel4.add(stringText);

        JTextField stringTextField= new JTextField("N/A",20);
        panel4.add(stringTextField);
        
        JButton copyButton2 = new JButton("Copy");
        panel4.add(copyButton2);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.pack();
    }
}
