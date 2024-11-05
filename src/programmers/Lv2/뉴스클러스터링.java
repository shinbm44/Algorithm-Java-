package programmers.Lv2;

import java.util.*;

public class 뉴스클러스터링 {

    static StringBuilder sb;

    public int solution(String str1, String str2) {

        int answer = 0;
        // 각 문자열의 길이
        int str1Leng = str1.length();
        int str2Leng = str2.length();

        // 각 2낱말 문자열의 값을 저장할 리스트
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // 2문자로 이뤄진 문자열 체크 및 리스트에 담기 - 문자열1
        for(int i = 0; i < str1Leng-1; i++) {

            sb= new StringBuilder();

            char first = str1.charAt(i);
            char second = str1.charAt(i+1);

            // 각 문자를 대문자로 변환
            first = Character.toUpperCase(first);
            second = Character.toUpperCase(second);

            // 각 문자가 영문자인지 개별적으로 확인
            if(first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                list1.add(sb.append(first).append(second).toString());
            }
        }

        // 2문자로 이뤄진 문자열 체크 및 리스트에 담기 - 문자열2
        for(int i = 0; i < str2Leng-1; i++) {

            sb= new StringBuilder();

            char first = str2.charAt(i);
            char second = str2.charAt(i+1);

            // 각 문자를 대문자로 변환
            first = Character.toUpperCase(first);
            second = Character.toUpperCase(second);

            // 각 문자가 영문자인지 개별적으로 확인
            if(first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z') {
                list2.add(sb.append(first).append(second).toString());
            }
        }

        // 교집합을 위한 리스트
        List<String> commonList = new ArrayList<>();
        // 교집합 처리를 위한 복사리스트
        List<String> list2Copy = new ArrayList<>(list2);

        // 교집합 처리
        for(String check : list1) {
            if(list2Copy.remove(check)) {
                commonList.add(check);
            }
        }
        // 교집합 크기
        double commonLeng = commonList.size();

        // 양쪽이 공집합일 경우
        if(list1.isEmpty() && list2.isEmpty() ) {
            return 65536;
        }

        // 계산
        double sumLeng = ( list1.size() + list2.size() ) - commonLeng;

        answer = (int)((commonLeng / sumLeng ) * 65536);

        return answer;
    }
}
