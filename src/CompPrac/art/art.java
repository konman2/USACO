
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class art {
    static ArrayList<Integer> used = new ArrayList<Integer>();
    public static void main(String [] args) throws IOException {

        Scanner read = new Scanner(new File("art.in"));
        PrintWriter write = new PrintWriter("art.out");
        int val =read.nextInt();
        int [][] piece = new int [val][val];
        for(int i = 0; i<val; i++){
            String x = read.next();
            for(int j = 0; j<val; j++){
                piece [i][j] = Integer.parseInt(x.charAt(j) + "");
            }
        }
        int count = 0;
        for(int i = 0; i<val;i++){
            for(int j = 0; j<val; j++){
                if(!used.contains(piece[i][j]) && (good(piece,i,j,3))){
                    count++;
                }
                used.add(piece[i][j]);
            }
        }
        write.println(count);
        write.close();
    }

    public static boolean good(int [][] pixels, int row,int col,int size) {
        int startRow = row - row % size;
        int startCol = col - col % size;

        for (int i = startRow; i < startRow + size && i < pixels.length; i++) {
            for (int j = startCol; j < startCol + size && j < pixels[i].length; j++) {
                if (pixels[i][j] != pixels[row][col] && j != 0 && j != startCol + size - 1
                        && j != pixels.length - 1 && pixels[i][j - 1] == pixels[row][col]
                        && pixels[row][col] == pixels[i][j + 1]) {
                    used.add(pixels[i][j]);
                    return false;

                }
                else if (pixels[i][j] == pixels[row][col] && j != 0 && j != startCol + size - 1
                        && j != pixels.length - 1 && (pixels[i][j - 1] != pixels[row][col]
                        || pixels[row][col] != pixels[i][j + 1])) {
                    return false;
                }
                if (pixels[i][j] == 0)
                    return false;
            }
        }
        System.out.println(pixels[row][col]);
        return true;
    }

    public static void maxRect(int [][] p, int row,int col,int size){

    }
}
