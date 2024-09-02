package baekjoon.silver;
import java.util.*;
import java.io.*;


public class Silver10799 {
    public static void main(String[] args) throws IOException{
        // 입력 객체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자 받을 객체 stack
        Stack<Character> stack = new Stack<>();
        // 입력값
        String bar = br.readLine();
        // 문자에 넣기
        char [] chars = bar.toCharArray();
        // 계산
        int totalScore = calculate(chars,stack);


        System.out.println(totalScore);
    }

    private static int calculate(char[] chars, Stack<Character> stack) {
        int totalScore = 0;
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == '(') {
                stack.push(chars[i]);
            } else {
                stack.pop();
                if(chars[i-1] == '('){
                    // 이전에 '('였으면 stack에서 쌓인 숫자만큼 단절 +
                    totalScore += stack.size();
                } else {
                    // 막대가 끝나면 한번 단절되기에 +1
                    totalScore += 1;
                }
            }
        }
        return totalScore;
    }
}
