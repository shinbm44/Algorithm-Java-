package programmers.Lv2;

import java.util.*;

public class 주식가격 {
    public int[] solution(int[] prices) {
        // 전체 길이
        int leng = prices.length;
        // 답을 담을 배열
        int [] answer = new int [leng];
        // 인덱스 값을 담을 스택
        Stack<Integer> stack = new Stack<>();

        // 전체 길이에 따른 인덱스를 순회하는 for문
        for(int i = 0; i< leng; i++) {

            // 인덱스 값을 돌면서 스택에 인덱스를 저장하며 만약 가격이 내려가면 정답 배열에 값을 저장 및 pop
            // 추가 index 값 add
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i] ){
                answer[stack.peek()] = i - stack.peek();

                stack.pop();
            }
            stack.add(i);

        }

        // 잔여 인덱스 값 정답 배열에 값 저장하는 로직
        while(!stack.isEmpty()) {
            answer[stack.peek()] = leng - stack.peek()-1;
            stack.pop();
        }

        return answer;
    }
}