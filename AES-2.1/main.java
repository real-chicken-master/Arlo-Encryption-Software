import javax.swing.JOptionPane;
/**
 * the main class to start up the gui.
 *
 * @author (Arlo)
 * @version (2.1)
 */
public class main
{
    public main() {
        main(null);
    }

    public static void main(String[] args) {
        try
        {
            new globalValues();
        }
        catch (java.io.FileNotFoundException fnfe)
        {
            JOptionPane.showMessageDialog(null, "config file not found");
        }
        try
        {
            new gui();
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "AES quit unexpectedly");
        }
    }
}
