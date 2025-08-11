
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
        System.out.println(temp);
    }

    private String decrypt(String input)
    {
        String output = encryptChar(input);
        // output = encryptRotate(output);
        // output = encryptSwap(output);
        return output;
    }

    private String encryptChar(String input) {
        char[] tempArray = input.toCharArray();
        int[] myArray = {1,1};
        for(int num = 0; num < myArray.length;num++){
          
        }
        char placeholder1 = ' ';
        String output = "";
        for(int num = 0; num < myArray.length;num++){
            output += (char)myArray[num];
        }
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
