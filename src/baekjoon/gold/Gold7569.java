package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Gold7569 {

    static Queue<Node> Q = new LinkedList<Node>();
    static boolean [][][] visited;
    static int [][][] map;
    static int [] rows = {0, 1, 0, -1, 0, 0};
    static int [] cols = {-1, 0, 1, 0, 0, 0};
    static int [] layers = {0, 0, 0, 0, 1, -1};
    static int col;
    static int row;
    static int layer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] info = br.readLine().split(" ");

        col = Integer.parseInt(info[0]);
        row = Integer.parseInt(info[1]);
        layer = Integer.parseInt(info[2]);

        map = new int[layer][row][col];
        visited = new boolean[layer][row][col];

        // 초기 세팅
        for(int i = 0; i < layer; i++) {
            for(int j = 0; j < row; j++) {
                String [] input = br.readLine().split(" ");
                for(int k = 0; k < col; k++) {
                    map[i][j][k] = Integer.parseInt(input[k]);

                    if(map[i][j][k] == 1) {
                        Q.add(new Node(i, j, k, 0));
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    // bfs 로직
    private static int bfs() {
        int result = 0;

        while(!Q.isEmpty()) {
            Node cur = Q.poll();

            int curLayer = cur.z; // z 좌표
            int curRow = cur.y;   // y 좌표
            int curCol = cur.x;   // x 좌표
            int count = cur.count;

            for(int i = 0; i < 6; i++) {
                int dz = curLayer + layers[i];
                int dy = curRow + rows[i];
                int dx = curCol + cols[i];

                if (dz >= 0 && dz < layer && dy >= 0 && dy < row && dx >= 0 && dx < col && !visited[dz][dy][dx] && map[dz][dy][dx] == 0) {
                    Q.add(new Node(dz, dy, dx, count + 1));
                    map[dz][dy][dx] = 1;
                    visited[dz][dy][dx] = true;
                    result = count + 1;
                }
            }
        }

        // 확인 과정: 익지 않은 토마토가 남아 있는지 체크
        for(int i = 0; i < layer; i++) {
            for(int j = 0; j < row; j++) {
                for(int k = 0; k < col; k++) {
                    // 익지 않은 토마토가 있다면
                    if(map[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return result;
    }

    static class Node {
        int z;
        int y;
        int x;
        int count;

        public Node(int z, int y, int x, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}