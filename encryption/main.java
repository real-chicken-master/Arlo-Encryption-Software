import java.util.Scanner;

/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main extends decrypt
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class main
     */
    public main()
    {
        Scanner kb;
        kb = new Scanner(System.in);
        String input = kb.nextLine();
        String encrypted = encrypt(input);
        System.out.println(encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println(decrypted);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}