package baekjoon.gold;

import java.io.*;


public class Gold1976 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [] parent;
    static int [][] map;
    static String [] route;

    public static void main(String[] args) throws Exception {

        int cityNumber = Integer.parseInt(br.readLine());
        int plan = Integer.parseInt(br.readLine());

        parent = new int[cityNumber+1];
        map = new int[cityNumber][cityNumber];
        int parentLength = parent.length;

        // 부모 노드 초기화(자기 자신을 바라보도록)
        for(int i =0; i<parentLength; i++ ) {
            parent[i] = i;
        }
        // 각 경로 입력에 따른 union처리
        for(int i =0; i<cityNumber; i++) {
            String [] input = br.readLine().split(" ");

            for(int j =0; j<cityNumber; j++) {
                map[i][j] = Integer.parseInt(input[j]);

                if (map[i][j] == 1) {
                    // 도시 번호는 1부터 시작
                    union(i + 1, j + 1);
                }
            }
        }
        // 여행 경로
        route = br.readLine().split(" ");

        boolean check =false;
        int checkroad = find(Integer.parseInt(route[0]));

        for(int i =0; i<plan; i++) {
            int k = Integer.parseInt(route[i]);

            if(checkroad != find(k)) {
                check = true;
                break;
            }
        }

        if(check) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
    // union 메서드
    public static void union(int i , int j) {
        int x = find(i);
        int y = find(j);

        if(x == y) {
            return;
        }

        if(x > y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
    // find 메서드
    public static int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
}
