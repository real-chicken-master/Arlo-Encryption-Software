import javax.swing.Spring;

/**
 * Write a description of class CopyOfBitsToString here.
 *
 * @author (Arlo Kennedy)
 * @version (2.1)
 */
public class BitsToString
{

    /**
     * Constructor for objects of class CopyOfBitsToString
     */
    public static String BitsToString(String input)
    {
        String[] array = input.split(" ");
        String output = "";
        for(int num = 0; num < array.length;num++){
            output += (char)Integer.parseInt(array[num], 2);
        }
        return output;
    }
}
