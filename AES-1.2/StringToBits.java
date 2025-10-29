import javax.swing.Spring;

/**
 * Write a description of class StringToBits here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StringToBits
{

    /**
     * Constructor for objects of class StringToBits
     */
    public static String StringToBits(String input)
    {
        char[] array = input.toCharArray();
        String output = "";
        for(int num = 0; num < array.length;num++){
            output += Integer.toBinaryString(array[num]);
            output += " ";
        }
        return output;
    }
}
