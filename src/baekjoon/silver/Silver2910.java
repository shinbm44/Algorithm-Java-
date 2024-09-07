package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver2910 {

    public static void main(String [] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 입력
        String[] firstInput = br.readLine().split(" ");
        // 두 번째 입력
        String[] secondInput = br.readLine().split(" ");
        // 맵 생성 (순서를 보장하기 위해서 링크드 해쉬맵)
        Map<String, Integer> map = new LinkedHashMap<>();

        // 맵 세팅
        settingMap(firstInput, secondInput , map);
        // 결과값 출력
        printAnswer(firstInput, secondInput , map);



    }

    private static void printAnswer(String[] firstInput, String[] secondInput, Map<String, Integer> map) {

        // linkedhashmap의 key 값은 linkedhashset 구조와 같이 구현되었기에, keySet()으로 뽑아도 순서가 보장됨.
        List<String>keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> {
            int num1 = map.get(o1);
            int num2 = map.get(o2);
            return Integer.compare(num2, num1); // 빈도수만 비교
        });

        StringBuilder sb = new StringBuilder();

        for (String key : keySet) {
            for (int i =0; i<map.get(key); i++) {
                sb.append(key).append(" ");
            }
        }


        System.out.println(sb.toString().trim());

    }

    private static void settingMap(String [] firstInput, String [] secondInput, Map<String, Integer> map){

        for(int i = 0; i < Integer.parseInt(firstInput[0]); i++) {
            String key = secondInput[i];

            if( map.containsKey(key) ) {
                map.replace(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
    }
}
