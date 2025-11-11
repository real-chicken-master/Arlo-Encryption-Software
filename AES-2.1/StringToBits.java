import javax.swing.Spring;

/**
 * Write a description of class StringToBits here.
 *
 * @author (Arlo Kennedy)
 * @version (2.1)
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
