package baekjoon.gold;
import java.io.*;
import java.util.*;

public class Gold4195 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            // 친구 이름을 인덱스로 변환하기 위한 맵
            HashMap<String, Integer> linkMap = new HashMap<>();
            int num = 0;

            // 친구 관계 수
            int linkNumber = Integer.parseInt(br.readLine());

            // 부모 노드 배열과 그룹 크기 배열 초기화
            int[] parent = new int[linkNumber * 2];
            int[] size = new int[linkNumber * 2];

            // 초기화
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                // 초기 그룹 크기는 1
                size[i] = 1;
            }

            for (int j = 0; j < linkNumber; j++) {
                String[] friend = br.readLine().split(" ");
                String friend1 = friend[0];
                String friend2 = friend[1];

                // 새로운 친구를 발견하면 번호를 부여
                if (!linkMap.containsKey(friend1)) {
                    linkMap.put(friend1, num++);
                }
                if (!linkMap.containsKey(friend2)) {
                    linkMap.put(friend2, num++);
                }

                // 친구 번호 가져오기
                int num1 = linkMap.get(friend1);
                int num2 = linkMap.get(friend2);

                // 두 친구를 같은 그룹으로 병합
                union(parent, size, num1, num2);

                // 그룹 크기 출력
                System.out.println(size[find(parent, num1)]);
            }
        }
    }

    // Find 연산 (경로 압축)
    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    // Union 연산
    private static void union(int[] parent, int[] size, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            // 작은 트리를 큰 트리 아래로 병합
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }
}