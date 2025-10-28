import java.util.*;
import java.awt.Color;
import java.io.*;
/**
 * Write a description of class hashString here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class hashString
{
    /**
     * Constructor for objects of class hashString
     */
    public static String hashString(String input)
    {
        String output = input;
        String key = get_hash_key();
        output = hash(output,key);
        return output;
    }

    private static String hash(String input, String key){
        String output = "";
        char[] array = input.toCharArray();
        char[] keyarray = key.toCharArray();
        for(int charnum =0; charnum < array.length ;charnum++){
            int num = 0;
            for(int keynum = 0; keynum < keyarray.length; keynum++){
                num ++;
                if(num == 2){
                    num = 0;
                }
                switch(num){
                    case 0:
                        {   
                            array[charnum] = (char)(array[charnum] + keyarray[keynum]);
                        }
                    case 1:
                        {   
                            array[charnum] = (char)(array[charnum] - keyarray[keynum]);
                        }
                }
            }
            output += array[charnum];
        }
        
        return output;
    }

    private static String get_hash_key(){
        Scanner reader;
        UUID randomUuid = UUID.randomUUID();
        String text = randomUuid.toString();
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