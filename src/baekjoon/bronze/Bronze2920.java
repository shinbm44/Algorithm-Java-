package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class Bronze2920 {

    static int [] ascending = {1,2,3,4,5,6,7,8};
    static int [] descending = {8,7,6,5,4,3,2,1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        String [] input = br.readLine().split(" ");
        int [] inputToInt = new int[input.length];
        int len = input.length;
        boolean ascendingcheck =true;
        boolean descendingcheck =true;

        for(int i=0; i< len; i++) {
            inputToInt[i] = Integer.parseInt(input[i]);
        }

        for(int i = len-1; i >= 0; i--) {
            if(inputToInt[i] != ascending[i]){
                ascendingcheck = false;
            }
        }

        for(int i = len-1; i >= 0; i--) {
            if(inputToInt[i] != descending[i]){
                descendingcheck = false;
            }
        }

        if(ascendingcheck) {
            System.out.println("ascending");
        } else if(descendingcheck) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
