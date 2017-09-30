
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;

public class cownomics {
    public static void main(String [] args) throws IOException {
        Scanner read = new Scanner(new File("cownomics.in"));
        PrintWriter write = new PrintWriter("cownomics.out");
        int cows = read.nextInt();
        int lineLen = read.nextInt();
        char [][] spots = new char [cows][lineLen];
        char [][] norm = new char [cows][lineLen];
        for(int i = 0; i< cows*2; i++){
            if(i < cows){
                String x = read.next();
                for(int j = 0; j<lineLen; j++){
                    spots[i][j] = x.charAt(j);
                }
            }
            else{
                String x = read.next();
                for(int j = 0; j<lineLen; j++){
                    norm[i-cows][j] = x.charAt(j);
                }

            }
        }
        int count = 0;
        for(int i = 0; i<lineLen; i++){
            boolean add = true;
            for(int j = 0;j<cows;j++){
                for(int x = 0; x<cows; x++){
                    if(norm[j][i] == spots[x][i]){
                        add = false;
                        break;
                    }
                }

            }
            if(add)
                count++;
        }
        write.println(count);
        write.close();
    }
}
