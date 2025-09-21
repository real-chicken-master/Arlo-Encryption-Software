import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    public test()  throws FileNotFoundException {
        Scanner reader = new Scanner( new File("numbers.txt"));
        System.out.println(reader.nextInt());
    }
}
