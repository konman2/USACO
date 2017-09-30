import java.io.*;
import java.util.*;

public class haybales {
    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(new File("haybales.in"));
        PrintWriter write = new PrintWriter("haybales.out");
        int[] x = new int[read.nextInt()];
        int Q = read.nextInt();
        for (int i = 0; i < x.length; i++) {
            x[i] = read.nextInt();
        }
        Arrays.sort(x);
        for (int i = 0; i < Q; i++) {
            int s = read.nextInt();
            int e = read.nextInt();
            write.println(find(s,e,x));
        }
        write.close();
    }


    public static int find(int s, int e,int[]x){
        if(s>x[x.length-1])
            return 0;
        int count = 0;
        int lo = 0;
        int hi = x.length - 1;
        int mid = hi/2;
        while (lo <= hi) {
            mid = lo +(hi-lo)/2;
            if(x[mid] <= s)
                lo = mid+1;
            else if(x[mid] > e){
                hi = mid -1;
            }
            else if(x[mid] == s){
                break;
            }
            else if(mid != 0 && x[mid-1]<s) {
                break;
            }
           else{
                hi = mid-1;
            }
        }
        //System.out.println(x[mid] + " " + mid);
        if(x[mid] <s || x[mid] > e) {
            return 0;
        }
        for(int i = mid; i< e - s;i++){

            count+=1;
        }

        return count;
    }

}
