import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;

/*
ID: manukon1
LANG: JAVA
TASK: friday
*/
public class friday {
    private int [] thirties;
    private int [] count;
    private int years;
    private int day;
    public friday(){
        day = 3;
        thirties = new int [] {4,6,9,11};
        count = new int[7];
        for(int i = 0; i<count.length; i++){
            count[i] = 0;
        }

    }

    public static void main(String[] args) throws IOException{

        friday f = new friday();
        Scanner read = new Scanner(new File("friday.in"));
        f.years = read.nextInt();
        f.run();
        PrintWriter write = new PrintWriter("friday.out");
        for(int i = 0; i<f.count.length;i++){
            if(i<f.count.length-1)
                write.print(f.count[i] + " ");
            else
                write.print(f.count[i]);
        }write.println();
        write.close();


    }

    public void run(){

        int startYear = 1900;
        for(int i = 0; i<years; i++) {
            boolean leapYear = false;
            if ((startYear +i) % 100 == 0) {
                if ((startYear+i) % 400 == 0)
                    leapYear = true;
            }
            else if ((startYear+i) % 4 == 0) {
                leapYear = true;
            }
            doYear(leapYear);
        }

    }

    public void doYear(boolean leap){

        for(int i = 1;i<=12;i++){
            int changeMonth = 31;
            if(search(i))
                changeMonth = 30;
            else if(i==2) {
                if (leap)
                    changeMonth = 29;
                else
                    changeMonth = 28;
            }
            doMonth(changeMonth);

        }
    }

    public void doMonth(int n){
        for(int i = 1; i<=n; i++){
            if(day >=8){
                day = 1;
            }
            if(i == 13){
                count[day-1]++;
            }

            day++;
        }
    }

    public boolean search(int val){
        for(int i: thirties){
            if(i == val)
                return true;
        }
        return false;
    }


}
