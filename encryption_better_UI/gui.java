import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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

        menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu(" Menu ");
        menuBar.add(menu);

        menuItem=new JMenuItem("encrypt");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem=new JMenuItem("decrypt");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        JPanel panel = new JPanel();
        
        panel.setPreferredSize(new Dimension(500,500));
        screen = new Canvas();
        panel.add(screen);
        this.pack();
    }

    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        if(cmd == "encrypt"){
            main.encrypt();
        }
        if(cmd == "decrypt"){
            //main.decrypt();
        }
        System.out.println(cmd);
    }

    public void paint (Graphics g){
        super.paint(g);
    }
    }    