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
    private char[] Symbols = {'¦','©','®','°','҂','؎','؏','۞','۩','۽','࿊','࿋','࿌','⇆','⌀','⇯','⌚','⌛','⌘','⌬','⌨','⌹','⍟','⍝','⎆','⏰'};

    public String decrypt(String input)
    {
        String output = input.toLowerCase();

        output = decryptRotate(output);
        System.out.println(output);

        output = decryptSwap(output);
        System.out.println(output);

        output = decryptKey(output);
        System.out.println(output);

        return output;
    }

    private String decryptKey(String input){
        System.out.println("please enter the key");
        char[] key = getKey();
        char[] key1 = new char[(key.length/2)];
        char[] key2 = new char[(key.length/2)];
        for(int num =0; num < key1.length; num++){
            key1[num] = key[num];
            key2[num] = key[num+key1.length];
        }
        String output;
        output = decryptCaesar(input,key1, alphabet, alphabet);
        System.out.println(output);
        output = decryptCaesar(output,key2, Symbols, alphabet);
        System.out.println(output);
        return "";
    }

    private String decryptCaesar(String input, char[] key, char[] inList, char[] outList) {
        char[] tempList = outList;
        for(int num = 0; num < key.length; num++){
            for(int num2 = 0; num2 < alphabet.length; num2++){
                if(key[num] == alphabet[num2]){
                    char char1 = key[num];
                    char char2 = tempList[num];
                    tempList[num] = char1;
                    tempList[num2] = char2;
                }
            }
        }
        alphabet = outList;
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
        if(amount>0){
            for(int num = inputArray.length-1; num >= 0 ;num--){
                for(int num2 = alphabet.length-1; num2 >= 0 ;num2--){
                    if(inputArray[num] !=  ' '){
                        if(inputArray[num] == inList[num2]){
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

    private char[] getKey(){
        Scanner kb;
        kb = new Scanner(System.in);
        char[] key = (kb.nextLine()).toCharArray();
        return key;
    }
}
