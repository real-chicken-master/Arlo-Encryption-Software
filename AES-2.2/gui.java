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
    public gui()
    {   
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
        JButton buttonDocumentation = new JButton("documentation");
        panel1.add(buttonDocumentation);
        buttonDocumentation.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new documentationGui();
                }
            });
            
        JButton buttonConfig = new JButton("settings");
        panel1.add(buttonConfig);
        buttonConfig.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new configGui();
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