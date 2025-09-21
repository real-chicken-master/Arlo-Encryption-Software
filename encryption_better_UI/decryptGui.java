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
 * Write a description of class decryptGui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class decryptGui extends JFrame
{
    public decryptGui() throws java.io.IOException, java.awt.datatransfer.UnsupportedFlavorException {

        JFrame frame = new JFrame("KES");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.toFront();

        frame.setResizable(false);

        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JLabel titleText = new JLabel("you have selected decrypt please enter your string and key bellow");
        panel1.add(titleText);

        JPanel panel2 = new JPanel();
        JLabel stringText = new JLabel("enter your encrypted string: ");
        panel2.add(stringText);
        JTextField stringTextField= new JTextField(19);
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
        panel5.add(outputTextField);

        JPanel panel4 = new JPanel();
        JButton submitButton = new JButton("submit");
        submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String[] input = {stringTextField.getText(),keyTextField.getText()};
                    if(validKey(input[1])){
                        outputTextField.setText(decrypt.decrypt(input));
                    }else{
                        outputTextField.setText("invalid key");
                    }
                }
            });
        panel4.add(submitButton);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
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
