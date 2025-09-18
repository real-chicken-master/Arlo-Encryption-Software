import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 * Write a description of class gui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class gui extends JFrame{
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas screen;
    private JTextField inputField;
    private JButton submitbuttonE;
    private static char mode = 'm'; // m = menu, e = encrypt, d = decrypt
    /**
     * Constructor for objects of class gui
     */
    public gui()
    {
        JFrame frame = new JFrame("KES");

        frame.getContentPane().setPreferredSize(new Dimension(500,500));

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.setResizable(false);
        
        frame.toFront();

        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,500));
        JButton buttonE = new JButton("encrypt");
        buttonE.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new encryptGui();
                }
            });
        panel.add(buttonE);
        JButton buttonD = new JButton("decrypt");
        buttonE.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //new decryptGui();
                }
            });
        //panel.add(buttonD);
        frame.add(panel);
        frame.pack();
    }

    public void paint(Graphics g){
        super.paint(g);
    }
}    