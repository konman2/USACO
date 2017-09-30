import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class maxcross {
    static int least = Integer.MAX_VALUE;
    public static void main(String [] args) throws IOException {
        Scanner read = new Scanner(new File("maxcross.in"));
        PrintWriter write = new PrintWriter("maxcross.out");
        int N = read.nextInt();
        int K = read.nextInt();
        boolean [] broken = new boolean[N];
        int len = read.nextInt();
        if(N==len) {
            write.println(N);
            write.close();
            return;
        }

        for(int i =0; i< len;i++){
            broken[read.nextInt()-1] = true;
        }

        int least = Integer.MAX_VALUE;
        for(int i = 0; i<=N-K;i++) {
            int fixed = 0;
            for (int j = i; j < i+K; j++) {
                if (broken[j])
                    fixed++;
            }
            least = Math.min(fixed, least);


        }
        write.println(least);
        write.close();
    }
}