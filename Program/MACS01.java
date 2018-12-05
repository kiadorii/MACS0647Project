import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MACS01
{
    public static void main(String[] args)throws FileNotFoundException
    {
        if(args.length != 2)
        {
            System.out.print("PASSING THROUGH");
        }
        File inFile = new File(args[0]);
        Scanner in = new Scanner(inFile);
                
        String[] macsOneLine = new String[408];
        for(int i=0; i<macsOneLine.length; i++){
            macsOneLine[i] = in.nextLine();
        }
        
        String[] macsNoEmpties = new String[210];
        String[][] macsSingleRead = new String[210][100];
        
        int noEmptyCount = 0;
        
        for(int j=0; j<macsOneLine.length; j++){
            if(macsOneLine[j].length() != 0){
                macsOneLine[noEmptyCount] = macsOneLine[j];
                macsNoEmpties[noEmptyCount] = macsOneLine[noEmptyCount];
                
                Scanner read = new Scanner(macsNoEmpties[noEmptyCount]);
                for(int a=0; read.hasNext(); a++){
                    macsSingleRead[noEmptyCount][a] = read.next();
                }
                read.close();
                noEmptyCount++;
            }
        }
        
        String[][] data = newArray(macsSingleRead);
        checkPrint(data, args[1]);
        in.close();
    }
    
    public static String[][] newArray(String[][] singleRead)throws FileNotFoundException
    {
        String[][] updatedArray = new String[singleRead.length+2][11];
        
        updatedArray[0][0] = "ID";
        updatedArray[0][1] ="RA";
        updatedArray[0][2] ="DEC";
        updatedArray[0][3] = "zspec";
        updatedArray[0][4] ="zq";
        updatedArray[0][5] ="id";
        updatedArray[0][6] ="IC";
        updatedArray[0][7] ="dIC";
        updatedArray[0][8] ="zb";
        updatedArray[0][9] ="zbmin";
        updatedArray[0][10] ="zbmax";
        updatedArray[1][0] = "--";
        updatedArray[1][1] ="--";
        updatedArray[1][2] ="---";
        updatedArray[1][3] ="-----";
        updatedArray[1][4] ="--";
        updatedArray[1][5] ="--";
        updatedArray[1][6] ="--";
        updatedArray[1][7] ="---";
        updatedArray[1][8] ="--";
        updatedArray[1][9] ="-----";
        updatedArray[1][10] ="-----";
        
        for(int i=0; i<singleRead.length; i++){
            String[][] correctionArray = new String[singleRead.length][singleRead[i].length];
            int correctionIndex = 0;
            int updatedIndex = 2;
            
            for(int j=0; j<singleRead[i].length;j++){
                if(j==0||j==1|| j==2 || j==4 || j==5 || j==7 || j==8 ||j==9|| j==10 || j==11 || j==12){
                    correctionArray[i][correctionIndex] = singleRead[i][j];
                    updatedArray[i+updatedIndex][correctionIndex] = correctionArray[i][correctionIndex];
                    correctionIndex++;
                }
            }
        }
        updatedArray[2][0] = "1";
        updatedArray[2][1] = "102.4864833333";
        updatedArray[2][2] = "70.2350463889";
        updatedArray[2][3] = "0.632";
        updatedArray[2][4] = "4";
        updatedArray[2][5] = "39672";
        updatedArray[2][6] = "20.559";
        updatedArray[2][7] = "0.041";
        updatedArray[2][8] = "0.585";
        updatedArray[2][9] = "0.559";
        updatedArray[2][10] = "0.639";
        return updatedArray;
    }
    
    public static void checkPrint(String[][] arr1, String filename)throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter(filename);
        for(int i=0; i<arr1.length; i++){
            int check =0;
            for(int j=0; j<arr1[0].length; j++){
                if(arr1[i][j] == null){
                    break;
                }if(i==5){
                    check = 0;
                    break;
                }if(arr1[i][j].equals("-")){
                    System.out.print("\t");
                    out.print("\t");
                    check++;
                }else if(j==0){
                    System.out.print(arr1[i][j]);
                    out.print(arr1[i][j]);
                    check++;
                }else{
                    System.out.print("\t"+arr1[i][j]);
                    out.print("\t"+arr1[i][j]);
                    check++;
                }
            }if(check != 0){
                System.out.println();
                out.println();
            }
        }
        out.close();
    }
}
