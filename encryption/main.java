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
        String input;
        String decrypted;
        String encrypted;
        System.out.println("e to encrypt or d to decrypt");
        char[] array = (kb.nextLine()).toCharArray();
        while(array.length <= 1 && array.length > 0){
            array = (kb.nextLine()).toCharArray();

        }       
        switch(array[0]){
            case 'e':
                input= kb.nextLine();
                encrypted = encrypt(input);
                System.out.println(encrypted);
            case 'E':
                input= kb.nextLine();
                encrypted = encrypt(input);
                System.out.println(encrypted);
            case 'd':
                input= kb.nextLine();
                decrypted = decrypt(input);
                System.out.println(decrypted);
            case 'D':
                input= kb.nextLine();
                decrypted = decrypt(input);
                System.out.println(decrypted);
        }
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