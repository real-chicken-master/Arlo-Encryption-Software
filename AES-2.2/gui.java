import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * this is the menu gui that allows users to open difrent guis.
 *
 * @author (Arlo Kennedy)
 * @version (2.1)
 */
public class gui extends GuiBase{
    /**
     * Constructor for objects of class gui
     */
    Color backgroundColor = globalValues.backgroundColor;
    Color textColor = globalValues.textColor; 
    Color buttonColor = globalValues.buttonColor;
    Color buttonTextColor = globalValues.buttonTextColor;
    public gui()
    {   
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("Frame.background", backgroundColor);
        UIManager.put("Label.foreground", textColor);
        UIManager.put("Button.foreground", buttonTextColor);
        UIManager.put("TextField.foreground", textColor);

        JFrame frame = new JFrame("AES-"+ globalValues.version);

        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setResizable(false);

        frame.toFront();

        frame.setVisible(true);

        JLabel versionText = new JLabel("version: " + globalValues.version);
        frame.add(versionText);
        
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(500, 50));
        JLabel introText = new JLabel("welcome to Arlo encryption software ");
        panel1.add(introText);
        JButton buttonStringDecryptoc = new JButton("documentation");
        panel1.add(buttonStringDecryptoc);
        buttonStringDecryptoc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new documentationGui();
                }
            });

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(500, 50));
        JButton buttonStringEncrypt = new JButton("encrypt string");
        buttonStringEncrypt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new encryptStringGui();
                }
            });
        panel2.add(buttonStringEncrypt);
        JButton buttonStringDecrypt = new JButton("decrypt string");
        buttonStringDecrypt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try
                    {
                        try
                        {
                            new decryptStringGui();
                        }
                        catch (java.awt.datatransfer.UnsupportedFlavorException ufe)
                        {}
                    }
                    catch (java.io.IOException ioe){}
                }
            });
        panel2.add(buttonStringDecrypt);
        
        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(500, 50));
        JButton buttonE = new JButton("encrypt bits");
        buttonE.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new encryptBitsGui();
                }
            });
        panel3.add(buttonE);
        JButton buttonD = new JButton("decrypt bits");
        buttonD.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try
                    {
                        try
                        {
                            new decryptBitsGui();
                        }
                        catch (java.awt.datatransfer.UnsupportedFlavorException ufe)
                        {}
                    }
                    catch (java.io.IOException ioe){}
                }
            });
        panel3.add(buttonD);
        
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.pack();
    }

    public void paint(Graphics g){
        super.paint(g);
    }
}    