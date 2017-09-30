/*
ID: manukon1
LANG: JAVA
TASK: milk
*/
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class milk {
    public static void main(String [] args) throws IOException {
        Scanner read = new Scanner(new File("milk.in"));
        PrintWriter write = new PrintWriter("milk.out");
        int N = read.nextInt();
        int M = read.nextInt();
        ArrayList<Farm> x = new ArrayList<Farm>();
        for(int i = 0; i<M; i++){
            x.add(new Farm(read.nextInt(),read.nextInt()));
        }
        Collections.sort(x);
        int price = 0;
        for(int i = 0; i<M;i++){
            if(x.get(i).q > N){
                price += x.get(i).p * N;
                break;
            }
            price += x.get(i).p * x.get(i).q;
            N-=x.get(i).q;
        }
        write.println(price);
        write.close();
    }
}

class Farm implements Comparable<Farm>{
    int p;
    int q;
    public Farm(int pr,int qu){
         p = pr;
         q = qu;
    }

    public int compareTo(Farm oth){
        return this.p-oth.p;
    }

    public String toString(){
        return p+ " " + q;
    }

}
