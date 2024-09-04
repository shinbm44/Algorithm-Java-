package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver2161 {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 카드 갯수 입력
        int repeat = Integer.parseInt(br.readLine());

        Queue<Integer> cq = new LinkedList<>();

        // 숫자 입력
        for(int i = 0; i<repeat; i++) {
            cq.add(i+1);
        }

        makeResult(cq);
    }

    private static void makeResult(Queue <Integer> cq) {
        StringBuilder sb = new StringBuilder();

        // 초기 입력값이 1인 경우
        if(cq.size() == 1) {
            sb.append(1);
            System.out.println(sb);
            return;
        }

        while(true) {

            // 처음은 삭제
            int firstnum  = cq.remove();
            sb.append(firstnum).append(" ");
            // 만약 큐 사이즈 1이면 멈춤
            if(cq.size() == 1) {
                sb.append(cq.poll());
                break;
            }
            // 다음은 큐 뒤로 보내기
            int secondnum = cq.poll();
            cq.add(secondnum);


        }
        System.out.println(sb);
    }
}
