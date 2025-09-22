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
    Color background = globalValues.background;
    Color text = globalValues.text; 
    public decryptStringGui() throws java.io.IOException, java.awt.datatransfer.UnsupportedFlavorException {

        JFrame frame = new JFrame("decrypt AES");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));
        
        frame.getContentPane().setBackground(background);
        
        frame.setLayout(new FlowLayout());
        
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.toFront();

        frame.setResizable(false);

        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        panel1.setBackground(background);
        JLabel titleText = new JLabel("you have selected decrypt please enter your string and key bellow");
        titleText.setForeground(text);
        panel1.add(titleText);

        JPanel panel2 = new JPanel();
        panel2.setBackground(background);
        JLabel stringText = new JLabel("enter your encrypted string: ");
        stringText.setForeground(text);
        panel2.add(stringText);
        JTextField stringTextField= new JTextField(19);
        stringTextField.setForeground(text);
        panel2.add(stringTextField);
        JButton pasteButton1= new JButton("paste");
        pasteButton1.setForeground(text);
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
        panel3.setBackground(background);
        JLabel keyText = new JLabel(" enter your encryption key: ");
        keyText.setForeground(text);
        panel3.add(keyText);
        JTextField keyTextField= new JTextField(19);
        keyTextField.setForeground(text);
        panel3.add(keyTextField);
        JButton pasteButton2 = new JButton("paste");
        pasteButton2.setForeground(text);
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
        panel5.setBackground(background);
        JLabel outputText = new JLabel("your decrypted string: ");
        outputText.setForeground(text);
        panel5.add(outputText);
        JTextField outputTextField= new JTextField(20);
        outputTextField.setForeground(text);
        panel5.add(outputTextField);

        JPanel panel4 = new JPanel();
        panel4.setBackground(background);
        JButton submitButton = new JButton("submit");
        submitButton.setForeground(text);
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
