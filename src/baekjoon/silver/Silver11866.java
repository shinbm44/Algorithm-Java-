package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int rangeNum =  Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");

        Deque<Integer> deque = new ArrayDeque<>();

        // 배열에 값 세팅
        for(int i =0; i<rangeNum; i++){
            deque.add(i+1);
        }

        while(!deque.isEmpty()) {

            for(int i =0; i <minus-1; i++) {
                deque.addLast(deque.pollFirst());
            }

            stringBuilder.append(deque.pollFirst());

            if(!deque.isEmpty()) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append(">");


        String result = stringBuilder.toString();

        System.out.println(result);

    }
}
