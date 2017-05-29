/*
ID: manukon1
LANG: JAVA
TASK: transform
*/
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class transform{

    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(new File("transform.in"));
        PrintWriter write = new PrintWriter("transform.out");
        int stuff = read.nextInt();
        char [][] orig = new char [stuff][stuff];
        char [][] trans = new char[stuff][stuff];
        for(int i = 0; i<stuff;i++){
            String line = read.next();
            for(int j = 0; j<line.length();j++){
                orig[i][j]=line.charAt(j);
            }
        }
        for(int i = 0; i<stuff;i++){
            String line = read.next();
            for(int j = 0; j<line.length();j++){
                trans[i][j]=line.charAt(j);
            }
        }
        int x = rotate(orig,0,trans);
        char [][] flipped = mirrorVertical(orig);
        int y = rotate(flipped,1,trans);
        if(x != -1)
            write.println(x);
        else if(equals(flipped,trans))
            write.println(4);
        else if(y != -1){
            write.println(5);
        }

        else if(equals(orig,trans))
            write.println(6);
        else
            write.println(7);
        write.close();


    }

    public static int rotate(char [][] arr,int ocount, char [][] trans){
        char [][] copy = copy(arr);
        int count = ocount;
        while(count < ocount+4){
            count++;
            copy = rotate90(copy);
            if(ocount != 0) {
                //print(copy);
                //System.out.println("\n\n\n");
            }
            if(equals(trans,copy))
                break;
        }
        if(count == ocount+4)
            return -1;
        return count;

    }

    public static char [][] rotate90(char [][] arr){
        char [][] rotated = copy(arr);
        for(int i = 0; i<arr.length;i++){
            for(int j = 0; j<arr[i].length;j++){
                rotated[j][i] = arr[arr.length-i-1][j];
            }
        }
        return rotated;
    }

    public static boolean equals(char [][] arr,char [][] copy){
        for(int i = 0; i<arr.length;i++){
            for(int j = 0; j<arr[i].length;j++){
                if(arr[i][j] != copy[i][j])
                    return false;
            }
        }
        return true;
    }

    public static char [][] copy(char [][] from){
        char [][] to = new char [from.length][from[0].length];
        for(int i = 0; i<from.length;i++){
            for(int j = 0; j<from[i].length;j++){
                to[i][j] = from[i][j];
            }
        }
        return to;
    }

    public static void  print(char [][] arr){
        for(char [] i : arr){
            for(char j:i){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static char [][] mirrorVertical(char [][] orig)
    {
        char[][] pixels = copy(orig);
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width; col++)
            {

                pixels[row][width - 1 - col]  = orig[row][col];
                //pixels[col][row] = orig[row][col];
            }
        }
        //print(pixels);
        return pixels;
    }


}