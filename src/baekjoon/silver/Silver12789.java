package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Silver12789 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();



    public static void main(String[] args) throws Exception{

        int caseNum = Integer.parseInt(br.readLine());

        String [] order = br.readLine().split(" ");

        for(String i : order) {
            queue.add(Integer.parseInt(i));
        }

        int expected = 1;


        while (!queue.isEmpty() || !stack.isEmpty()) {
            if (!queue.isEmpty() && queue.peek() == expected) {
                queue.poll();
                expected++;
            } else if (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            } else if (!queue.isEmpty()) {
                stack.push(queue.poll());
            } else {
                break;
            }
        }

        if (expected == caseNum + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}