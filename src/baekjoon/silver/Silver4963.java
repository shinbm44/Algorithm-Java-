package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Silver4963 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    // 오, 아, 왼, 위, 오위, 오아, 왼위, 왼아
    static int [] dx = {1,0,-1,0,1,1,-1,-1};
    static int [] dy = {0,-1,0,1,1,-1,1,-1};

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            // 0 0이 들어오면 종료
            if (row == 0 && col == 0) break;

            // solve 호출하여 결과 저장
            int result = solve(row, col);
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

    private static int solve(int row, int col) throws Exception {

        // 이중 배열 생성
        int [][] field = new int[row][col];
        boolean[][] visited = new boolean[row][col];

        // 이중 배열 세팅
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // dfs 메소드 호출
        return  dfs(field, visited,row, col);
    }

    // dfs 메소드
    private static int dfs(int[][] field, boolean[][] visited, int row, int col) {

        Stack<int[]> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(field[i][j] == 1 && !visited[i][j]) {
                    // 새로운 땅 발견
                    stack.push(new int[] {i,j});
                    visited[i][j] = true;
                    answer++;

                    while(!stack.isEmpty()) {
                        int [] pop = stack.pop();

                        int x = pop[0];
                        int y = pop[1];

                        for(int k = 0; k < 8; k++) {
                            int cx = x + dx[k];
                            int cy = y + dy[k];

                            if(cx >=0 && cy >= 0 && cx < row && cy < col && !visited[cx][cy] && field[cx][cy] == 1) {
                                // 방문 기록 남기기
                                stack.push(new int[] {cx,cy});
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
