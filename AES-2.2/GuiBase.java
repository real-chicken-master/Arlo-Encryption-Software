import javax.swing.JFrame;

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
    /**
     * Constructor for objects of class GuiBase
     */
    public GuiBase()
    {   
        GuiManager.registerFrame(frame);
    }
}