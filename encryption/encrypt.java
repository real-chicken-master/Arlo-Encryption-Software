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
    private char[] Symbols = {'¦','©','®','°','҂','؎','؏','۞','۩','۽','࿊','࿋','࿌','⇆','⌀','⇯','⌚','⌛','⌘','⌬','⌨','⌹','⍟','⍝','⎆','⏰'};
    private int amount = 0;
    public String encrypt(String input)
    {
        String output = input.toLowerCase();

        output = encryptKey(output);
        System.out.println(output);

        output = encryptSwap(output);
        System.out.println(output);

        output = encryptRotate(output); 
        System.out.println(output);

        return output;
    }
    
    private String encryptKey(String input){
        String output;
        char[] key = randomKey();
        char[] key1 = new char[(key.length/2)];
        char[] key2 = new char[(key.length/2)];
        for(int num =0; num < key1.length; num++){
            key1[num] = key[num];
            key2[num] = key[num+key1.length];
        }
        output = encryptCaesar(input, key1, alphabet);
        output = encryptCaesar(output, key2, Symbols);
        return output;
    }
    
    private String encryptCaesar(String input, char[] key, char[] List) {
        System.out.println("your key is");
        char[] tempList = List;
        for(int num = 0; num < key.length; num++){
            for(int num2 = 0; num2 < List.length; num2++){
                if(key[num] == List[num2]){
                    char char1 = key[num];
                    char char2 = tempList[num];
                    tempList[num] = char1;
                    tempList[num2] = char2;
                }
            }
        }
        alphabet = tempList;
        char[] inputArray = input.toCharArray();
        char[] outputArray = new char[inputArray.length];
        for(int num = 0; num < inputArray.length;num++){
            for(int num2 = 0; num2 < List.length;num2++){
                if(inputArray[num] !=  ' '){
                    if(inputArray[num] == List[num2]){
                        char outputChar = ' ';
                        if((num2 + amount) < 26 ){
                            outputChar = alphabet[num2 + amount];
                        }else{
                            outputChar = alphabet[num2 + amount - 26];
                        }
                        outputArray[num] = outputChar;
                        break;
                    }
                }
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
        char[] tempKey = new char[alphabet.length+2];
        for(int num = 0; num < tempKey.length-2; num++){
            boolean blockPlaced = false;
            while(!blockPlaced){
                boolean charIsAvalible = true;
                int temp = (int)(Math.random()*26);
                for(int num2 = 0; num2 < tempKey.length-2;num2 ++){
                    if(tempKey[num2] == alphabet[temp]){
                        charIsAvalible = false;
                    }
                }
                if(charIsAvalible){
                    tempKey[num] = alphabet[temp];
                    blockPlaced = true;
                }
            }
            System.out.print(tempKey[num]);
        }
        amount = (int)(Math.random()*26);
        if(amount<10){
        System.out.print("0");
        }
        System.out.println(amount);
        char[] key = tempKey;
        return key;
    }
}
