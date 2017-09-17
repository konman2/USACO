/*
ID: manukon1
LANG: JAVA
TASK: palsquare
*/
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class palsquare {
    static int base;
    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(new File("palsquare.in"));
        PrintWriter write = new PrintWriter("palsquare.out");
        base = read.nextInt();
        String conv;
        for(int i = 1; i<300; i++){
            String square = convert(i*i);
            if(palindrome(square)){
                write.println(convert(i) + " " + square );
            }

        }
        write.close();



    }

    public static String convert(int bTen){
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
