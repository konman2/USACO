/*
ID: manukon1
LANG: JAVA
TASK: barn1
*/
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
public class barn1 {
    public static void main(String [] args) throws IOException {
        Scanner read = new Scanner(new File("barn1.in"));
        PrintWriter write = new PrintWriter("barn1.out");
        int M = read.nextInt();
        int S = read.nextInt();
        int C = read.nextInt();
        int [] nums = new int[C];
        for(int i = 0; i<C;i++){
            nums[i] = read.nextInt();
        }
        if(M>=C){
            write.println(C);
            write.close();;
            return;
        }

        Arrays.sort(nums);
        /*
        int maxSpace = 0;
        int covered = C;
        for(int j = 0; j<M; j++) {


            for (int i = 0; i < stalls.length; i++) {

            }
        }

        for(int j = 0; j<C-1;j++){
                    System.out.println(nums[j + 1] - nums[j]);
        }
        */

        int covered = nums[nums.length-1]-nums[0];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<M-1;i++){
            int maxSpace = 0;
            int maxInd = -1;
            for(int j = 0; j<C-1;j++){
                if(!list.contains(j)) {
                    if(nums[j+1]-nums[j]>maxSpace) {
                        //System.out.println(nums[j + 1] - nums[j]);
                        maxSpace = nums[j + 1] - nums[j];
                        maxInd = j;
                    }

                }

            }
            list.add(maxInd);
            //System.out.println(list);
            //System.out.println(maxSpace);
            covered -= maxSpace;
        }
        write.println(covered+M);
        write.close();
    }
}
