import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
/**
 * Write a description of class GuiBase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GuiBase extends JFrame
{
    // instance variables - replace the example below with your own
    JFrame frame = new JFrame("AES-"+ globalValues.version);
    Color backgroundColor = globalValues.backgroundColor;
    Color textColor = globalValues.textColor; 
    Color buttonColor = globalValues.buttonColor;
    Color buttonTextColor = globalValues.buttonTextColor;
    /**
     * Constructor for objects of class GuiBase
     */
    public GuiBase()
    {   
        UIManager.put("Button.background", buttonColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("Frame.background", backgroundColor);
        UIManager.put("Label.foreground", textColor);
        UIManager.put("Button.foreground", buttonTextColor);
        UIManager.put("TextField.foreground", textColor);
        frame = new JFrame("AES-"+ globalValues.version);
        GuiManager.registerFrame(frame);
    }
}