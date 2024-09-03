package baekjoon.silver;
import java.util.*;
import java.io.*;


public class Silver1935 {

    public static void main(String [] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 변수 숫자
        int repeat = Integer.parseInt(br.readLine());
        // 표현식
        String formula = br.readLine();
        // 알파벳에 대응하는 숫자 값을 저장할 배열
        double[] values = new double[formula.length()];

        // 알파벳에 해당하는 숫자 입력받기
        for (int i = 0; i < repeat; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        // 스택
        Stack <Double> stack = new Stack<>();
        // 표현식 -> 스택 반환
        calculate(stack, formula, values);

    }

    private static void calculate (Stack<Double> stack, String formula, double[] values) throws Exception {
        double result = 0;

        for (int i = 0; i < formula.length(); i++) {
            // 문제에서 제시한 문자일 경우 stack에 넣기
            if ('A' <= formula.charAt(i) && formula.charAt(i) <= 'Z' ) {
                stack.push(values[formula.charAt(i) - 'A']);
            // 그게 아니라면 계산 해준다.
            } else {

                double pre = stack.pop();
                double pro = stack.pop();

                switch (formula.charAt(i)) {

                    case '*':
                        result = pro * pre;
                        stack.push(result);
                        break;
                    case '+':
                        result = pro + pre;
                        stack.push(result);
                        break;
                    case '/':
                        result = pro / pre;
                        stack.push(result);
                        break;
                    case '-':
                        result = pro - pre;
                        stack.push(result);
                        break;

                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
