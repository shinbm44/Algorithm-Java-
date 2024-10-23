package programmers.Lv2;

import java.util.*;

public class 압축 {

    public List<Integer> solution(String msg) {
        // 정수 배열 길이만큼의 배열 생성(답을 담을 리스트)
        List <Integer> result = new ArrayList<>();
        // 사전
        Map<String, Integer> data = new HashMap<>();
        // 문자열 나눠 담을 큐
        Queue<Character> q = new LinkedList<>();
        // 문자열 길이
        int leng = msg.length();

        // 큐에 세팅
        for(int i=0; i<leng; i++) {
            q.add(msg.charAt(i));
        }


        // 사전에 들어갈 값 세팅
        for(int i =0; i< 26; i++) {
            data.put(String.valueOf((char)('A' + i)), i+1 );
        }

        // 사전 길이
        int dictSize =26;
        StringBuilder sb = new StringBuilder();

        // 큐가 전부 비어있는 상태까지 loop
        while(!q.isEmpty()) {

            char check = q.poll();
            sb.append(check);
            // 맵에 있나 확인
            if(data.containsKey(sb.toString())){
                continue;
                // 없는 경우
            } else {
                // 이전 문자열의 값을 추가
                result.add(data.get(sb.substring(0, sb.length()-1)));
                // 새로운 문자열 사전에 등록
                dictSize++;
                data.put(sb.toString(), dictSize);

                // 문자열 초기화 및 다음 단어 세팅
                sb.setLength(0);
                sb.append(check);

            }
        }
        // 남은 문자열 처리
        if(sb.length() > 0) {
            result.add(data.get(sb.toString()));
        }

        return result;
    }
}
