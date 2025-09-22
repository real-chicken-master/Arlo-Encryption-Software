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
 * @version (1.0)
 */
public class decryptStringGui extends JFrame
{
    Color backgroundColor = globalValues.backgroundColor;
    Color textColor = globalValues.textColor; 
    Color buttonColor = globalValues.buttonColor;
    Color buttonTextColor = globalValues.buttonTextColor;
    public decryptStringGui() throws java.io.IOException, java.awt.datatransfer.UnsupportedFlavorException {
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("Frame.background", backgroundColor);
        UIManager.put("Label.foreground", textColor);
        UIManager.put("Button.foreground", buttonTextColor);
        UIManager.put("TextField.foreground", textColor);

        JFrame frame = new JFrame("decrypt AES");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.getContentPane().setBackground(backgroundColor);

        frame.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.toFront();

        frame.setResizable(false);

        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JLabel titleText = new JLabel("you have selected decrypt please enter your string and key bellow");
        panel1.add(titleText);

        JPanel panel2 = new JPanel();
        JLabel stringText = new JLabel("enter your encrypted string: ");
        panel2.add(stringText);
        JTextField stringTextField = new JTextField(19);
        panel2.add(stringTextField);
        JButton pasteButton1= new JButton("paste");
        pasteButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    Transferable contents = clipboard.getContents(null);
                    try{
                        stringTextField.setText((String)contents.getTransferData(DataFlavor.stringFlavor));}
                    catch(Exception a){
                        stringTextField.setText(a.toString());
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
        JLabel outputText = new JLabel("your decrypted string: ");
        panel5.add(outputText);
        JTextField outputTextField= new JTextField(20);
        outputTextField.setForeground(textColor);
        panel5.add(outputTextField);

        JPanel panel4 = new JPanel();
        JButton submitButton = new JButton("submit");
        submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String[] input = {stringTextField.getText(),keyTextField.getText()};
                    if(validKey(input[1])){
                        outputTextField.setText(decryptString.decryptString(input));
                    }else{
                        outputTextField.setText("invalid key");
                    }
                }
            });
        panel4.add(submitButton);

        frame.add(panel1);
        frame.add(panel3);
        frame.add(panel2);
        frame.add(panel4);
        frame.add(panel5);  

        frame.pack();
    }

    boolean validKey(String key){
        if (key.length() != 88){
            return false;
        }
        return true;
    }
}
