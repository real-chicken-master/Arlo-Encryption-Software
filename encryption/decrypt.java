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

    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

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
        System.out.println(temp);
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

        output = decryptCaesar(output);
        System.out.println(output);

        return output;
    }

    private String decryptCaesar(String input) {
        char[] tempArray = input.toCharArray();
        char[] inputArray = new char[tempArray.length-2];
        for(int num = 0; num < tempArray.length-2;num++){
            inputArray[num] = tempArray[num];
        }
        char[] outputArray = new char[inputArray.length];
        int amount = Character.getNumericValue(tempArray[tempArray.length-1]) + (Character.getNumericValue(tempArray[tempArray.length-2])*10);
        if(amount>0){
            for(int num = inputArray.length-1; num >= 0 ;num--){
                for(int num2 = alphabet.length-1; num2 >= 0 ;num2--){
                    if(inputArray[num] == alphabet[num2]){
                        char outputChar = ' ';
                        if((num2 - amount) >= 0 ){
                            outputChar = alphabet[num2 - amount];
                        }else{
                            outputChar = alphabet[num2 - amount + 26];
                        }
                        outputArray[num] = outputChar;
                        break;
                    }
                }
            }
        }else{
            for(int num = 0; num < outputArray.length;num++){
                outputArray[num] = inputArray[num];
            }
        }
        String output = "";
        for(int num = 0; num < outputArray.length;num++){
            output += outputArray[num];
        }
        output += amount;
        return output;
    }

    private String decryptSubtitute(String input) {
        char[] tempArray = input.toCharArray();
        char[] myArray = new char[tempArray.length-1];
        for(int num = 0; num < tempArray.length-1;num++){
            myArray[num] = tempArray[num];
        }
        int amount =  Character.getNumericValue(tempArray[tempArray.length-1]);
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
        for(int num2 = myArray.length; num2 > 0 ;num2--){
            char placeholder1 = ' ';
            char placeholder2 = ' ';
            for(int num = myArray.length; num > 0 ;num--){
                if(num > 1 && num < 11){
                    if(num%2 == 1){
                        placeholder1 = myArray[num-1];
                        placeholder2 = myArray[num];
                        myArray[num] = placeholder1;
                        myArray[num-1] = placeholder2;
                    }
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
        for(int num = myArray.length-1; num >= 0 ;num--){
            placeholder1 = myArray[num];
            if(num > 0){
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
