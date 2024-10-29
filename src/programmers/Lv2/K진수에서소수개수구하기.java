package programmers.Lv2;

import java.util.*;

public class K진수에서소수개수구하기 {
    // n은 주어지는 수 , k는 진수
    public int solution(int n, int k) {
        int answer = 0;
        // 진수로 변환
        String result = convert(n, k);
        // 진수로 변환하여 받아온 값의 길이
        int leng = result.length();
        int index = 0;

        answer = calcul(result, leng, index, answer);


        return answer;
    }

    private int calcul(String result, int leng, int index, int answer){
        int count = 0;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i <= leng; i++) {

            if (i == leng || result.charAt(i) == '0') {

                if (current.length() > 0) {

                    long num = Long.parseLong(current.toString());
                    // 소수인지 확인
                    if (isPrime(num)) {
                        count++;
                    }
                }
                // StringBuilder 초기화
                current = new StringBuilder();
            } else {
                // '0'이 아닌 경우
                current.append(result.charAt(i));
            }
        }

        return count;
    }

    // 소수 판별
    private boolean isPrime(long num) {

        if (num <= 1) return false;

        for (long i = 2; i <= Math.sqrt(num); i++) {
            // 나누어 떨어지면 소수가 아님
            if (num % i == 0) return false;
        }
        // 소수
        return true;
    }

    // 10-> k진법으로 변환
    private String convert(int n, int k) {
        // n은 주어지는 수 , k는 진수
        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toString(n, k));

        return sb.toString();
    }
}
