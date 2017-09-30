/*
ID: manukon1
LANG: JAVA
TASK: ride
*/

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
class ride {
    private String [] lines = new String[2];
    public static void main(String []args){
        ride r = new ride();
        r.getInput("ride.in");
        r.calculate();
    }

    public void getInput(String fileName){
       File file = new File(fileName);
       Scanner read;
       int i = 0;
       try {
           read= new Scanner(file);
           while(read.hasNextLine()){
                lines[i] = read.nextLine();
                i++;
           }
       }

       catch(FileNotFoundException e){
           System.out.println("File not found");
           System.exit(1);
       }
    }

    public void calculate(){

        int [] first = convert(lines[0]);
        int [] second= convert(lines[1]);

        print(findVal(first) == findVal(second));
    }

    public int [] convert(String str){
        int [] nums = new int [str.length()];
        for(int i = 0; i< str.length(); i++){
            nums[i] = (int)(str.charAt(i))-64;
        }
        return nums;
    }

    public int findVal(int [] arr){
        int val = 1;
        for( int i : arr){
            val *= i;
        }
        return val%47;
    }

    public void print(boolean go){
        PrintWriter write;
        try{
            write = new PrintWriter("ride.out");
            if(go){
                write.println("GO");

            }
            else{
                write.println("STAY");
            }
            write.close();
        }
        catch(Exception e){
            System.out.println("Error in writing file");
            System.exit(2);
        }


    }


}
