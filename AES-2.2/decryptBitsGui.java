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
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
/**
 * this is the gui that handles the inputs and outputs of the decrypt class.
 *
 * @author (Arlo Kennedy)
 * @version (2.1    )
 */
public class decryptBitsGui extends GuiBase
{
    public decryptBitsGui() throws java.io.IOException, java.awt.datatransfer.UnsupportedFlavorException {
        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.getContentPane().setBackground(backgroundColor);

        frame.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.toFront();

        frame.setResizable(false);

        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JLabel titleText = new JLabel("you have selected decrypt please enter your Bit and key bellow");
        panel1.add(titleText);

        JPanel panel2 = new JPanel();
        JLabel BitText = new JLabel("enter your encrypted Bits: ");
        panel2.add(BitText);
        JTextField BitTextField = new JTextField(19);
        panel2.add(BitTextField);
        JButton pasteButton1= new JButton("paste");
        pasteButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    Transferable contents = clipboard.getContents(null);
                    try{
                        BitTextField.setText((String)contents.getTransferData(DataFlavor.stringFlavor));}
                    catch(Exception a){
                        BitTextField.setText(a.toString());
                    }
                }
            });
        panel2.add(pasteButton1);

        JPanel panel3 = new JPanel();
        JLabel keyText = new JLabel(" enter your encryption key: ");
        panel3.add(keyText);
        JTextField keyTextField= new JTextField(19);
        panel3.add(keyTextField);
        JButton pasteButton2 = new JButton("paste");
        pasteButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    Transferable contents = clipboard.getContents(null);
                    try{
                        keyTextField.setText((String)contents.getTransferData(DataFlavor.stringFlavor));}
                    catch(Exception a){
                        keyTextField.setText(a.toString());
                    }
                }
            });
        panel3.add(pasteButton2);

        JPanel panel5 = new JPanel();
        JLabel outputText = new JLabel("your decrypted Bits: ");
        panel5.add(outputText);
        JTextField outputTextField= new JTextField(20);
        outputTextField.setForeground(textColor);
        panel5.add(outputTextField);

        JPanel panel4 = new JPanel();
        JButton submitButton = new JButton("submit");
        submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String[] input = {BitTextField.getText(),keyTextField.getText()};
                    if(validKey(input[1])){
                        if(validinput(input[0])){
                            outputTextField.setText(decryptBits.decryptBits(input));
                        }else{
                            outputTextField.setText("invalid input");
                            JOptionPane.showMessageDialog(null, "invalid input");
                        }
                    }else{
                        outputTextField.setText("invalid key");
                        JOptionPane.showMessageDialog(null, "invalid key");
                    }
                }
            });
        panel4.add(submitButton);

        JPanel panel6 = new JPanel();
        JLabel stringToBitsText = new JLabel("enter string below to convert to bits");
        panel6.add(stringToBitsText);

        JPanel panel7 = new JPanel();
        JTextField enterBitsField= new JTextField(30);
        panel7.add(enterBitsField);

        JButton copyButton3 = new JButton("paste");
        copyButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    Transferable contents = clipboard.getContents(null);
                    try{
                        enterBitsField.setText((String)contents.getTransferData(DataFlavor.stringFlavor));}
                    catch(Exception a){
                        enterBitsField.setText(a.toString());
                    }
                }
            });
        panel7.add(copyButton3);

        JPanel panel8 = new JPanel();
        JButton submitBitsButton = new JButton("Submit");
        submitBitsButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    String string = enterBitsField.getText();
                    try{
                        string = BitsToString.BitsToString(string);
                    }catch(Exception e){
                        string = "invalid string";
                        JOptionPane.showMessageDialog(null, "invalid string");
                    }
                    enterBitsField.setText(string);
                }
            });

        panel8.add(submitBitsButton);
        frame.add(panel1);
        frame.add(panel3);
        frame.add(panel2);
        frame.add(panel4);
        frame.add(panel5);  
        frame.add(panel6); 
        frame.add(panel7); 
        frame.add(panel8); 
        frame.pack();
    }

    boolean validinput(String input){

        char[] inputArray = (input.toLowerCase()).toCharArray();
        for(int num = 0; num < inputArray.length; num++){
            boolean validChar = false;
            if(inputArray[num] == ' '){
                validChar = true;
            }
            if(inputArray[num] == '1' || inputArray[num] == '0'){
                validChar=true;
            }
            if(!validChar){
                return false;
            }
        }
        return true;
    }

    boolean validKey(String key){
        if (key.length() != 18){
            return false;
        }
        return true;
    }
}
