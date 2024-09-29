package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Silver10451 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int testCase = Integer.parseInt(br.readLine());
        // 사이클 확인 메서드 호출

        for(int i=0; i<testCase; i++) {
            int result = checkCycle();
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int checkCycle() throws Exception {
        // 결과값
        int count = 0;

        // 배열 길이
        int length = Integer.parseInt(br.readLine());

        // 배열 초기화
        input = new int[length+1];

        // 배열 상태 초기화
        for (int i = 1; i < length+1; i++) {
            input[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        // union 메소드를 통해서 연결상태 관리 배열 세팅
        for (int i = 1; i < length+1; i++) {
            union(i, Integer.parseInt(st.nextToken()));
        }

        // 사이클 갯수 확인 및 출력
        Set<Integer> set  = new HashSet<>();
        for (int i = 1; i < length+1; i++) {
            set.add(find(i));
        }

        count = set.size();
        return count;
    }

    private static void union(int from, int to) {
        from = find(from);
        to = find(to);

        if (from == to) {
            return;
        }
        if(from <= to) {
            input[to] = from;
        } else {
            input[from] = to;
        }
    }

    private static int find(int x) {
        if(x == input[x]) { return x;}
        return find(input[x]);
    }
}
