import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;

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

        JLabel firstText = new JLabel("you have selected encrypt please enter your string bellow");
        frame.add(firstText);

        JTextField enterTextField= new JTextField(20);
        frame.add(enterTextField);

        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);
        
        JLabel text = new JLabel("your key is:");
        frame.add(text);

        JTextField keyTextField= new JTextField(20);
        frame.add(keyTextField);
        
        frame.pack();
    }
}
