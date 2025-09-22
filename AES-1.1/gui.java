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
 * @version (1.1)
 */
public class gui extends JFrame{
    /**
     * Constructor for objects of class gui
     */
    Color backgroundColor = globalValues.backgroundColor;
    Color textColor = globalValues.textColor; 
    Color buttonColor = globalValues.buttonColor;
    public gui()
    {   
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("Frame.background", backgroundColor);
        UIManager.put("Label.foreground", textColor);
        UIManager.put("Button.foreground", textColor);
        UIManager.put("TextField.foreground", textColor);

        JFrame frame = new JFrame("AES-1.1-beta");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setResizable(false);

        frame.toFront();

        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JLabel introText = new JLabel("welcome to Arlo encryption software ");
        panel1.add(introText);
        JButton buttonDoc = new JButton("documentation");
        panel1.add(buttonDoc);
        buttonDoc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new documentationGui();
                }
            });

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(500,500));
        JButton buttonE = new JButton("encrypt");
        buttonE.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new encryptStringGui();
                }
            });
        panel2.add(buttonE);
        JButton buttonD = new JButton("decrypt");
        buttonD.addActionListener(new ActionListener() {
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
        panel2.add(buttonD);

        frame.add(panel1);
        frame.add(panel2);
        frame.pack();
    }

    public void paint(Graphics g){
        super.paint(g);
    }
}    