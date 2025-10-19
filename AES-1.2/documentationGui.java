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
 * @version (1.2)
 */
public class documentationGui extends JFrame{
    Color backgroundColor = globalValues.backgroundColor;
    Color textColor = globalValues.textColor; 
    Color buttonColor = globalValues.buttonColor;
    Color buttonTextColor = globalValues.buttonTextColor;
    public documentationGui()
    {
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("Frame.background", backgroundColor);
        UIManager.put("Label.foreground", textColor);
        UIManager.put("Button.foreground", buttonTextColor);
        UIManager.put("TextField.foreground", textColor);

        JFrame frame = new JFrame("documentation-AES-"+ globalValues.version);

        frame.getContentPane().setPreferredSize(new Dimension(500,600));

        frame.getContentPane().setBackground(backgroundColor);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        frame.setResizable(false);

        frame.toFront();

        frame.setVisible(true);

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.setPreferredSize(new Dimension(500, 21)); 
        JLabel versionText = new JLabel("version: " + globalValues.version);
        panel1.add(versionText);
        frame.add(panel1);

        JPanel panelT1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Ttext1 = new JLabel("String:");
        panelT1.setPreferredSize(new Dimension(500, 21)); 
        panelT1.add(Ttext1);
        frame.add(panelT1);

        //encrypt string documentation
        JPanel panelE1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Etext1 = new JLabel(" to encrypt:");

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

        //decrypt string documentation
        JPanel panelD1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Dtext1 = new JLabel(" to decrypt:");
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
        
        //bits

        JPanel panelT2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel Ttext2 = new JLabel("Bits:");
        panelT2.setPreferredSize(new Dimension(500, 21)); 
        panelT2.add(Ttext2);
        frame.add(panelT2);
        //encrypt bits documentation
        JPanel panelBE1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel EtextB1 = new JLabel(" to encrypt:");
        panelBE1.setPreferredSize(new Dimension(500, 21)); 
        panelBE1.add(EtextB1);

        JPanel panelBE2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel EtextB2 = new JLabel("    step 1: enter bits");
        panelBE2.setPreferredSize(new Dimension(500, 21)); 
        panelBE2.add(EtextB2);

        JPanel panelBE3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel EtextB3 = new JLabel("    step 2: click submit");
        panelBE3.setPreferredSize(new Dimension(500, 21)); 
        panelBE3.add(EtextB3);

        JPanel panelBE4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel EtextB4 = new JLabel("    step 3: take note of your key and encrypted string");
        panelBE4.setPreferredSize(new Dimension(500, 21)); 
        panelBE4.add(EtextB4);

        JPanel panelBE5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel EtextB5 = new JLabel("    step 4: done!!");
        panelBE5.setPreferredSize(new Dimension(500, 21)); 
        panelBE5.add(EtextB5);

        frame.add(panelBE1);
        frame.add(panelBE2);
        frame.add(panelBE3);
        frame.add(panelBE4);

        //decrypt bits documentation
        JPanel panelBD1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel DtextB1 = new JLabel("to decrypt:");
        panelBD1.setPreferredSize(new Dimension(500, 21)); 
        panelBD1.add(DtextB1);

        JPanel panelBD2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel DtextB2 = new JLabel("    step 1: enter your key and bits");
        panelBD2.setPreferredSize(new Dimension(500, 21)); 
        panelBD2.add(DtextB2);

        JPanel panelBD3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel DtextB3 = new JLabel("    step 2: click submit");
        panelBD3.setPreferredSize(new Dimension(500, 21)); 
        panelBD3.add(DtextB3);

        JPanel panelBD4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel DtextB4 = new JLabel("    step 3: take note of your decrypted string");
        panelBD4.setPreferredSize(new Dimension(500, 21)); 
        panelBD4.add(DtextB4);

        JPanel panelBD5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel DtextB5 = new JLabel("    step 3: done!!");
        panelBD5.setPreferredSize(new Dimension(500, 21)); 
        panelBD5.add(DtextB5);

        frame.add(panelBD1);
        frame.add(panelBD2);
        frame.add(panelBD3);
        frame.add(panelBD4);
        frame.add(panelBD5);
        
        frame.pack();
    }
}