
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class helpcross {
    public static void main(String [] args) throws IOException {
        Scanner read = new Scanner(new File("helpcross.in"));
        PrintWriter write = new PrintWriter("helpcross.out");
        ArrayList<Integer> chickens = new ArrayList<Integer>();
        ArrayList<Cow> cows = new ArrayList<Cow>();
        int val = read.nextInt();
        int val2 = read.nextInt();
        for(int i = 0; i<val;i++){
            chickens.add(read.nextInt());
        }
        for(int i = 0; i<val2;i++){
              cows.add( new Cow(read.nextInt(),read.nextInt()));
        }
        Collections.sort(chickens);
        Collections.sort(cows);
        System.out.println(cows);
        int count = 0;

        for(int i = 0; i<cows.size();i++){
            int best = -1;
            int ind = -1;
            //int oth = Integer.MAX_VALUE;
            for(int j = 0; j<chickens.size();j++){
                if(chickens.get(j)>=cows.get(i).from && chickens.get(j)<=cows.get(i).to && cows.get(i).from > best) {
                    best = cows.get(i).from;
                    //oth = cows.get(i).to;
                    ind = j;

                }


            }
            if(best != -1) {
                count++;
                chickens.remove(ind);
            }
        }
        write.println(count);
        write.close();
    }




}
class Cow implements Comparable<Cow>{
    int from;
    int to;
    boolean partner = false;
    public Cow(int i,int j) {
        from = i;
        to = j;
    }

    public String toString(){
        return from + " " + to;
    }

    public int compareTo(Cow oth){
        if(oth.to != this.to)
            return this.to - oth.to;
        return this.from - oth.from;
    }
}
