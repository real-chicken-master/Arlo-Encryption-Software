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
 * @version (1.2)
 */
public class encryptStringGui extends JFrame
{
    Color backgroundColor = globalValues.backgroundColor;
    Color textColor = globalValues.textColor; 
    Color buttonColor = globalValues.buttonColor;
    Color buttonTextColor = globalValues.buttonTextColor;
    String input = "";
    String[] output = {"N/A","N/A"};
    public encryptStringGui(){
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("Frame.background", backgroundColor);
        UIManager.put("Label.foreground", textColor);
        UIManager.put("Button.foreground", buttonTextColor);
        UIManager.put("TextField.foreground", textColor);

        JFrame frame = new JFrame("encrypt-AES-"+ globalValues.version);

        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.toFront();

        frame.setResizable(false);

        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JLabel firstText = new JLabel("you have selected encrypt please enter your string bellow");
        panel1.add(firstText);

        JPanel panel2 = new JPanel();
        JTextField enterTextField= new JTextField(30);
        panel2.add(enterTextField);

        JButton submitButton = new JButton("Submit");

        panel2.add(submitButton);

        JPanel panel3 = new JPanel();
        JLabel text = new JLabel("your key is:");
        panel3.add(text);

        JTextField keyTextField= new JTextField(output[1],30);
        panel3.add(keyTextField);

        JButton copyButton1 = new JButton("Copy");
        copyButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    StringSelection stringSelection = new StringSelection(keyTextField.getText());

                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

                    clipboard.setContents(stringSelection, null);
                }
            });

        panel3.add(copyButton1);

        JPanel panel4 = new JPanel();
        JLabel stringText = new JLabel("your string is:");
        panel4.add(stringText);

        JTextField stringTextField= new JTextField(output[0],30);
        panel4.add(stringTextField);

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
                    if(validinput(input)){
                        output = encryptString.encryptString(input);
                    }else{
                        String[] temp = {"invaild input","invaild input"};
                        output = temp;
                    }
                    keyTextField.setText(output[1]);
                    stringTextField.setText(output[0].toLowerCase());
                }
            });

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.pack();
    }

    boolean validinput(String input){
        if(input.length() == 0){
            return false;
        }
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] inputArray = (input.toLowerCase()).toCharArray();
        for(int num = 0; num < inputArray.length; num++){
            boolean validChar = false;
            if(inputArray[num] == ' '){
                validChar = true;
            }
            for(int num2 = 0; num2 < alphabet.length; num2++){
                if(inputArray[num] == alphabet[num2]){
                    validChar=true;
                }
            }
            if(!validChar){
                return false;
            }
        }
        return true;
    }
}
