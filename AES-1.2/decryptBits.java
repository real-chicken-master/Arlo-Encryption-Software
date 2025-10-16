
/**
 * Write a description of class decryptBits here.
 *
 * @author (Arlo Kennedy)
 * @version (1.2)
 */
public class decryptBits
{
    public static String decryptBits(String[] input)
    {
        String key = input[1];
        String output = input[0];
        output = decryptInvert(output, key.toCharArray());
        output = decrypt2dArray(output, key.toCharArray());
        return output;
    }

    private static String decryptInvert(String input,char[] key){
        String output = input;
        char[] temparray = output.toCharArray(); 
        int num = 12;
        for(int tempnum = 0; tempnum < temparray.length; tempnum++){
            if(key[num]=='1'){
                if(temparray[tempnum] == '0'){
                    temparray[tempnum] = '1';
                }else{
                    temparray[tempnum] = '0';
                }

            }
            num++;
            if(num >= 18){
                num = 12;
            }
        }
        output = "";
        for(int tempnum = 0; tempnum < temparray.length; tempnum ++){
            output += temparray[tempnum];
        }
        return output;
    }

    private static String decrypt2dArray(String input,char[] key){
        String output = input;
        int xLength = (int)Math.ceil(Math.sqrt(input.length()));
        int yLength = xLength;
        char[] tempArray = output.toCharArray();
        char[][] tempArray2 = new char[xLength][yLength];
        int num = 0;
        for(int x = 0; x < xLength; x++){
            for(int y = 0; y < yLength; y++){
                if(num < tempArray.length){
                    tempArray2[x][y]=tempArray[num];
                }
                num++;
            }
        }
        int num2 = 0;
        for(num = 0; num < 12; num += 2){
            char[][] tempArray3 = tempArray2;
            num2 += Character.getNumericValue(key[num+1]);
            while(num2 >= xLength){
                num2 -= xLength;
            }
            tempArray3[num2] = Xrotate(tempArray2[num2],Character.getNumericValue(key[num]));
            tempArray2[num2] = tempArray3[num2];
        }
        output = "";
        for(int x = 0; x < xLength; x++){
            for(int y = 0; y < yLength; y++){
                if(tempArray2[x][y] == '1' || tempArray2[x][y] == '0'){
                    output += tempArray2[x][y];
                }
            }
        } 
        return output;
    }

    private static char[] Xrotate(char[] input, int num){
        char[] output = new char[input.length];
        for(int num2 = 0; num2 < input.length; num2++){
            int modifier = 0;
            while(num2-num+modifier < 0){
                modifier += input.length;
            }
            output[num2] = input[num2-num+modifier];
        }
        return output;
    }

}
