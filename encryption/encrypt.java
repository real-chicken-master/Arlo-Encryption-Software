import java.util.Scanner;

/**
 * Write a description of class encrypt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class encrypt
{ 
    /**
     * Constructor for objects of class encrypt
     */
    public encrypt()
    {
        Scanner kb;
        kb = new Scanner(System.in);
        String input = kb.nextLine();
        String temp = encrypt(input);
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
        System.out.println(output);

        output = encryptSwap(output);
        System.out.println(output);

        output = encryptRotate(output); 
        System.out.println(output);

        output = encryptSubtitute(output);
        System.out.println(output);

        System.out.println(output);
        return output;
    }

    private int[] StringToInt(String input){
        char[] myArray = input.toCharArray();
        int[] intArray = new int[myArray.length];
        for(int num = 0; num < myArray.length;num++){
            intArray[num] = (int)myArray[num];
        }
        return intArray;
    }

    private String encryptSubtitute(String input) {  
        int amount = (int)(Math.random()*10);
        char[] myArray = input.toCharArray();
        for(int num = 0; num < myArray.length;num++){
            myArray[num] -= amount;
        }
        String output = "";   
        for(int num = 0; num < myArray.length;num++){
            output += myArray[num];
        }
        output += (char)amount;
        return output;
    }

    private String encryptSwap(String input) {
        char[] myArray = input.toCharArray();
        char placeholder1 = ' ';
        char placeholder2 = ' ';
        char char1 = myArray[0];
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
