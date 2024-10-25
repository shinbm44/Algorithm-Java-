package programmers.Lv2;

import java.util.*;

public class 뒤에있는큰수찾기 {  public int[] solution(int[] numbers) {
    int n = numbers.length;
    int[] answer = new int[n];
    Stack<Integer> stack = new Stack<>();

    // 결과 배열 초기화 (-1로 설정)
    for (int i = 0; i < n; i++) {
        answer[i] = -1;
    }

    // 오른쪽에서 왼쪽으로 순회
    for (int i = n - 1; i >= 0; i--) {
        // 스택의 top이 현재 값보다 작거나 같으면 pop
        while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
            stack.pop();
        }

        // 스택이 비어 있지 않으면, 스택의 top이 뒷 큰수
        if (!stack.isEmpty()) {
            answer[i] = stack.peek();
        }

        // 현재 값 스택에 추가
        stack.push(numbers[i]);
    }

    return answer;
}
}