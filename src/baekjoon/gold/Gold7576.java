package baekjoon.gold;

import java.io.*;
import java.util.*;

public class Gold7576 {

    static Queue<Node> Q = new LinkedList<>();
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");

        // 컬럼 숫자
        int cols = Integer.parseInt(input[0]);
        // 행 숫자
        int rows = Integer.parseInt(input[1]);
        // 토마토 바구니
        int [][] tomato = new int[rows][cols];
        boolean [][] visited = new boolean[rows][cols];


        // 토마토 바구니 정보 및 시작점 정보
        for (int i = 0; i < rows; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                tomato[i][j] = Integer.parseInt(line[j]);
                if (tomato[i][j] == 1) {
                    Q.add(new Node(i, j, 0)); // 익은 토마토 위치를 모두 큐에 추가
                    visited[i][j] = true;
                }
            }
        }

        int result =0;

        // BFS
        while(!Q.isEmpty()) {
            Node node1 = Q.poll();

            int x1 = node1.x;
            int y1 = node1.y;
            int count1 = node1.count;

            for(int i =0; i< 4; i++) {

                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if(x2 >= 0 && x2 < rows && y2 >= 0 && y2 < cols && !visited[x2][y2] && tomato[x2][y2] == 0) {
                    Q.add(new Node(x2, y2, count1+1));
                    visited[x2][y2] = true;
                    tomato[x2][y2] = 1;
                }
            }
            result = count1;
        }

        boolean check= true;

        // 안 익은 토마토 유무 체크
        for(int i=0; i< rows; i++) {
            for(int j =0; j< cols; j++) {

                if(tomato[i][j] == 0){
                    check = false;
                    break;
                }

            }
        }

        if(check) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }




    }

    // 이동 객체 정보
    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y , int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
