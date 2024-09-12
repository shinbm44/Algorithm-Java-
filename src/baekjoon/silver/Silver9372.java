package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver9372 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int testcase = Integer.parseInt(br.readLine());


        for (int i =0; i< testcase; i++) {
            String [] firstState = br.readLine().split(" ");
            int answer = searchMinNumber(firstState[0], firstState[1], br);

            sb.append(answer).append("\n");

        }
        System.out.println(sb);

    }

    private static int searchMinNumber(String firstState, String secondState, BufferedReader br) throws Exception {
        Map <String, List<String>> graph = new HashMap<>();

        int loopNumber = Integer.parseInt(secondState);

        //트리 형태로 저장하기 위한 map
        for (int i =0; i< loopNumber; i++) {
            String [] input = br.readLine().split(" ");

            graph.putIfAbsent(input[0], new ArrayList<>());
            graph.get(input[0]).add(input[1]);

            graph.putIfAbsent(input[1], new ArrayList<>());
            graph.get(input[1]).add(input[0]);
        }

        // 결과 값을 위한 변수
        int count =0;

        Queue<String> resultQueue = new ArrayDeque<>();
        Queue<String> queue = new ArrayDeque<>();

        // 시작 값
        String start = graph.keySet().iterator().next();
        // 시작 값 세팅
        queue.offer(start);
        resultQueue.offer(start);

        // 탐색
        while(!queue.isEmpty()){

            String current = queue.poll();

            List<String> values = graph.get(current);

            for(String value : values) {
                if(!resultQueue.contains(value)){
                    resultQueue.add(value);
                    queue.add(value);
                    count++;
                }
            }
        }

        return count;
    }
}
