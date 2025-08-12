import java.util.Scanner;

/**
 * Write a description of class encrypt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class encrypt
{ 

    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    /**
     * Constructor for objects of class encrypt
     */
    public encrypt()
    {
        Scanner kb;
        kb = new Scanner(System.in);
        String input = kb.nextLine();
        String temp = encrypt(input);
        System.out.println(temp);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private String encrypt(String input)
    {
        String output = input;

        output = encryptCaesar(output);

        output = encryptSwap(output);

        output = encryptRotate(output); 

        output = encryptSubtitute(output);

        return output;
    }

    private String encryptCaesar(String input) {
        int amount1 = (int)(Math.random()*7-1);
        int amount10 = (int)(Math.random()*3-1);
        int amount = amount1 + (amount10*10);
        System.out.println(amount);
        char[] inputArray = input.toCharArray();
        char[] outputArray = new char[inputArray.length];
        for(int num = 0; num < inputArray.length;num++){
            for(int num2 = 0; num2 < alphabet.length;num2++){
                if(inputArray[num] == alphabet[num2]){
                    char outputChar = ' ';
                    if((num + amount) < 26 ){
                        outputChar = alphabet[num + amount];
                    }else{
                        outputChar = alphabet[num + amount - 26];
                    }
                    outputArray[num] = outputChar;
                    break;
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
            myArray[num] -= amount;
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
