package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Silver2468 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        // 배열 크기
        int size = Integer.parseInt(br.readLine());

        int [][] field = new int[size][size];


        // 고지대 값
        int max = 0;

        // 배열 할당
        for(int i =0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                // 가장 높은 고지대 변수 값 할당
                if(field[i][j] > max){
                    max = field[i][j];
                }
            }
        }

        // 안전 지대 최대 숫자(비가 전혀 오지 않는 경우를 위해서 1로 설정)
        int safeCount = 1;
        // 안전 지대 최대 파악
        for(int i = 0; i < max; i++){
            // 매번 방문 표시되는 기록이 강우량에 따라 다르기에 매번 생성 필요
            boolean[][] visited = new boolean[size][size];
            // 안전 지대 갯수 파악을 위한 dfs 순회
            int count = dfs(field, visited, i, size);

            if(count > safeCount){
                safeCount = count;
            }
        }


        System.out.println(safeCount);

    }

    private static int dfs(int[][] field, boolean[][] visited, int nowHeight, int size) {

        int answer =0;
        nowHeight = nowHeight + 1;
        Stack<int[]> stack = new Stack <>();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if (field[i][j] > nowHeight && !visited[i][j]){
                    stack.push(new int[]{i,j});
                    visited[i][j] = true;
                    answer ++;

                    while(!stack.isEmpty()){
                        int[] cur = stack.pop();
                        int x = cur[0];
                        int y = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int cx = x + dx[k];
                            int cy = y + dy[k];

                            if(cx >= 0 && cx < size && cy >= 0 && cy < size && !visited[cx][cy]){
                                if(field[cx][cy] > nowHeight ){
                                    stack.push(new int[]{cx,cy});
                                    visited[cx][cy] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
