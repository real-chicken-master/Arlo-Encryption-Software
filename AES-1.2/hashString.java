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
            int num = (int)charnum%4;
            System.out.println((int)array[charnum]);
            for(int keynum = 0; keynum < keyarray.length; keynum++){
                num++;
                if(num>4){
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
                }
            }
            while((int)array[charnum] > 256){
                array[charnum]-= 256;
            }
            while((int)array[charnum] <= 0){
                array[charnum]+= 256;
            }
            output += array[charnum];
            System.out.println((int)array[charnum]);
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