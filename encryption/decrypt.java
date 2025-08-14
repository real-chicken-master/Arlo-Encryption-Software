import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;

/**
 * has all the functions for my decryption.
 *
 * @author (Arlo Kennedy)
 * @version (0.1)
 */
public class decrypt extends encrypt
{
    // instance variables - replace the example below with your own

    private char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public String decrypt(String input)
    {
        String output = input.toLowerCase();

        output = decryptSubtitute(output);

        output = decryptRotate(output);

        output = decryptSwap(output);

        output = decryptCaesar(output);

        output = decrypt2d(output);

        return output;
    }

    private String decrypt2d(String input){
        char[] inputArray = input.toCharArray();
        int outputx = (int)Math.ceil(Math.sqrt(inputArray.length));
        int outputy =  outputx;
        char[][] outputArray = new char[outputx][outputy];
        int num = 0;
        for(int numx = 0; numx < outputx;numx++){
            for(int numy = 0; numy < outputy;numy++){
                if(num < inputArray.length){
                    outputArray[numx][numy] = inputArray[num];
                    num++;
                }
            }
        }
        String output = "";
        num = 0;
        for(int numx = 0; numx < outputx;numx++){
            for(int numy = 0; numy < outputy;numy++){
                if(num < inputArray.length){
                    if(((int)outputArray[numy][numx]) != 0){
                        output += outputArray[numy][numx];
                        num++;
                    }
                }
            }
        }
        return output;
    }

    private String decryptCaesar(String input) {
        char[] tempArray = input.toCharArray();
        char[] inputArray = new char[tempArray.length-2];
        for(int num = 0; num < inputArray.length;num++){
            if(((int)inputArray[num]) == 0){
                inputArray[num] = ' ';       
            }
        }
        for(int num = 0; num < tempArray.length-2;num++){
            inputArray[num] = tempArray[num];
        }
        char[] outputArray = new char[inputArray.length];
        int amount = Character.getNumericValue(tempArray[tempArray.length-1]) + (Character.getNumericValue(tempArray[tempArray.length-2])*10);
        if(amount>0){
            for(int num = inputArray.length-1; num >= 0 ;num--){
                for(int num2 = alphabet.length-1; num2 >= 0 ;num2--){
                    if(inputArray[num] !=  ' '){
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
            }
        }else{
            for(int num = 0; num < outputArray.length;num++){
                outputArray[num] = inputArray[num];
            }
        }
        for(int num = 0; num < outputArray.length;num++){
            if(((int)outputArray[num]) == 0){
                outputArray[num] = ' ';       
            }
        }
        String output = "";
        for(int num = 0; num < outputArray.length;num++){
            output += outputArray[num];
        }
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
            if(myArray[num] !=  ' '){
                myArray[num] += amount;
            }
        }
        String output = "";   
        for(int num = 0; num < myArray.length;num++){
            output += myArray[num];
        }
        return output;
    }

    private String decryptSwap(String input) {
        char[] myArray = input.toCharArray();
        for(int num = 0; num < myArray.length;num++){
            if(((int)myArray[num]) == 0){
                myArray[num] = ' ';       
            }
        }

        for(int num2 = 0; num2 < myArray.length;num2 ++){
            char placeholder1 = ' ';
            char placeholder2 = ' ';
            for(int num = 0; num < myArray.length;num++){
                if(num < myArray.length-1){
                    if(num%2 == 0){
                        placeholder1 = myArray[num+1];
                        placeholder2 = myArray[num];
                        myArray[num] = placeholder1;
                        myArray[num+1] = placeholder2;
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
