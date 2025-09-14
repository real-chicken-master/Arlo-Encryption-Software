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
    private char[] Symbols = {'¦','©','®','°','҂','؎','؏','۞','۩','⏻','࿊','࿋','࿌','⇆','⌀','⇯','⌚','⌛','⌘','⌬','⌨','⌹','⍟','⍝','⎆','⏰','⎚','␥','╳','☢'};
    private int amount = 0;
    private char[] key;

    public String encrypt(String input)
    {   
        char[] key = randomKey();

        String output = input.toLowerCase();

        output = encryptKey(output);
        System.out.println(output);
        output = encrypt2dArray(output);
        System.out.println(output);
        output = encryptSwap(output);

        output = encryptRotate(output);

        //output = encryptDoubles(output);

        return output;
    }

    private String encryptDoubles(String input)
    {
        String output = input;
        char[] outputArray = output.toCharArray();
        char previousChar = ' ';
        for(int num = 0;num < outputArray.length; num++)
        {   
            if(outputArray[num] == previousChar)
            {
                int temp = (int)(Math.random()*2);
                outputArray[num] = key[key.length-1-temp];
            }
            previousChar = outputArray[num];
        }
        output = "";
        for(int num = 0; num < outputArray.length;num ++)
        {
            output += outputArray[num];
        }
        return output;
    }

    private String encrypt2dArray(String input)
    {
        char[] arrayKey = new char[(key.length-2)/3];
        for(int num = 0; num < arrayKey.length; num++)
        {
            arrayKey[num] = key[num + 56];
        }
        String output = input;
        char[] inputArray = input.toCharArray();
        int charsLeft = input.length();
        int loopLeft = input.length()*2;
        int xLength = (int)Math.ceil(Math.sqrt(loopLeft));
        int yLength = (int)Math.ceil(Math.sqrt(loopLeft));
        char[][] array = new char [xLength][yLength];
        for(int numx = 0; numx < xLength; numx++){
            for(int numy = 0; numy < yLength; numy++){
                if((input.length()-charsLeft) < input.length()){
                    if(charsLeft < loopLeft){
                        int temp = (int)(Math.random()*3);            
                        if(temp == 0){
                            array[numx][numy] = inputArray[(input.length()-charsLeft)];
                            charsLeft--;
                        }else{
                            array[numx][numy] = arrayKey[(int)(Math.random()*arrayKey.length)];
                        }
                    }else{
                        array[numx][numy] = inputArray[(input.length()-charsLeft)];
                        charsLeft--;
                    }
                }else{
                    array[numx][numy] = arrayKey[(int)(Math.random()*arrayKey.length)];
                }
                loopLeft--;
            }
        }
        output = "";
        for(int numx = 0; numx < xLength; numx++){
            for(int numy = 0; numy < yLength; numy++){
                output += array[numx][numy];
            }
        }
        return output;
    }

    private String encryptKey(String input){
        String output = "";
        System.out.println("your key is");
        System.out.println(key);
        char[] key1 = new char[((key.length-2)/3)];
        char[] key2 = new char[((key.length-2)/3)];
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
        output = encryptCaesar(input, key1, alphabet, list1);;
        output = encryptCaesar(output, key2, list1 ,list2);
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
        char[] tempKey = new char[26 + 26 + 26 + 10];
        for(int num = 0; num < 26; num++){
            boolean blockPlaced = false;
            while(!blockPlaced){
                boolean charIsAvalible = true;
                int temp = (int)(Math.random()*110)+32;
                char Char = ' ';
                if(temp < (94+32)){
                    Char = Character.toLowerCase((char) temp);
                }else{
                    Char = Symbols[(int)(Math.random()*Symbols.length)];
                }
                if(Char == ' '){
                    Char = Symbols[(int)(Math.random()*Symbols.length)];
                }
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
            tempKey[26] = '0';
            tempKey[26+1] = amountArray[0];
        }else{
            tempKey[26] = amountArray[0];
            tempKey[26+1] = amountArray[1];
        }

        for(int num = 26+2 ; num < (26 + 26 + 2); num++){
            boolean blockPlaced = false;
            while(!blockPlaced){
                boolean charIsAvalible = true;
                int temp = (int)(Math.random()*110)+32;
                char Char = ' ';
                if(temp < (94+32)){
                    Char = Character.toLowerCase((char) temp);
                }else{
                    Char = Symbols[(int)(Math.random()*Symbols.length)];
                }
                if(Char == ' '){
                    Char = Symbols[(int)(Math.random()*Symbols.length)];
                }
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
            tempKey[(26 + 26 + 2)] = '0';
            tempKey[(26 + 26 + 2)+1] = amountArray[0];
        }else{
            tempKey[(26 + 26 + 2)] = amountArray[0];
            tempKey[(26 + 26 + 2)+1] = amountArray[1];
        }

        for(int num = 26 + 26 + 4 ; num < (26 + 26 + 6 + 26 ); num++){
            boolean blockPlaced = false;
            while(!blockPlaced){
                boolean charIsAvalible = true;
                int temp = (int)(Math.random()*110)+32;
                char Char = ' ';
                if(temp < (94+32)){
                    Char = Character.toLowerCase((char) temp);
                }else{
                    Char = Symbols[(int)(Math.random()*Symbols.length)];
                }
                if(Char == ' '){
                    Char = Symbols[(int)(Math.random()*Symbols.length)];
                }
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
        amount = (int)(Math.random()*99);
        amountArray =  (String.valueOf(amount)).toCharArray();
        if(amount < 10){
            tempKey[(26 + 26 + 6 + 26 )] = '0';
            tempKey[(26 + 26 + 6 + 26 )+1] = amountArray[0];
        }else{
            tempKey[(26 + 26 + 6 + 26 )] = amountArray[0];
            tempKey[(26 + 26 + 6 + 26 )+1] = amountArray[1];
        }
        for(int num = tempKey.length-3 ; num < tempKey.length; num++){
            boolean blockPlaced = false;
            while(!blockPlaced){
                boolean charIsAvalible = true;
                int temp = (int)(Math.random()*110)+32;
                char Char = ' ';
                if(temp < (94+32)){
                    Char = Character.toLowerCase((char) temp);
                }else{
                    Char = Symbols[(int)(Math.random()*Symbols.length)];
                }
                if(Char == ' '){
                    Char = Symbols[(int)(Math.random()*Symbols.length)];
                }
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
        key = tempKey;
        return key;
    }
}
