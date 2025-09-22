
/**
 * the main class to start up the gui.
 *
 * @author (Arlo)
 * @version (1.1)
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
        {}

        new gui();
    }
}
