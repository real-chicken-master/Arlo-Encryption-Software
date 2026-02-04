import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import java.awt.Frame;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;
public class GuiManager {
    private static final List<JFrame> openFrames = new ArrayList<>();
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static double width = screenSize.getWidth();
    static double height = screenSize.getHeight();

    public static void registerFrame(JFrame frame) {
        openFrames.add(frame);
        int x = (((int)width)/2)-(frame.getPreferredSize().width/2);
        int y = (((int)height)/2)-(frame.getPreferredSize().height/2);
        frame.setLocation(x,y);
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
        new configGui();
    }
}
