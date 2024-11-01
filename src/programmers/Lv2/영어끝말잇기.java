package programmers.Lv2;

import java.util.*;

public class 영어끝말잇기 {

    public ArrayList<Integer> solution(int n, String[] words) {

        ArrayList<Integer> answer = new ArrayList<>();

        // 틀린 인덱스의 값에 n을 나눈다.
        // 만약 나눠떨어지면 1번 사람, 아니면 나머지 더한 사람임
        // 나눴을 때의 몫의 +1이 몇 번째에 틀렸는 지에 대한 답임

        // 저장기록
        Map<String, Integer> map = new HashMap<>();

        // 단어 리스트의 길이
        int listleng = words.length;
        // 마지막 단어 기록할 변수
        char point = 'a';

        for(int i =0; i<listleng; i++) {

            // 현재 문자열
            String s = words[i];

            // 만약 이미 언급된 단어일 경우 처리
            if(map.containsKey(s)) {
                int player = (i % n) + 1;
                int turn = (i / n) + 1;
                answer.add(player);
                answer.add(turn);
                return answer;
            }

            // 언급 안되면 넣어준다.
            map.put(words[i], i+1);

            // 현재 문자가 첫 시작이 아닌 경우
            if(i != 0) {

                // 이전의 문자열의 끝과 지금 문자열의 시작이 다르면
                if(point != s.charAt(0)) {
                    int player = (i % n) + 1;
                    int turn = (i / n) + 1;
                    answer.add(player);
                    answer.add(turn);
                    return answer;
                }

            }

            // 마지막 글자
            point = s.charAt(s.length()-1);

        }
        answer.add(0);
        answer.add(0);

        return answer;
    }
}
