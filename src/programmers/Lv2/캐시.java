package programmers.Lv2;

import java.util.*;

public class 캐시 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // 도시이름 배열의 길이
        int leng = cities.length;

        // 캐시 사이즈가 0이면 전부 5의 실행시간
        if (cacheSize == 0) {
            return leng * 5;
        }

        // 캐시 목록 저장 맵
        Map<String, Integer> citiesM = new LinkedHashMap<>();

        for (int i = 0; i < leng; i++) {
            String city = cities[i].toUpperCase();

            // hit
            if (citiesM.containsKey(city)) {
                // 기존 위치에서 제거
                citiesM.remove(city);
                // 최근 위치로 이동
                citiesM.put(city, i);
                answer += 1;
            }

            // miss
            else {
                // 캐시가 가득 찼으면 오래된 항목 제거
                if (citiesM.size() >= cacheSize) {
                    String oldestCity = citiesM.keySet().iterator().next();
                    citiesM.remove(oldestCity);
                }

                citiesM.put(city, i);
                answer += 5;
            }
        }

        return answer;
    }
}
