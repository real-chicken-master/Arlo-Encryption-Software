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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
/**
 * this is the gui that handles the inputs and outputs of the encrypt class.
 *
 * @author (Arlo Kennedy)
 * @version (2.1)
 */
public class hashStringGui extends GuiBase
{
    String input = "";
    String output = "N/A";
    public hashStringGui(){
        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.toFront();

        frame.setResizable(false);

        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JLabel firstText = new JLabel("you have selected hash please enter your string bellow");
        panel1.add(firstText);

        JPanel panel2 = new JPanel();
        JTextField enterTextField= new JTextField(30);
        panel2.add(enterTextField);

        JButton submitButton = new JButton("Submit");

        panel2.add(submitButton);

        JPanel panel4 = new JPanel();
        JLabel stringText = new JLabel("your hash is:");
        panel4.add(stringText);

        JTextField stringTextField= new JTextField(output,30);
        panel4.add(stringTextField);

        JPanel panel5 = new JPanel();
        JPanel panel3 = new JPanel();
        JLabel paddingText = new JLabel("enter the length of the output");
        panel5.add(paddingText);
        JTextField paddingTextField= new JTextField(30);
        panel3.add(paddingTextField);

        JButton copyButton2 = new JButton("Copy");
        copyButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    StringSelection stringSelection = new StringSelection(stringTextField.getText());

                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

                    clipboard.setContents(stringSelection, null);
                }
            });
        panel4.add(copyButton2);

        submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    input = enterTextField.getText();
                    int padding = 0;
                    try{
                        padding = Integer.parseInt(paddingTextField.getText());
                    }catch(Exception E){}
                    String[] test = {"",""};
                    if(validinput(input)){
                        output = hashString.hashString(input,padding);
                    }else{
                        String temp = "invaild input";
                        output = temp;
                    }
                    stringTextField.setText(output.toLowerCase());
                }
            });

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel5);
        frame.add(panel3);
        frame.add(panel4);
        frame.pack();
    }

    boolean validinput(String input){
        if(input.length() == 0){
            return false;
        }
        return true;
    }
}
