/*
ID: manukon1
LANG: JAVA
TASK: beads
*/
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;
public class beads {
    private static boolean ranThrough = false;
    public static void main(String [] args) throws IOException{
        Scanner read = new Scanner(new File("beads.in"));
        PrintWriter write = new PrintWriter("beads.out");
        read.nextLine();
        String ans = read.next();
        int max = 0;
        for(int i = 1; i < ans.length(); i++){
            String start = ans.substring(i) + ans.substring(0,i);
            String fin = new StringBuffer(start).reverse().toString();
            int x = count(start,start.charAt(0)) + count(fin,fin.charAt(0));
            if( x > max)
                max = x;
        }
        write.println(max);
        write.close();

    }

    public static int count(String x, char curr){
        if(ranThrough)
            return 0;
        int count  = 0;
        if(curr == 'w' && x.length() > 1){
            while(count < x.length() && curr == 'w'){
                curr = x.charAt(count);
                count++;
            }
        }
        while(count< x.length() && (x.charAt(count) == curr || x.charAt(count) == 'w')){
            count++;
        }
        if(count == x.length())
            ranThrough = true;
        return count;
    }
}
