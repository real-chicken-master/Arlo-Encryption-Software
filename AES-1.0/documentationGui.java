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

/**
 * this is the menu gui that allows users to open difrent guis.
 *
 * @author (Arlo Kennedy)
 * @version (1.0)
 */
public class documentationGui extends JFrame{
    public documentationGui()
    {
        JFrame frame = new JFrame("AES-Documentation");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.setLayout(new FlowLayout());

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setResizable(false);

        frame.toFront();

        frame.setVisible(true);

        JPanel panelE = new JPanel(new GridLayout());
        JPanel panelE1 = new JPanel();
        JLabel Etext1 = new JLabel("encrypt:");
        panelE1.add(Etext1);

        JPanel panelE2 = new JPanel();
        JLabel Etext2 = new JLabel("step 1: enter string");
        panelE2.add(Etext2);
        
        panelE.add(panelE1);
        panelE.add(panelE2);

        frame.add(panelE);
        frame.pack();
    }
}