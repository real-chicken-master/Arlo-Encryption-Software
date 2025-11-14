import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import java.awt.Frame;

public class GuiManager {
    private static final List<Class> openFrames = new ArrayList<>();

    public static void registerFrame(Class frame) {
        openFrames.add(frame);
    }

    public static void unregisterFrame(Class frame) {
        openFrames.remove(frame);
    }

    public static void refreshAllGuis() {
        for(int num = 0; num < openFrames.size();num++){
            Class temp = openFrames.get(num);
            try
            {
                temp.getMethod("refresh").invoke(temp);
            }
            catch (Exception e){
                System.out.println(temp);
                   System.out.println(e);
            }
        }
    }
}
