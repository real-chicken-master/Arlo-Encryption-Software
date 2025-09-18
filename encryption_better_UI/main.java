import java.util.Scanner;

/**
 * the main function for encryption/decryption that handles the ui.
 *
 * @author (Arlo Kennedy)
 * @version (1.0)
 */
public class main extends decrypt 
{
    private static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public main(){
        //main(null);
    }
    
    public static void main(String[] args)
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
                System.out.println(encrypt());
            }
            //decrypt mode
            if(SwitchCase == 'd' || SwitchCase == 'D'){
                SwitchCase = ' ';
                System.out.println("you have selected decrypt");
                System.out.println("please enter the string you want to decrypt");
                input= kb.nextLine();
                decrypted = decrypt(input);
                System.out.println("your decrypted String is");
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

    public static String encrypt(){
        String input;
        String encrypted;
        Scanner kb;
        kb = new Scanner(System.in);
        System.out.println("you have selected encrypt");
        System.out.println("please enter the string you want to encrypt");
        input = kb.nextLine();
        while(invalidinput(input)){
            System.out.println("please only enter charaters in the english alphatbet");
            input = kb.nextLine();
        }
        encrypted = encrypt(input);
        System.out.println("your encrypted String is");
        return encrypted;
    }

    private static boolean invalidinput(String input){
        char[] array = input.toCharArray();
        boolean temp = true;
        for(int num = 0; num < array.length;num++){
            Boolean temp2 = true;
            for(int num2 = 0; num2 < alphabet.length; num2++){
                if(array[num] == alphabet[num2]){
                    temp2 = false;
                }
            }
            if(!temp2){
                temp = false;
            }
        }
        return temp;
    }
}