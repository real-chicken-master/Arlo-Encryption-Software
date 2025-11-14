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
    Class self = this.getClass();
    /**
     * Constructor for objects of class GuiBase
     */
    public GuiBase()
    {   
        System.out.println("test2");
        GuiManager.registerFrame(self);
    }

    public void refresh(){
        System.out.println("test");
        try
        {
            self.getDeclaredConstructor().newInstance();
        }
        catch (Exception e){}
        GuiManager.unregisterFrame(self);
        this.dispose();
    }
}