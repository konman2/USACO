/*
ID: manukon1
LANG: JAVA
TASK: dualpal
*/
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;
public class dualpal {
    public static void main(String [] args) throws IOException {
        Scanner read = new Scanner(new File("dualpal.in"));
        PrintWriter write = new PrintWriter("dualpal.out");
        int N = read.nextInt();
        int S = read.nextInt()+1;
        int ovCount = 0;
        while(ovCount < N){
            int count = 0;
            for(int i = 2;i<=10;i++){
                if(palindrome(convert(S,i))){
                    count++;
                }
                if(count == 2){
                    write.println(S);
                    count++;
                    ovCount++;
                    break;
                }
            }
            S++;
        }
        write.close();
    }

    public static String convert(int bTen,int base){
        int val = bTen;
        String fin = "";
        int lcm = 0;
        for(int i = 0; i<= bTen; i++){

            if(bTen/((int)(Math.pow((double)base,(double)i))) > 0
                    && bTen/((int)(Math.pow((double)base,i+1.0))) == 0){
                lcm = i;
                break;
            }
        }
        for(int i = lcm; i>=0; i--){
            int count = 0;
            while((int)((Math.pow((double)base,(double)i))) <= val){
                val -= (int)((Math.pow(base,i)));
                count++;
            }
            fin += validate(count);
        }

        return fin;

    }

    public static String validate(int unit){
        if(unit<10)
            return unit + "";
        else{
            return (char)(unit+55) + "";
        }
    }
    public static boolean palindrome(String val){
        return (new StringBuilder(val).reverse().toString().equals(val));
    }

}
