package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2346 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque <Balloon> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String [] args) throws IOException {

        // first integer = input balloon's number
        int number = Integer.parseInt(br.readLine());

        // balloon value
        String [] input = br.readLine().split(" ");

        // deque add balloon value
        for(int j =0; j<number; j++ ) {
            deque.addLast(new Balloon(j+1, Integer.parseInt(input[j])));
        }

        while(!deque.isEmpty()) {

            Balloon moveVal = deque.pollFirst();
            sb.append(moveVal.index).append(" ");

            if(deque.isEmpty()){
                break;
            }

            if(moveVal.val>0) {
                for(int i =0; i < moveVal.val -1 ; i++) {
                    deque.addLast(deque.pollFirst());
                }

            }
            else {
                for(int i =0 ;i < -moveVal.val; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb.toString());
    }
}

class Balloon {
    int index;
    int val;

    public Balloon(int index , int val) {
        this.index = index;
        this.val = val;
    }
}