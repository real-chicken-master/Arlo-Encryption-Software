import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;

/**
 * Write a description of class decrypt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class decrypt
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class decrypt
     */
    public decrypt()
    {
        // initialise instance variables
        Scanner kb;
        kb = new Scanner(System.in);
        String input = kb.nextLine();
        String temp = decrypt(input);
    }

    private String decrypt(String input)
    {
        String output = input;

        output = decryptSubtitute(output);
        System.out.println(output);

        output = decryptRotate(output);
        System.out.println(output);

        output = decryptSwap(output);
        System.out.println(output);

        return output;
    }

    private String decryptSubtitute(String input) {
        char[] tempArray = input.toCharArray();
        char[] myArray = new char[tempArray.length-1];
        for(int num = 0; num < tempArray.length-1;num++){
            myArray[num] = tempArray[num];
        }
        int amount = (int)tempArray[tempArray.length-1];
        for(int num = 0; num < myArray.length;num++){
            myArray[num] += amount;
        }
        String output = "";   
        for(int num = 0; num < myArray.length;num++){
            output += myArray[num];
        }
        return output;
    }

    private String decryptSwap(String input) {
        char[] myArray = input.toCharArray();
        char placeholder1 = ' ';
        char placeholder2 = ' ';
        for(int num = myArray.length-1; num > 0 ;num--){
            if(num > 1){
                if(num%2 == 1){
                    placeholder1 = myArray[num-1];
                    placeholder2 = myArray[num];
                    myArray[num] = placeholder1;
                    myArray[num-1] = placeholder2;
                }
            }
        }
        String output = "";
        for(int num = 0; num < myArray.length;num++){
            output += myArray[num];
        }
        return output;
    }

    private String decryptRotate(String input)
    {
        char[] myArray = input.toCharArray();
        char placeholder1 = ' ';
        char placeholder2 = ' ';
        char lastChar = myArray[myArray.length-1];
        for(int num = myArray.length-1; num > 0 ;num--){
            placeholder1 = myArray[num];
            if(num > 1){
                placeholder2 = myArray[num-1];
            }else{
                placeholder2 = lastChar;
            }
            myArray[num] = placeholder2;
        }
        String output = "";
        for(int num = 0; num < myArray.length;num++){
            output += myArray[num];
        }
        return output;
    }
}
