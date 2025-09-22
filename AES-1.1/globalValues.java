import java.awt.Color;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * some global values such as color.
 * this is to use the same color pallet across the whole gui.
 *
 * @author (Arlo Kennedy)
 * @version (1.1)
 */
public class globalValues
{
    public static Color backgroundColor = new Color(200,230,230);
    public static Color textColor = new Color(0,0,0);
    public static Color buttonColor = new Color(100,100,100);
    int lineNumber = 0;
    public globalValues() throws FileNotFoundException {
        Scanner reader = new Scanner( new File("config.txt"));
        while (reader.hasNextLine()){
            String nextLine = reader.nextLine();
            if(!nextLine.contains("//")){
                if(nextLine.contains("background") && nextLine.contains("=")){
                    String[] splitLine = (nextLine).split(",");
                    int red = Integer.parseInt(splitLine[0].replaceAll("[\\D]", ""));
                    int green = Integer.parseInt(splitLine[1].replaceAll("[\\D]", ""));
                    int blue = Integer.parseInt(splitLine[2].replaceAll("[\\D]", ""));
                    backgroundColor = new Color(red,blue,green);
                }
                if(nextLine.contains("text") && nextLine.contains("=")){
                    String[] splitLine = (nextLine).split(",");
                    int red = Integer.parseInt(splitLine[0].replaceAll("[\\D]", ""));
                    int green = Integer.parseInt(splitLine[1].replaceAll("[\\D]", ""));
                    int blue = Integer.parseInt(splitLine[2].replaceAll("[\\D]", ""));
                    textColor = new Color(red,blue,green);
                }
                 if(nextLine.contains("button") && nextLine.contains("=")){
                    String[] splitLine = (nextLine).split(",");
                    int red = Integer.parseInt(splitLine[0].replaceAll("[\\D]", ""));
                    int green = Integer.parseInt(splitLine[1].replaceAll("[\\D]", ""));
                    int blue = Integer.parseInt(splitLine[2].replaceAll("[\\D]", ""));
                    buttonColor = new Color(red,blue,green);
                }
            }
        }
        reader.close();
    }
}
