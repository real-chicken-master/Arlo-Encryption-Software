
/**
 * Write a description of class encrypt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class encrypt
{
    public  String test = encrypt("this is a test");
    /**
     * Constructor for objects of class encrypt
     */
    public encrypt()
    {
        // initialise instance variables
        System.out.println(test);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private String encrypt(String input)
    {
        String output = encryptSwap(input);
        output = encryptRotate(output);
        output = encryptNumber(output);
        return output;
    }

    private String encryptNumber(String input) {
        char[] myArray = input.toCharArray();
        char placeholder1 = ' ';
        String output = "";
        for(int num = 0; num < myArray.length;num++){
            output += (int)myArray[num];
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
