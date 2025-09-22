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
    Color background = globalValues.background;
    Color text = globalValues.text; 
    public gui()
    {
        JFrame frame = new JFrame("AES");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setResizable(false);

        frame.toFront();

        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        panel1.setBackground(background);
        JLabel introText = new JLabel("welcome to Arlo encryption software ");
        introText.setForeground(text);
        panel1.add(introText);
        JButton buttonDoc = new JButton("documentation");
        buttonDoc.setForeground(text);
        panel1.add(buttonDoc);
        buttonDoc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new documentationGui();
                }
            });

        JPanel panel2 = new JPanel();
        panel2.setBackground(background);
        panel2.setPreferredSize(new Dimension(500,500));
        JButton buttonE = new JButton("encrypt");
        buttonE.setForeground(text);
        buttonE.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new encryptGui();
                }
            });
        panel2.add(buttonE);
        JButton buttonD = new JButton("decrypt");
        buttonD.setForeground(text);
        buttonD.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try
                    {
                        try
                        {
                            new decryptGui();
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
        frame.getContentPane().setBackground(background);
        frame.pack();
    }

    public void paint(Graphics g){
        super.paint(g);
    }
}    