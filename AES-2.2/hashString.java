import java.util.*;
import java.awt.Color;
import java.io.*;
/**
 * Write a description of class hashString here.
 *
 * @author (Arlo Kennedy)
 * @version (2.1)
 */
public class hashString
{
    /**
     * Constructor for objects of class hashString
     */
    public static String hashString(String input, int padding)
    {
        String output = input;
        String key = get_hash_key();
        output = hash(output,key,256);
        output = rotate(output,key);
        output = addPadding(output,padding);
        return output;
    }

    private static String addPadding(String input, int padding){
        String output = input;
        while(output.length() > padding){
            char[] tempArray = output.toCharArray();
            int ignoreChar = output.length()/3;
            String temp = "";
            for(int num = 0; num < tempArray.length; num ++){
                if(num != ignoreChar){
                    temp += tempArray[num];
                }
            }
            output = temp;
        }
        while(output.length() < padding){
            char[] tempArray = output.toCharArray();
            int addChar = output.length()/3;
            int charPos = output.length()/2;
            String temp = "";
            for(int num = 0; num < tempArray.length; num ++){
                temp += tempArray[num];
                if(num == charPos){
                    temp += tempArray[addChar];
                }
            }
            output = temp;
        }
        return output;
    }

    private static String rotate(String input, String key){
        String output = "";
        char[] inputarray = input.toCharArray();
        char[] outputArray = new char[inputarray.length];
        char[] keyArray = key.toCharArray();
        int modifer = 1;
        for(int num = 0; num < keyArray.length;num++){
            modifer = (Character.getNumericValue(keyArray[num]) * Character.getNumericValue(inputarray[num])) % inputarray.length;
            while(modifer > inputarray.length){
                modifer -= inputarray.length;
            }
            if(modifer > 0){
                break;
            }
        }
        for(int num = 0; num < inputarray.length;num++){
            if(num+modifer < inputarray.length){
                outputArray[num] = inputarray[num+modifer];
            }else{
                outputArray[num] = inputarray[num+modifer-inputarray.length];
            }
            output += outputArray[num];
        }
        return output;
    }

    private static String hash(String input, String key,int max){
        String output = "";
        char[] array = input.toCharArray();
        char[] keyarray = key.toCharArray();
        for(int charnum =0; charnum < array.length ;charnum++){
            int num = (int)charnum%4;
            for(int keynum = 0; keynum < keyarray.length; keynum++){
                num++;
                if(num>6){
                    num = 1;
                }
                switch(num){
                    case 1:
                        {
                            array[charnum] = (char)(array[charnum] + keyarray[keynum]);
                        }
                    case 2:
                        {
                            array[charnum] = (char)(array[charnum] - keyarray[keynum]);
                        }
                    case 3:
                        {
                            if(keyarray[keynum]!=0)
                                array[charnum] = (char)(array[charnum] * keyarray[keynum]);
                        }
                    case 4:
                        {   
                            if(keyarray[keynum]!=0)
                                array[charnum] = (char)(array[charnum] / keyarray[keynum]);
                        }
                    case 5:
                        {   
                            if(keyarray[keynum]!=0)
                                array[charnum] = (char)(array[charnum] % keyarray[keynum]);
                        }
                    case 6:
                        {   
                            if(keyarray[keynum]!=0)
                                array[charnum] = (char)(array[charnum] ^ keyarray[keynum]);
                        }
                    case 7:
                        {   
                            if(keyarray[keynum]!=0)
                                array[charnum] = (char)(Math.min(array[charnum],  keyarray[keynum]));
                        }
                    case 8:
                        {   
                            if(keyarray[keynum]!=0)
                                array[charnum] = (char)Math.floor(Math.PI * Math.min(array[charnum],  keyarray[keynum]));
                        }
                }
            }
            while((int)array[charnum] > max){
                array[charnum]-= max;
            }
            while((int)array[charnum] <= 0){
                array[charnum]+= max;
            }
            output += (int)array[charnum];
        }

        return output;
    }

    private static String get_hash_key(){
        Scanner reader;
        String text = "";
        for(int num = 0; num < 255; num++){
            text += (int)(Math.random()*9);
        }

        try 
        {
            File myObj = new File("hashid.txt");
            if(myObj.createNewFile()){
                FileWriter myWriter = new FileWriter("hashid.txt");
                myWriter.write(text);
                myWriter.close(); 
            }else{
                Scanner myReader = new Scanner(myObj);
                text = myReader.nextLine();
            }
        }catch(Exception e){}
        try{
            reader = new Scanner( new File("hashid.txt"));
            text = reader.nextLine();
        }catch(Exception e){}
        text = text.replace("-", "");
        return text;
    }

}