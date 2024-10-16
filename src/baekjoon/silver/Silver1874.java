package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver1874 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int number = Integer.parseInt(br.readLine());

        // 스택
        Stack<Integer> stack = new Stack<>();

        int count = 1;

        for(int i=0; i< number; i++) {
            // 숫자 입력
            int inputNumber = Integer.parseInt(br.readLine());
            // 입력 받은 숫자보다 작으면 push 반복
            while(count <= inputNumber) {
                stack.push(count);
                sb.append("+\n");

                count++;
            }
            // 스택이 비었거나 입력받은 값으로 스택에서 뽑아와 수열 만들 수 없는 상황
            if (stack.isEmpty() || stack.peek() != inputNumber) {
                System.out.println("NO");
                return;
            }


            stack.pop();
            sb.append("-\n");

        }

        System.out.print(sb);

    }
}
