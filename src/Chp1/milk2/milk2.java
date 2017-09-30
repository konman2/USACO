/*
ID: manukon1
LANG: JAVA
TASK: milk2
*/
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class milk2 {

    public static void main(String[] args) throws IOException {
        ArrayList<Times> vals = new ArrayList<Times>();
        Scanner read = new Scanner(new File("milk2.in"));
        PrintWriter write = new PrintWriter("milk2.out");
        int stuff = read.nextInt();
        for (int i = 0; i < stuff; i++) {
            vals.add(new Times(read.nextInt(), read.nextInt()));
        }

        //sort(vals);
        vals = squish(vals);
        write.print(findInBetween(vals) + " ");
        write.println(notWork(vals));
        write.close();
    }

    public static int findInBetween(ArrayList<Times> x) {
        int max = 0;
        for (Times i : x) {
            if (i.end - i.start > max) {
                max = i.end - i.start;
            }
        }
        return max;
    }

    public static int notWork(ArrayList<Times> x) {
        int max = 0;
        for (int i = 0; i < x.size() - 1; i++) {
            if (x.get(i + 1).start - x.get(i).end > max) {
                System.out.println(x.get(i) + " " + x.get(i + 1));
                max = x.get(i + 1).start - x.get(i).end;
            }
        }


        return max;

    }


    public static ArrayList<Times> squish(ArrayList<Times> arr) {
        Collections.sort(arr);
        //System.out.println(arr);
        ArrayList<Times> squished = new ArrayList<Times>();
        int lastI = 0;
        for (int k = 0; k < arr.size(); k = lastI + 1) {
            lastI = k;
            boolean go = true;
            int maxEnd = arr.get(k).end;
            int minStart = arr.get(k).start;


            for (int i = k; i < arr.size() - 1; i++) {
                if (arr.get(i + 1).start <= maxEnd && arr.get(i + 1).end > maxEnd) {
                    maxEnd = arr.get(i + 1).end;
                    lastI++;
                }
                for (Times x : squished) {
                    if (maxEnd < x.end)
                        go = false;
                }

            }
            if (go)
                squished.add(new Times(minStart, maxEnd));

            //else
            //lastI = k+1;





        }
        System.out.println(squished);
        return squished;
    }


    static class Times implements Comparable<Times>{
        int start;
        int end;
        public Times(int s,int e){
            start = s;
            end = e;
        }

        public int compareTo(Times oth){
            return start - oth.start;
        }

        public String toString(){
            return start + " " + end;
        }

    }
}


