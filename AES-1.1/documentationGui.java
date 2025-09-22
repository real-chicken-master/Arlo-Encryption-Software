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
    Color background = globalValues.background;
    Color text = globalValues.text; 
    public documentationGui()
    {
        JFrame frame = new JFrame("AES-Documentation");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.getContentPane().setBackground(background);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.setResizable(false);

        frame.toFront();

        frame.setVisible(true);
        
        //encrypt documentation
        JPanel panelE1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelE1.setBackground(background);
        JLabel Etext1 = new JLabel("to encrypt:");
        Etext1.setForeground(text);
        panelE1.setPreferredSize(new Dimension(500, 21)); 
        panelE1.add(Etext1);

        JPanel panelE2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelE2.setBackground(background);
        JLabel Etext2 = new JLabel("    step 1: enter string");
        Etext2.setForeground(text);
        panelE2.setPreferredSize(new Dimension(500, 21)); 
        panelE2.add(Etext2);

        JPanel panelE3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelE3.setBackground(background);
        JLabel Etext3 = new JLabel("    step 2: click submit");
        Etext3.setForeground(text);
        panelE3.setPreferredSize(new Dimension(500, 21)); 
        panelE3.add(Etext3);

        JPanel panelE4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelE4.setBackground(background);
        JLabel Etext4 = new JLabel("    step 3: take note of your key and encrypted string");
        Etext4.setForeground(text);
        panelE4.setPreferredSize(new Dimension(500, 21)); 
        panelE4.add(Etext4);

        JPanel panelE5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelE5.setBackground(background);
        JLabel Etext5 = new JLabel("    step 4: done!!");
        Etext5.setForeground(text);
        panelE5.setPreferredSize(new Dimension(500, 21)); 
        panelE5.add(Etext5);

        frame.add(panelE1);
        frame.add(panelE2);
        frame.add(panelE3);
        frame.add(panelE4);

        
        //decrypt documentation
        JPanel panelD1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelD1.setBackground(background);
        JLabel Dtext1 = new JLabel("to decrypt:");
        Dtext1.setForeground(text);
        panelD1.setPreferredSize(new Dimension(500, 21)); 
        panelD1.add(Dtext1);

        JPanel panelD2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelD2.setBackground(background);
        JLabel Dtext2 = new JLabel("    step 1: enter your key and string");
        Dtext2.setForeground(text);
        panelD2.setPreferredSize(new Dimension(500, 21)); 
        panelD2.add(Dtext2);

        JPanel panelD3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelD3.setBackground(background);
        JLabel Dtext3 = new JLabel("    step 2: click submit");
        Dtext3.setForeground(text);
        panelD3.setPreferredSize(new Dimension(500, 21)); 
        panelD3.add(Dtext3);

        JPanel panelD4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelD4.setBackground(background);
        JLabel Dtext4 = new JLabel("    step 3: take note of your decrypted string");
        Dtext4.setForeground(text);
        panelD4.setPreferredSize(new Dimension(500, 21)); 
        panelD4.add(Dtext4);

        JPanel panelD5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelD5.setBackground(background);
        JLabel Dtext5 = new JLabel("    step 3: done!!");
        Dtext5.setForeground(text);
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