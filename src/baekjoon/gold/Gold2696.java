package baekjoon.gold;

import java.util.*;
import java.io.*;

public class Gold2696 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> ascPq = new PriorityQueue<>();
    static PriorityQueue<Integer> descPq = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int testCase = Integer.parseInt(br.readLine());

        for(int i =0; i< testCase; i++){
            int arraySize = Integer.parseInt(br.readLine());
            sb.append((int)(arraySize/2) + 1).append("\n");

            ascPq.clear();
            descPq.clear();

            calculateMiddleNumber(arraySize);

        }
        System.out.println(sb.toString());
    }

    private static void calculateMiddleNumber(int arraySize) throws Exception {

        int readCnt = 0 ;
        int printCnt = 0 ;

        while (readCnt < arraySize) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens() && readCnt < arraySize) {

                int inputItem = Integer.parseInt(st.nextToken());
                readCnt++;

                insertAndBalance(inputItem);

                // 홀수번째 읽을 때마다 중앙값 출력
                if (readCnt % 2 == 1) {
                    sb.append(descPq.peek()).append(" ");
                    printCnt++;

                    if (printCnt % 10 == 0) sb.append("\n");
                }
            }
        }
    }

    private static void insertAndBalance(int inputItem) {

        // 어디에 넣을지 결정
        if (descPq.isEmpty() || inputItem <= descPq.peek()) {
            descPq.add(inputItem);
        } else {
            ascPq.add(inputItem);
        }

        // 크기 균형 맞추기
        if (descPq.size() > ascPq.size() + 1) {
            ascPq.add(descPq.poll());
        } else if (descPq.size() < ascPq.size()) {
            descPq.add(ascPq.poll());
        }
    }
}
