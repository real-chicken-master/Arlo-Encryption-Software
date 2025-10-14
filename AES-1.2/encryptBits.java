
/**
 * Write a description of class encryptBits here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class encryptBits
{
    public static String[] encryptBits(String input)
    {
        String key = randomKey();
        String output = input;
        System.out.println(encrypt2dArray(output, key.toCharArray()));
        String[] outputArray = {output, key};
        return outputArray;
    }

    private static String encrypt2dArray(String input,char[] key){
        String output = input;
        int xLength = (int)Math.ceil(Math.sqrt(input.length()));
        int yLength = xLength;
        char[] tempArray = output.toCharArray();
        char[][] tempArray2 = new char[xLength][yLength];
        int num = 0;
        System.out.println(tempArray);
        System.out.println(rotate(tempArray,9));
        for(int x = 0; x < xLength; x++){
            for(int y = 0; y < yLength; y++){
                if(num < tempArray.length){
                    tempArray2[x][y]=tempArray[num];
                }
                num++;
            }
        }
        for(num = 0; num < (key.length/2); num++){
            char[][] tempArray3 = new char[xLength][yLength];
            int num2 = 0;
            
            tempArray2 = tempArray3;
        }
        return output;
    }
    
    private static char[] rotate(char[] input, int num){
        char[] output = new char[input.length];
        for(int num2 = 0; num2 < input.length; num2++){
            int modifier = 0;
            while(num2+num-modifier >= input.length){
                modifier += input.length;
            }
            output[num2] = input[num2+num-modifier];
        }
        return output;
    }
    
    private static String randomKey(){
        String output = "";
        int num = 0;
        for(int x = 0; x < 12; x++){
            num = (int)(Math.random()*9);
            output += num;
        }
        return output;
    }

}