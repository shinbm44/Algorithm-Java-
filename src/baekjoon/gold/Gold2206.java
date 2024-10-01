package baekjoon.gold;

import java.util.*;
import java.io.*;

public class Gold2206 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [][] field;
    static boolean [][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int row, col;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        // 초기화
        field = new int [row][col];
        visited = new boolean [row][col][2];

        for(int i =0; i<row; i++) {
            String line = br.readLine();
            for(int j =0; j<col; j++) {
                field[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

    }
    private static int bfs() {
        // 결과값
        int result =0;
        Queue <Node> q = new ArrayDeque<>();
        // 시작 지점
        visited[0][0][0] =true;
        q.offer(new Node(0,0,1,0));

        // bfs 탐색
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            // 만약 해당 지점에 도달했으면 최저 경로 값 return
            if(x == row-1 && y == col-1) {
                return result = cur.dist;
            }

            for(int i =0; i<4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                // 범위 안에 있는 지 확인
                if(cx>=0 && cx<row && cy>=0 && cy<col){
                    // 벽이 아닌 경우
                    if(field[cx][cy]==0 && !visited[cx][cy][cur.boom]) {
                        visited[cx][cy][cur.boom] =true;
                        q.offer(new Node(cx,cy,cur.dist+1,cur.boom));
                    // 벽이 있는 경우
                    } else {
                        // 한번만 부셔야하고 방문 기록이 없는지 확인
                        if(cur.boom==0 && !visited[cx][cy][cur.boom]) {
                            visited[cx][cy][cur.boom+1] =true;
                            q.offer(new Node(cx,cy,cur.dist+1,cur.boom+1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        int x = 0;
        int y = 0;
        // 거리 측정을 위한 변수
        int dist = 0;
        // 벽 부순 것을 check하기 위한 변수
        int boom = 0;
        Node(int x, int y, int dist, int boom) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.boom = boom;
        }
    }
}
