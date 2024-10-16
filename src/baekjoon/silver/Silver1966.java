package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver1966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            // 테스트 케이스 정보
            st = new StringTokenizer(br.readLine());

            int [] info = new int[2];

            for(int j = 0; j < 2; j++) {
                info[j] = Integer.parseInt(st.nextToken());
            }

            // 전체 길이
            int contentLength = info[0];
            // 현재 위치
            int now = info[1];

            // 큐 정보
            st = new StringTokenizer(br.readLine());


            // 큐 객체
            Queue<Node> q = new LinkedList<>();

            // 큐에 정보 넣기
            for(int j =0; j < contentLength; j++) {
                q.add(new Node(Integer.parseInt(st.nextToken()),j));
            }

            // 결과 카운트 변수
            int count =0;

            // 큐 순회하면서 로직 수행
            while(!q.isEmpty()) {
                Node cur = q.poll();
                boolean max = true;

                // 뒤에 더 큰 값이 있나 확인
                for(Node n : q) {
                    if(cur.val < n.val) {
                        max = false;
                        break;
                    }
                }
                // 없는 경우, 순서가 일치하면 카운트 출력 or
                if(max) {
                    count++;
                    if(cur.order == now) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    q.add(cur);
                }
            }
        }
    }

    static class Node {
        int val;
        int order;

        Node(int val, int order) {
            this.val = val;
            this.order = order;
        }
    }
}
