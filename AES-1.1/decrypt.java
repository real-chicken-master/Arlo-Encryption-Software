import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;

/**
 * contains everything needed for decryption.
 *
 * @author (Arlo Kennedy)
 * @version (1.1)
 */
public class decrypt
{
    // instance variables - replace the example below with your own

    private static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static char[] Symbols = {'¦','©','®','°','҂','؎','؏','۞','۩','⏻','࿊','࿋','࿌','⇆','⌀','⇯','⌚','⌛','⌘','⌬','⌨','⌹','⍟','⍝','⎆','⏰','⎚','␥','╳','☢'};
    static char[] key;

    public static String decrypt(String[] input)
    {   
        key = input[1].toCharArray();
        String output = input[0].toLowerCase();

        output = decryptDoubles(output);

        output = decryptRotate(output);

        output = decryptSwap(output);

        output = decrypt2dArray(output);

        output = decryptKey(output);

        return output;
    }

    private static String decryptDoubles(String input)
    {   
        char[] array = input.toCharArray();
        String output = "";
        for(int num = 0; num < array.length;num ++)
        {
            if(array[num] == key[key.length-1]){
                array[num] = array[num-1];
            }
            if(array[num] == key[key.length-2]){
                array[num] = array[num-1];
            }
            output += array[num];
        }
        return output;
    }

    private static String decrypt2dArray(String input){
        String output = input;
        char[] arrayKey = new char[(key.length-2)/3];
        for(int num = 0; num < arrayKey.length; num++){
            arrayKey[num] = key[num + 56];
        }
        output = input;
        char[] inputArray = input.toCharArray();
        int xLength = (int)Math.sqrt(input.length());
        int yLength = (int)Math.sqrt(input.length());
        char[][] array = new char [xLength][yLength];
        int num = 0;
        for(int numx = 0; numx < xLength; numx++){
            for(int numy = 0; numy < yLength; numy++){
                array[numx][numy] = inputArray[num];
                num++;
            }
        }

        for(int numx = 0; numx < xLength; numx++){
            for(int numy = 0; numy < yLength; numy++){
                for(num = 0; num < arrayKey.length; num++){
                    if(array[numx][numy] == arrayKey[num]){
                        array[numx][numy] = 0;
                    }
                }
            }
        }
        output = "";
        for(int numx = 0; numx < xLength; numx++){
            for(int numy = 0; numy < yLength; numy++){
                if(array[numx][numy] != 0){
                    output += array[numx][numy];
                }
            }
        }
        return output;
    }

    private static String decryptKey(String input)
    {
        char[] key1 = new char[((key.length-2)/3)];
        char[] key2 = new char[((key.length-2)/3)];
        for(int num =0; num < key1.length; num++){
            key1[num] = key[num];
            key2[num] = key[num+key1.length];
        }
        char[] list1 = new char[26];
        for(int num = 0; num < list1.length; num++){
            list1[num] = key1[num];
        }
        char[] list2 = new char[26];
        for(int num = 0; num < list2.length; num++){
            list2[num] = key2[num];
        }
        String output;
        output = decryptCaesar(input, key2, list2, list1);
        output = decryptCaesar(output, key1, list1, alphabet);
        return output;
    }

    private static String decryptCaesar(String input, char[] key, char[] inList , char[] outList) {
        char[] tempArray = input.toCharArray();
        char[] inputArray = new char[tempArray.length];
        for(int num = 0; num < inputArray.length;num++){
            if(((int)inputArray[num]) == 0){
                inputArray[num] = ' ';       
            }
        }
        for(int num = 0; num < tempArray.length;num++){
            inputArray[num] = tempArray[num];
        }
        char[] outputArray = new char[inputArray.length];
        int amount = Character.getNumericValue(key[key.length-1]) + (Character.getNumericValue(key[key.length-2])*10);
        for(int num = inputArray.length-1; num >= 0 ;num--){
            boolean out = false;
            for(int num2 = inList.length-1; num2 >= 0 ;num2--){
                if(inputArray[num] !=  ' '){
                    if(inputArray[num] == inList[num2]){
                        out = true;
                        char outputChar = ' ';
                        if((num2 - amount) >= 0 ){
                            outputChar = outList[num2 - amount];
                        }else{
                            outputChar = outList[num2 - amount + 26];
                        }
                        outputArray[num] = outputChar;
                        break;
                    }
                }
            }
            if(!out){
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

    private static String decryptSwap(String input) {
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

    private static String decryptRotate(String input)
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
