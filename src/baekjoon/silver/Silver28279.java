package baekjoon.silver;

import java.io.*;
import java.util.*;


public class Silver28279 {
    static Deque<Integer> list = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int orderRange = Integer.parseInt(br.readLine());

        for (int i =0; i<orderRange; i++) {
            String [] inputList = br.readLine().split(" ");

            switch (inputList[0]) {
                case "1":
                    list.addFirst(Integer.parseInt(inputList[1]));
                    break;

                case "2":
                    list.addLast(Integer.parseInt(inputList[1]));
                    break;
                case "3":

                    if(list.isEmpty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(list.pollFirst());
                    }

                    break;

                case "4":
                    if(list.isEmpty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(list.pollLast());
                    }

                    break;
                case "5":
                    System.out.println(list.size());
                    break;
                case"6":
                    if(list.isEmpty()) {
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                    break;
                case"7":
                    if(list.isEmpty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(list.peekFirst());
                    }
                    break;
                case"8":
                    if(list.isEmpty()) {
                        System.out.println(-1);
                    }
                    else {
                        System.out.println(list.peekLast());
                    }
                    break;
            }
        }
    }
}
