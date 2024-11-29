package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Silver2178 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    // 노드 클래스 정의
    static class Node {
        int x, y, move;

        public Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public static void main(String[] args) throws Exception {
        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        // 지도 정보 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // BFS 실행
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int startX, int startY) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 1)); // 시작 지점
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 도착 지점에 도달한 경우
            if (current.x == N - 1 && current.y == M - 1) {
                return current.move;
            }

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 범위 체크 및 이동 가능 여부 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, current.move + 1));
                }
            }
        }

        return -1;
    }
}