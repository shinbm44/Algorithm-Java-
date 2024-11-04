package programmers.Lv2;

import java.util.*;

public class 게임맵최단거리  {

    Queue<Node> q = new LinkedList<>();
    // 좌, 상, 우, 하 이동
    int [] rowPlus = {-1, 0, 1, 0};
    int [] colPlus = {0, 1, 0, -1};

    public int solution(int[][] maps) {


        // 가로 길이
        int lrow = maps.length;
        // 세로 길이
        int lcol = maps[0].length;
        // 방문 체크 이중 배열
        boolean [][] visited = new boolean [lrow][lcol];

        // 상대 진영이 막혀 있다면 그냥 -1 리턴
        // if(maps[lrow-2][lcol-1] == 0 && maps[lrow-1][lcol-2] ==0) {
        //     return -1;
        // }
        // 시작 객체
        Node node = new Node(0,0,1);
        q.add(node);
        visited[0][0] = true;

        // bfs
        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.row == lrow-1 && now.col == lcol-1){
                return now.count;
            }

            for(int i =0; i<4; i++) {
                int dx = now.row + rowPlus[i];
                int dy = now.col + colPlus[i];

                if(dx >= 0 && dy >= 0 && dx < lrow && dy <lcol  && maps[dx][dy] == 1 && !visited[dx][dy] ) {
                    visited[dx][dy] = true;
                    q.add(new Node(dx, dy, now.count+1));
                }
            }
        }

        return -1;
    }

    // 움직이는 객체
    class Node {
        int row;
        int col;
        int count;
        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
