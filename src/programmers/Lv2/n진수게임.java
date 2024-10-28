package programmers.Lv2;

import java.util.*;

public class n진수게임  {
    // n이 진법, t가 미리 구할 숫자의 갯수, m이 참가하는 인원, p 튜브의 순서
    public String solution(int n, int t, int m, int p) {
        // 값을 담을 객체
        StringBuilder sb = new StringBuilder();

        // 변환할 10진수 숫자
        int number = 0;
        // 필요한 숫자의 총 개수
        int totalNumbers = t * m;


        // 필요한 숫자가 총 개수에 도달할 때까지 반복
        while (sb.length() < totalNumbers) {

            // 현재 숫자를 n진법으로 변환
            StringBuilder temp = new StringBuilder();
            int current = number;

            // 진법 변환
            if (current == 0) {
                temp.append("0");
            } else {
                while (current > 0) {
                    int remainder = current % n;
                    char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + (remainder - 10));
                    temp.insert(0, digit);
                    current /= n;
                }
            }
            // 변환된 숫자를 StringBuilder에 추가
            sb.append(temp);
            // 다음 숫자로 증가
            number++;
        }

        StringBuilder result = new StringBuilder();

        // p 번째 튜브의 숫자를 추출
        for (int i = 0; i < t; i++) {
            // m 간격으로 t 개의 숫자 추가
            result.append(sb.charAt(p - 1 + i * m));
        }

        // 결과 문자열 생성
        String answer = result.toString();

        return answer;
    }
}