package baekjoon.gold;

import java.util.*;
import java.io.*;


public class Gold2493 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 반복 횟수
        int repeat = Integer.parseInt(br.readLine());
        String list = br.readLine();
        // 탑 높이 입력받기
        StringTokenizer st = new StringTokenizer(list, " ");

        ArrayList<Integer> tower = new ArrayList<>(repeat);
        // 탑 높이 입력 받고 배열에 넣기
        settingTower(tower, st, repeat);

        ArrayList<Integer> result = new ArrayList<>(repeat);
        // 결과값 계산 후 출력하기
        makeresult(result, tower, repeat);

    }

    private static void makeresult(ArrayList<Integer> result, ArrayList<Integer> tower, int repeat) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < repeat; i++) {
            boolean check = true;
            for(int j = i; j >= 0; j--){
                if( i != j && tower.get(i) < tower.get(j)) {
                    sb.append(j+1).append(" ");
                    check = false;
                    break;
                }
            }
            if(check) {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void settingTower(ArrayList<Integer> tower, StringTokenizer st, int repeat) {
        while(st.hasMoreTokens()) {
            tower.add(Integer.parseInt(st.nextToken()));
        }
    }
}

// 시간 초과를 해결할 방법 고민 필요..