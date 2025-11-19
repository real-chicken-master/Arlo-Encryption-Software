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

    public static void registerFrame(JFrame frame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Dimension screenSize = toolkit.getScreenSize();

        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        int x = 500*openFrames.size()-8;
        if(x+500 <= screenWidth){
            frame.setLocation(x, 0);
        }else{
            if(500 <= screenHeight){
                frame.setLocation(0, 500);
            }
        }
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
        new configGui();
    }
}
