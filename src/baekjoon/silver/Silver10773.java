package baekjoon.silver;

import java.io.*;
import java.util.*;


public class Silver10773 {
    public static void main(String[] args) throws IOException {
        // 입력 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 시도 횟수
        int tryNumber = Integer.parseInt(br.readLine());
        // 입력받을 리스트
        List<Integer> arr = new ArrayList<>(tryNumber);
        // 리스트에 값 넣어주기
        arr = inputNumebr(br, arr, tryNumber);
        // 총 계산값
        int score;
        // 계산하기
        score = calculate(arr);

        System.out.println(score);


    }

    private static int calculate(List<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (i != 0) {
                stack.push(i);
            } else {
                stack.pop();
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }

    private static List<Integer> inputNumebr(BufferedReader br, List<Integer> arr, int tryNumber) throws IOException {
        for(int i = 0; i < tryNumber; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        return arr;
    }
}
