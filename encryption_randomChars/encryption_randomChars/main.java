import java.util.Scanner;

/**
 * the main function for encryption/decryption.
 *
 * @author (Arlo Kennedy)
 * @version (0.1)
 */
public class main extends decrypt
{
    public main()
    {   
        // the program will loop until run is false
        boolean run = true;
        while(run){
            //setup the keyboard input
            Scanner kb;
            kb = new Scanner(System.in);
            //this string will be whatever the user inputs
            String input;
            //this string will be the decrypted message
            String decrypted;
            //this string will be the encrypted message
            String encrypted;
            System.out.println("e to encrypt or d to decrypt");
            //the variable that will be the first letter of the input recived and will put the program into encrypt or decrypt mode
            char SwitchCase = ' ';
            //get a input for switch case
            while(!(SwitchCase == 'e' || SwitchCase == 'E' || SwitchCase == 'd' || SwitchCase == 'D')){
                char[] array = (kb.nextLine()).toCharArray();
                SwitchCase = array[0];
                if(!(SwitchCase == 'e' || SwitchCase == 'E' || SwitchCase == 'd' || SwitchCase == 'D')){
                    System.out.println("please enter one of the following e,E,d,D");
                }
            }
            //encrypt mode
            if(SwitchCase == 'e' || SwitchCase == 'E'){
                SwitchCase = ' ';
                System.out.println("you have selected encrypt");
                System.out.println("please enter the string you want to encrypt");
                input= kb.nextLine();
                encrypted = encrypt(input);
                System.out.println("your encrypted String is");
                System.out.println(encrypted);
            }
            //decrypt mode
            if(SwitchCase == 'd' || SwitchCase == 'D'){
                SwitchCase = ' ';
                System.out.println("you have selected decrypt");
                System.out.println("please enter the string you want to decrypt");
                input= kb.nextLine();
                decrypted = decrypt(input);
                System.out.println("your encrypted String is");
                System.out.println(decrypted);
            }
            //ask to run again
            System.out.println("enter r to run again enter anything else to exit");
            char[] nextLine = (kb.nextLine()).toCharArray();
            char temp = nextLine[0];
            if(temp != 'r'){
                run = false;
            }
        }
    }
}