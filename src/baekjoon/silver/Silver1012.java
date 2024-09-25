package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver1012 {

    static int [][] field;
    static boolean[][] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result = 0;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        // 테스트 케이스
        int caseNumber = Integer.parseInt(br.readLine());
        // 케이스 횟수에 따른 값을 할당 받기
        for(int i =0; i<caseNumber; i++) {
            int answer = solve();
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    // 문제 풀기 위한 변수 할당 및 세팅
    private static int solve() throws Exception {

        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());

        field = new int [row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int rowNumber = Integer.parseInt(st.nextToken());
            int colNumber = Integer.parseInt(st.nextToken());
            field[rowNumber][colNumber] = 1;
        }
        // dfs 메서드 호출하여 값 반환
        result = dfs(field, visited, row, col);
        // 밭이랑 방문 정보 배열 초기화
        field = null;
        visited = null;

        return result;
    }

    // dfs 메소드
    private static int dfs(int[][] field, boolean[][] visited, int row, int col) {
        int answer = 0;

        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(field[i][j] == 1 && !visited[i][j]) {
                    stack.push(new int[] {i,j});
                    visited[i][j] = true;
                    answer++;

                    while(!stack.isEmpty()) {
                        int[] current = stack.pop();
                        int x = current[0];
                        int y = current[1];

                        for (int k = 0; k < 4; k++) {
                            int cx = x + dx[k];
                            int cy = y + dy[k];

                            if (cx >= 0 && cy >= 0 && cx < row && cy < col && !visited[cx][cy] && field[cx][cy] == 1) {
                                stack.push(new int[]{cx, cy});
                                visited[cx][cy] = true;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
