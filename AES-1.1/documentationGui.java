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
import java.awt.FlowLayout;

/**
 * this is the menu gui that allows users to open difrent guis.
 *
 * @author (Arlo Kennedy)
 * @version (1.1)
 */
public class documentationGui extends JFrame{
    Color backgroundColor = globalValues.backgroundColor;
    Color textColor = globalValues.textColor; 
    Color buttonColor = globalValues.buttonColor;
    public documentationGui()
    {
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("Frame.background", backgroundColor);
        UIManager.put("Label.foreground", textColor);
        UIManager.put("Button.foreground", textColor);
        UIManager.put("TextField.foreground", textColor);
        
        JFrame frame = new JFrame("AES-Documentation");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.getContentPane().setBackground(backgroundColor);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.setResizable(false);

        frame.toFront();

        frame.setVisible(true);

        JPanel panelT1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Ttext1 = new JLabel("String:");
        panelT1.setPreferredSize(new Dimension(500, 21)); 
        panelT1.add(Ttext1);
        frame.add(panelT1);
        //encrypt documentation
        JPanel panelE1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Etext1 = new JLabel("to encrypt:");
        panelE1.setPreferredSize(new Dimension(500, 21)); 
        panelE1.add(Etext1);

        JPanel panelE2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Etext2 = new JLabel("    step 1: enter string");
        panelE2.setPreferredSize(new Dimension(500, 21)); 
        panelE2.add(Etext2);

        JPanel panelE3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Etext3 = new JLabel("    step 2: click submit");
        panelE3.setPreferredSize(new Dimension(500, 21)); 
        panelE3.add(Etext3);

        JPanel panelE4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Etext4 = new JLabel("    step 3: take note of your key and encrypted string");
        panelE4.setPreferredSize(new Dimension(500, 21)); 
        panelE4.add(Etext4);

        JPanel panelE5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Etext5 = new JLabel("    step 4: done!!");
        panelE5.setPreferredSize(new Dimension(500, 21)); 
        panelE5.add(Etext5);

        frame.add(panelE1);
        frame.add(panelE2);
        frame.add(panelE3);
        frame.add(panelE4);

        //decrypt documentation
        JPanel panelD1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Dtext1 = new JLabel("to decrypt:");
        panelD1.setPreferredSize(new Dimension(500, 21)); 
        panelD1.add(Dtext1);

        JPanel panelD2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Dtext2 = new JLabel("    step 1: enter your key and string");
        panelD2.setPreferredSize(new Dimension(500, 21)); 
        panelD2.add(Dtext2);

        JPanel panelD3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Dtext3 = new JLabel("    step 2: click submit");
        panelD3.setPreferredSize(new Dimension(500, 21)); 
        panelD3.add(Dtext3);

        JPanel panelD4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Dtext4 = new JLabel("    step 3: take note of your decrypted string");
        panelD4.setPreferredSize(new Dimension(500, 21)); 
        panelD4.add(Dtext4);

        JPanel panelD5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Dtext5 = new JLabel("    step 3: done!!");
        panelD5.setPreferredSize(new Dimension(500, 21)); 
        panelD5.add(Dtext5);

        frame.add(panelD1);
        frame.add(panelD2);
        frame.add(panelD3);
        frame.add(panelD4);
        frame.add(panelD5);
        frame.pack();
    }
}