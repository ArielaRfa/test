import java.util.ArrayList;

import java.util.*;
import java.io.*;
public class List {
    public static void main(String[] args)
    {
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(10);
        list.add(9);
        for (Integer i : list)
            if(i%5==0){
               System.out.println("Gratz");
            }
            else if(i%3==0){
                System.out.println("Fluzz");
            }
            else if(i%3==0 && i%5==0){
                System.out.println("FluzzGratz");
            }
    }
}
