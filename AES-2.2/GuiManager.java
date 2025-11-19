import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import java.awt.Frame;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;
public class GuiManager {
    static Toolkit toolkit = Toolkit.getDefaultToolkit();

    static Dimension screenSize = toolkit.getScreenSize();
    static double screenWidth = screenSize.getWidth();
    static double screenHeight = screenSize.getHeight();

    static int arrayX = (int)screenWidth/500;
    static int arrayY = (int)screenWidth/500;
    private static final List<JFrame> openFrames = new ArrayList<>();
    static public boolean array[][] = new boolean[arrayX][arrayY];
    public static void registerFrame(JFrame frame) {
        int placeX = 0;
        int placeY = 0;
        for(int num = 0; num < arrayX;num++){
            for(int num2 = 0; num2 < arrayY;num2++){
                if(!array[num2][num]){
                    array[num2][num] = true;
                    placeX = num;
                    placeY = num2;
                    break;
                }
            }
        }
        System.out.println(placeX);
        System.out.println(placeY);
        int x = 500*placeX;
        int y = 500*placeY;
        frame.setLocation(x, y);
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
