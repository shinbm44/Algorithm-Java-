package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Silver2529 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //결과값을 담을 리스트
    static List<String> results = new ArrayList<>();
    // 대소 비교 입력값
    static String [] inputSizeCheck;
    // 입력 가능 숫자 체크
    static boolean [] check = new boolean[10];


    public static void main(String[] args) throws Exception {

        // 길이 (k)
        int length = Integer.parseInt(br.readLine());
        // 비교 문자 받기
        inputSizeCheck = br.readLine().split(" ");

        dfs("" ,0, length);

        Collections.sort(results);

        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));



    }

    private static void dfs(String resultNumber, int index, int length) {

        // 만약 원하는 길이의 숫자 구성을 만들면 해당 메서드 return
        if (index == length + 1) {
            results.add(resultNumber);
            return;
        }

        // 모든 경우의 수를 탐색하면서 숫자 조합을 만드는 로직
        for(int i =0; i < 10; i ++ ) {
            if(check[i]) continue;
            if(index == 0 || compareNumber(resultNumber.charAt(index-1), i, inputSizeCheck[index-1])){
                check[i] = true;
                dfs(resultNumber + i, index+1, length);
                check[i] = false;
            }
        }
    }

    private static boolean compareNumber(char prevNumber, int nextNumber, String compareSign) {

        int prev = Character.getNumericValue(prevNumber);
        compareSign = compareSign.trim();
        char compare = compareSign.charAt(0);


        if (compare == '>') {
                return prev > nextNumber;
        }
        else {
                return prev < nextNumber;
        }
    }
}
