package baekjoon.silver;

import java.io.*;
import java.util.*;


public class Silver16953 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        // 시작, 목표 값 받기
        long startNumber = Long.parseLong(st.nextToken());
        long targetNumber = Long.parseLong(st.nextToken());
        // bfs를 통해 값을 찾기
        long result = bfs(startNumber, targetNumber);
        //출력
        System.out.println(result);
    }

    private static long bfs(long startNumber, long targetNumber) {
        Queue<long[]> queue = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();

        queue.offer(new long [] {startNumber, 0});
        visited.add(startNumber);

        while(!queue.isEmpty()) {
            long[] cur = queue.poll();
            long curNumber = cur[0];
            long curValue = cur[1];

            if(curNumber == targetNumber) {
                return curValue+1;
            }
            // x2 연산
            long multiValue = curNumber * 2;
            if(multiValue <= targetNumber && !visited.contains(multiValue)) {
                visited.add(multiValue);
                queue.offer(new long[] {multiValue, curValue+1});
            }
            //  * 10 + 1 연산
            long addValue = curNumber * 10 + 1;
            if(addValue <= targetNumber && !visited.contains(addValue)) {
                visited.add(addValue);
                queue.offer(new long[] {addValue, curValue+1});
            }
        }



        return -1;
    }
}
