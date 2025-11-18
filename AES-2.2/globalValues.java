import java.awt.Color;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.List;
import java.io.IOException;
import java.io.FileWriter;

/**
 * some global values such as color.
 * this is to use the same color pallet across the whole gui.
 *
 * @author (Arlo Kennedy)
 * @version (2.1)
 */
public class globalValues
{
    public static Color backgroundColor = new Color(200,230,230);
    public static Color textColor = new Color(0,0,0);
    public static Color buttonColor = new Color(210,210,210);
    public static Color buttonTextColor = new Color(0,0,0);
    public static double version = 2.1;
    private static String filePath = "config.txt";
    public globalValues() throws FileNotFoundException {
        Scanner reader = new Scanner(new File(filePath));
        boolean buttonTextDecleared = false;
        while (reader.hasNextLine()){
            String nextLine = reader.nextLine();
            try{
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
                    if(nextLine.contains("buttonBackground") && nextLine.contains("=")){
                        String[] splitLine = (nextLine).split(",");
                        int red = Integer.parseInt(splitLine[0].replaceAll("[\\D]", ""));
                        int green = Integer.parseInt(splitLine[1].replaceAll("[\\D]", ""));
                        int blue = Integer.parseInt(splitLine[2].replaceAll("[\\D]", ""));
                        buttonColor = new Color(red,blue,green);
                    }
                    if(nextLine.contains("buttonText") && nextLine.contains("=")){
                        String[] splitLine = (nextLine).split(",");
                        int red = Integer.parseInt(splitLine[0].replaceAll("[\\D]", ""));
                        int green = Integer.parseInt(splitLine[1].replaceAll("[\\D]", ""));
                        int blue = Integer.parseInt(splitLine[2].replaceAll("[\\D]", ""));
                        buttonTextColor = new Color(red,blue,green);
                        buttonTextDecleared = true;
                    }
                }
            }catch(Exception e){}
        }
        if(!buttonTextDecleared){
            buttonTextColor = textColor;
        }
        reader.close();
    }

    public static void save(){
        Path path = Paths.get(filePath);
        try{
            List<String> lines = Files.readAllLines(path);
            FileWriter writer = new FileWriter(filePath);
            for(int num = 0; num < lines.size();num++){
                String nextLine = lines.get(num);
                String newLineContent = nextLine;
                String output = newLineContent;
                if(!nextLine.contains("//")){
                    if(nextLine.contains("background") && nextLine.contains("=")){
                        int red = backgroundColor.getRed();
                        int green = backgroundColor.getGreen();
                        int blue = backgroundColor.getBlue();
                        String[] splitLine = nextLine.split("\\(");
                        splitLine[1] = (String)("(" + red + "," + blue + ","+ green + ")");
                        output = splitLine[0] + splitLine[1];
                    }
                    if(nextLine.contains("text") && nextLine.contains("=")){
                        int red = textColor.getRed();
                        int green = textColor.getGreen();
                        int blue = textColor.getBlue();
                        String[] splitLine = nextLine.split("\\(");
                        splitLine[1] = (String)("(" + red + "," + blue + ","+ green + ")");
                        output = splitLine[0] + splitLine[1];
                    }
                    if(nextLine.contains("buttonBackground") && nextLine.contains("=")){
                        int red = buttonColor.getRed();
                        int green = buttonColor.getGreen();
                        int blue = buttonColor.getBlue();
                        String[] splitLine = nextLine.split("\\(");
                        splitLine[1] = (String)("(" + red + "," + blue + ","+ green + ")");
                        output = splitLine[0] + splitLine[1];
                    }
                    if(nextLine.contains("buttonText") && nextLine.contains("=")){
                        int red = buttonTextColor.getRed();
                        int green = buttonTextColor.getGreen();
                        int blue = buttonTextColor.getBlue();
                        String[] splitLine = nextLine.split("\\(");
                        splitLine[1] = (String)("(" + red + "," + blue + ","+ green + ")");
                        output = splitLine[0] + splitLine[1];
                    }
                }
                writer.write(output + "\n");
            }
            writer.close();
        }catch(Exception e){
        System.out.println(e);
        }
    }
}
