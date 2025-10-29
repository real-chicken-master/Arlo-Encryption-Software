
/**
 * Write a description of class encryptBits here.
 *
 * @author (Arlo Kennedy)
 * @version (1.2)
 */
public class encryptBits
{
    public static String[] encryptBits(String input)
    {
        String key = randomKey();
        String output = input;
        output = encrypt2dArray(output, key.toCharArray());
        output = encryptInvert(output, key.toCharArray());
        String[] outputArray = {output, key};
        return outputArray;
    }

    private static String encryptInvert(String input,char[] key){
        String output = input;
        char[] temparray = output.toCharArray(); 
        int num = 12;
        for(int tempnum = 0; tempnum < temparray.length; tempnum ++){
            if(key[num]=='1'){
                if(temparray[tempnum] == '0'){
                    temparray[tempnum] = '1';
                }else if(temparray[tempnum] == '1'){
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

    private static String encrypt2dArray(String input,char[] key){
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
                if(tempArray2[x][y] == '1' || tempArray2[x][y] == '0' || tempArray2[x][y] == ' '){
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
            num = (int)Math.ceil(Math.random()*9);
            output += num;
        }

        for(int x = 0; x < 6; x++){
            num = (int)Math.floor(Math.random()*2);
            output += num;
        }
        return output;
    }

}