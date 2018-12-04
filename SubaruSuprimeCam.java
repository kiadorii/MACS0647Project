import java.io.*;
import java.util.*;

public class SubaruSuprimeCam{
    public static void main(String[] args)throws FileNotFoundException{
        
        //SkyCatalogs cat = new SkyCatalogs();
        Scanner in = new Scanner(new File(args[0]));
        
        int arrLength = 0;
        while(!in.hasNextInt(8)){
            arrLength++;
        }
        System.out.println(arrLength);
            in.close();
    }
}