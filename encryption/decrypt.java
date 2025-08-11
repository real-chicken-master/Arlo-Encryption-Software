
/**
 * Write a description of class decrypt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class decrypt extends encrypt
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class decrypt
     */
    public decrypt()
    {
        // initialise instance variables
        String temp = decrypt(test);
    }

    private String decrypt(byte[] input)
    {
        String output = decryptByte(input);
        System.out.println(output);
        output = decryptRotate(output);
        System.out.println(output);
        output = decryptSwap(output);
        System.out.println(output);
        return output;
    }

    private String decryptByte(byte[] input) {
        String output = "";
        for(int num = 0; num < input.length;num++){
            output += (char)input[num];
        }
        return output;
    }

    private String decryptSwap(String input) {
        char[] myArray = input.toCharArray();
        char placeholder1 = ' ';
        char placeholder2 = ' ';
        for(int num = myArray.length-1; num > 0 ;num--){
            if(num > 1){
                if(num%2 == 1){
                    placeholder1 = myArray[num-1];
                    placeholder2 = myArray[num];
                    myArray[num] = placeholder1;
                    myArray[num-1] = placeholder2;
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
        for(int num = myArray.length-1; num > 0 ;num--){
            placeholder1 = myArray[num];
            if(num > 1){
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
