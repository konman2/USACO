/*
ID: manukon1
LANG: JAVA
TASK: gift1
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class gift1 {
    Scanner read;
    Person [] people;
    ArrayList<String> file = new ArrayList<String>();
    public static void main(String [] args) throws FileNotFoundException {

        gift1 g = new gift1();

        g.read =  g.setup();
        g.run();
    }

    public Scanner setup() throws FileNotFoundException{
        File file = new File("gift1.in");
        Scanner read = null;

            read = new Scanner(file);



        return read;
    }

    public void run(){
        while(read.hasNextLine()){
            file.add(read.nextLine());
        }

        makePeople(Integer.parseInt(file.get(0)));
        while(file.size() > 1)
            doWork();
        print();
    }

    public void makePeople(int num){
        people = new Person[num];
        for(int i = 0; i<num; i++){
            people[i] = new Person(0,file.get(i+1));
        }
        del(people.length);
    }

    public void del(int num){
        for(int i = num; i>=0; i--){
            file.remove(i);
        }


    }

    public void doWork(){
        int giver = find(file.get(0));
        int cash = 0;
        int friends = 0;
        //System.out.println(file.get(1).indexOf(" "));
        String vals = file.get(1);
        cash = Integer.parseInt(vals.substring(0,vals.indexOf(" ")));
        friends = Integer.parseInt(vals.substring(vals.indexOf(" ")+1));
        if(friends == 0) {
            del(1);
            return;
        }
        people[giver].sub(cash);
        people[giver].add(cash%friends);

        for(int i = 2; i<2+friends; i++){
            int taker = find(file.get(i));
            people[taker].add(cash/friends);
        }
        del(2+friends-1);
    }

    public int find(String name){
         for (int i = 0; i <people.length; i++){
             if(people[i].getName().equals(name)){
                return i;
             }
        }
        return -1;

    }

    public void print(){
        try{
            PrintWriter pw = new PrintWriter("gift1.out");
            for(Person i : people){
                pw.println(i);
            }
            pw.close();
        }
        catch(Exception e){
            System.out.print("Error");
            System.exit(1);
        }
    }

}

class Person{
    private int money;
    private String name;

    public Person(int cash,String name){
        this.name = name;
        money = cash;

    }
    public void add(int amount){
        money+= amount;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void sub(int amount){
        money -= amount;
    }
    @Override
    public String toString(){
        return name + " " + money;
    }

    public String getName(){
        return name;
    }
}
