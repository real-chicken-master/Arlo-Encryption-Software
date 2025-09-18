import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 * Write a description of class gui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class gui extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas screen;
    private JTextField inputField;
    private JButton submitButton;
    private static char mode = 'm'; // m = menu, e = encrypt, d = decrypt
    /**
     * Constructor for objects of class gui
     */
    public gui()
    {
        setTitle("KES");

        this.getContentPane().setPreferredSize(new Dimension(1310,800));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.toFront();

        this.setVisible(true);

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(500,500));
        screen = new Canvas();
        panel1.add(screen);
        this.pack();
    }

    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        if(cmd == "encrypt"){
            encryptGui();
        }
        if(cmd == "decrypt"){
            decryptGui();
        }
        repaint();
    }

    public static void decryptGui(){
        mode = 'd';
        //main.decrypt();
    }

    public static void encryptGui(){
        mode = 'e';
        //main.encrypt();
    }

    public void paint (Graphics g){
        if(mode != 'm'){
            inputField = new JTextField();
            add(inputField).setPreferredSize(new Dimension(10,10));
        }
        this.pack();
        super.paint(g);
    }
}    