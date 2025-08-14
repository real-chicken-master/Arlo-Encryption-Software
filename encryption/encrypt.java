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

    public String encrypt(String input)
    {
        String output = input.toLowerCase();

        output = encrypt2d(output);

        output = encryptCaesar(output);

        output = encryptSwap(output);

        output = encryptRotate(output); 

        output = encryptSubtitute(output);

        return output;
    }

    private String encrypt2d(String input){
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

    private String encryptCaesar(String input) {
        int amount1 = (int)(Math.random()*7-1);
        int amount10 = (int)(Math.random()*3-1);
        int amount = amount1 + (amount10*10);
        char[] inputArray = input.toCharArray();
        char[] outputArray = new char[inputArray.length];
        for(int num = 0; num < inputArray.length;num++){
            for(int num2 = 0; num2 < alphabet.length;num2++){
                if(inputArray[num] !=  ' '){
                    if(inputArray[num] == alphabet[num2]){
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
            output += outputArray[num];
        }
        output += amount10;
        output += amount1;
        return output;
    }

    private String encryptSubtitute(String input) {  
        int amount = (int)(Math.random()*10-1);
        char[] myArray = input.toCharArray();
        for(int num = 0; num < myArray.length;num++){
            if(myArray[num] !=  ' '){
                myArray[num] -= amount;
            }
            if(((int)myArray[num]) == 0){
                myArray[num] = ' ';
            }
        }
        String output = "";   
        for(int num = 0; num < myArray.length;num++){
            output += myArray[num];
        }
        output += amount;
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
}
