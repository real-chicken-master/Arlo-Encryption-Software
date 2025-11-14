import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import java.awt.Frame;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;
public class GuiManager {
    private static final List<JFrame> openFrames = new ArrayList<>();

    public static void registerFrame(JFrame frame) {
        openFrames.add(frame);
    }

    public static void unregisterFrame(JFrame frame) {
        openFrames.remove(frame);
    }

    public static void refreshAllGuis() {
        for(int num = 0; num < openFrames.size();num++){
            JFrame frame = openFrames.get(num);
            frame.dispose();
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
