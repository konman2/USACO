import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;
public class lostcow {
    public static void main(String [] args) throws IOException {
        Scanner read = new Scanner(new File("lostcow.in"));
        PrintWriter write = new PrintWriter("lostcow.out");
        int x = read.nextInt();
        int y = read.nextInt();
        int factor = 1;
        int count = 0;
        //int perfect = Math.abs(x-y);
        int travel = x;
        int lastLoc = x;
        while(x!=y){
            if((x < y && x+factor >=y) ||x>y && x+factor<=y){
                count += Math.abs(travel-y);
                break;
            }
            count += Math.abs(travel - (x+factor));
            travel = x+factor;
            factor *= -2;
        }
        write.println(count);
        write.close();
    }
}
