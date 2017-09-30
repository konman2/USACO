import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;
public class countcross {
    static int least = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(new File("countcross.in"));
        PrintWriter write = new PrintWriter("countcross.out");
        int N = read.nextInt();
        int K = read.nextInt();
        int R = read.nextInt();
        int [][] field = new int [N][N];
        int cows = K-1;
        //Road [] roads = new Road[R];
        //RC [] cows = new RC[K];
        for(int i = 0; i<R; i++){
            field[read.nextInt()][read.nextInt()] = 1;
        }
        for(int i = 0; i<K; i++){
            field[read.nextInt()][read.nextInt()] = 2;
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N;j++){
                if(field[i][j] == 1){

                }
            }
        }

    }
}

class RC{
    int row;
    int col;
    public RC(int r,int c){
        row = r;
        col = c;
    }

    public boolean equals(int r, int c){
        return row == r && col==c;
    }

    public boolean equals(Object oth){
        return equals(((RC)(oth)).row,((RC)(oth)).col);
    }
}

class Road{
    RC first;
    RC sec;
    public Road(RC one,RC two){
        first = one;
        sec = two;
    }
}
