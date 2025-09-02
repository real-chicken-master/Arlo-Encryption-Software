import java.util.Scanner;

/**
 * has all the functions for my encryption.
 *
 * @author (Arlo Kennedy)
 * @version (0.1)
 */
public class encrypt
{ 

    private char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private char[] Symbols = {'¦','©','®','°','҂','؎','؏','۞','۩','⏻','࿊','࿋','࿌','⇆','⌀','⇯','⌚','⌛','⌘','⌬','⌨','⌹','⍟','⍝','⎆','⏰'};
    private int amount = 0;
    public String encrypt(String input)
    {
        String output = input.toLowerCase();

        output = encryptKey(output);

        output = encryptSwap(output);

        output = encryptRotate(output);

        return output;
    }

    private String encryptKey(String input){
        String output;
        System.out.println("your key is");
        char[] key = randomKey();
        System.out.println(key);
        char[] key1 = new char[(key.length/2)];
        char[] key2 = new char[(key.length/2)];
        for(int num =0; num < key1.length; num++){
            key1[num] = key[num];
            key2[num] = key[num+key1.length];
        }
        char[] list1 = new char[26];
        for(int num =0; num < list1.length; num++){
            list1[num] = key1[num];
        }
        char[] list2 = new char[26];
        for(int num =0; num < list2.length; num++){
            list2[num] = key2[num];
        }
        output = encryptCaesar(input, key1, alphabet, list1);
        output = encryptCaesar(output, key2, alphabet ,list2);
        return output;
    }

    private String encryptCaesar(String input, char[] key, char[] inList, char[] outList) {
        char[] inputArray = input.toCharArray();
        char[] outputArray = new char[inputArray.length];
        int amount = Character.getNumericValue(key[key.length-1]) + (Character.getNumericValue(key[key.length-2])*10);
        for(int num = 0; num < inputArray.length;num++){
            boolean out = false;
            for(int num2 = 0; num2 < outList.length;num2++){
                if(inputArray[num] !=  ' '){
                    if(inputArray[num] == inList[num2]){
                        out = true;
                        char outputChar = ' ';
                        if((num2 + amount) < 26 ){
                            outputChar = outList[num2 + amount];
                        }else{
                            outputChar = outList[num2 + amount - 26];
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
        String output = "";
        for(int num = 0; num < outputArray.length;num++){
            if(((int)outputArray[num]) == 0){
                outputArray[num] = ' ';       
            }
        }
        for(int num = 0; num < outputArray.length;num++){
            output += outputArray[num];
        }
        return output;
    }

    private String encryptSwap(String input) {
        char[] myArray = input.toCharArray();
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

    private String encryptRotate(String input)
    {
        char[] myArray = input.toCharArray();
        char placeholder1 = ' ';
        char placeholder2 = ' ';
        char char1 = myArray[0];
        for(int num = 0; num < myArray.length;num++){
            placeholder1 = myArray[num];
            if(num < myArray.length-1){
                placeholder2 = myArray[num+1];
            }else{
                placeholder2 = char1;
            }
            myArray[num] = placeholder2;
        }
        String output = "";
        for(int num = 0; num < myArray.length;num++){
            output += myArray[num];
        }
        return output;
    }

    private char[] randomKey(){
        char[] tempKey = new char[alphabet.length + Symbols.length + 4];
        for(int num = 0; num < alphabet.length; num++){
            boolean blockPlaced = false;
            while(!blockPlaced){
                boolean charIsAvalible = true;
                int temp = (int)(Math.random()*94)+32;
                char Char = Character.toLowerCase((char) temp);
                for(int num2 = 0; num2 < tempKey.length;num2 ++){
                    if(tempKey[num2] == Char){
                        charIsAvalible = false;
                    }
                }
                if(charIsAvalible){
                    tempKey[num] = Char;
                    blockPlaced = true;
                }
            }
        }
        amount = (int)(Math.random()*26);
        char[] amountArray;
        amountArray = (String.valueOf(amount)).toCharArray();
        if(amount < 10){
            tempKey[alphabet.length] = '0';
            tempKey[alphabet.length+1] = amountArray[0];
        }else{
            tempKey[alphabet.length] = amountArray[0];
            tempKey[alphabet.length+1] = amountArray[1];
        }

        for(int num = alphabet.length+2 ; num < (alphabet.length + Symbols.length + 2); num++){
            boolean blockPlaced = false;
            while(!blockPlaced){
                boolean charIsAvalible = true;
                int temp = (int)(Math.random()*94)+32;
                char Char = Character.toLowerCase((char) temp);
                for(int num2 = 0; num2 < tempKey.length;num2 ++){
                    if(tempKey[num2] == Char){
                        charIsAvalible = false;
                    }
                }
                if(charIsAvalible){
                    tempKey[num] = Char;
                    blockPlaced = true;
                }
            }
        }
        amount = (int)(Math.random()*26);
        amountArray =  (String.valueOf(amount)).toCharArray();
        if(amount < 10){
            tempKey[(alphabet.length + Symbols.length + 2)] = '0';
            tempKey[(alphabet.length + Symbols.length + 2)+1] = amountArray[0];
        }else{
            tempKey[(alphabet.length + Symbols.length + 2)] = amountArray[0];
            tempKey[(alphabet.length + Symbols.length + 2)+1] = amountArray[1];
        }
        char[] key = tempKey;
        return key;
    }
}
