package baekjoon.silver;
import java.io.*;
import java.util.*;

public class Silver2583 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [][] field;
    static boolean [][] visited;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int numberArea =0;
    static ArrayList <Integer> resultSizes = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());

        field = new int[row][col];
        visited = new boolean[row][col];

        // 사각형 설정
        for(int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());

            int lowX = Integer.parseInt(st.nextToken());
            int lowY = Integer.parseInt(st.nextToken());
            int upX = Integer.parseInt(st.nextToken());
            int upY = Integer.parseInt(st.nextToken());

            settingField(lowX, lowY, upX, upY, field);
        }

        // 영역 숫자 및 크기 구하기
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (!visited[i][j] && field[i][j] == 0){
                    int size = dfs(i, j, row, col);
                    resultSizes.add(size);
                    numberArea++;
                }
            }
        }

        // 출력
        resultSizes.sort(Comparator.naturalOrder());
        sb.append(numberArea).append("\n");
        for(int size : resultSizes) {
            sb.append(size).append(" ");
        }

        System.out.println(sb);
    }

    // dfs 메소드
    private static int dfs(int x, int y, int row, int col) {
        int answer = 1;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {x, y});
        visited[x][y] = true;


        while(!stack.isEmpty()) {
            int [] current = stack.pop();
            int nx = current[0];
            int ny = current[1];

            for(int k =0; k< 4; k++) {
                int cx = nx + dx[k];
                int cy = ny + dy[k];

                if (cx >= 0 && cy >= 0 && cx < row && cy < col && !visited[cx][cy] && field[cx][cy] == 0) {

                    stack.push(new int[]{cx, cy});
                    visited[cx][cy] = true;
                    answer++;
                }
            }
        }

        return answer;
    }

    // 영역 설정(사각형)
    private static void settingField(int lowX, int lowY, int upX, int upY, int[][] field){

        for(int i = lowY; i < upY; i++) {
            for (int j = lowX; j < upX; j++) {
                field[j][i] = 1;
            }
        }
    }
}
