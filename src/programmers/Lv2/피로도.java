package programmers.Lv2;

import java.util.*;

public class 피로도 {

    // 방문 기록
    static boolean [] check;
    // 결과값 저장
    static ArrayList<Integer> results = new ArrayList<>();
    // 에너지 수치
    static int energy;
    // 최소 에너지 수치
    static int minEnergy;


    public int solution(int k, int[][] dungeons) {

        // 장소 몇개인지
        int placeNumber = dungeons.length;
        check = new boolean [placeNumber];

        // 에너지
        energy = k;

        // 최소 입장 에너지 값만 담을 배열
        int [] enterEnergy = new int [placeNumber];


        for(int i =0; i< placeNumber; i++) {
            enterEnergy[i] = dungeons[i][0];
        }
        // 에너지 입장 수치 정렬
        Arrays.sort(enterEnergy);
        // 가장 최소값의 입장 에너지 권한 변수
        minEnergy = enterEnergy[0];

        // 탐색 매서드 호출
        dfs(energy, dungeons, placeNumber, 0);

        // 결과값 리턴
        return (results.isEmpty()) ? 0 : Collections.max(results);
    }


    private void dfs(int energy, int[][]dungeons, int placeNumber, int count) {
        // 가장 작은 입장 수치에도 도달하지 못하면 다른 곳은 못감
        if(energy < minEnergy) {
            results.add(count);
            return;
        }
        // 전체를 다 돌았으면 끝냄
        if(count == dungeons.length) {
            results.add(count);
            return;
        }

        for(int i =0; i< placeNumber; i++) {
            // 이미 들린곳이면 패쓰
            if(check[i]) {
                continue;
            }

            // 방문 가능 지역에 따른 재귀호출
            if(energy >= dungeons[i][0] && energy >= dungeons[i][1] ) {
                check[i] = true;
                dfs(energy - dungeons[i][1], dungeons, placeNumber, count+1);
                check[i] = false;
            }
        }
    }
}