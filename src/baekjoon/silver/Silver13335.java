package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver13335 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 조건값 받기
        String [] conditions = br.readLine().split(" ");
        // 조건값 세팅
        int trucks = Integer.parseInt(conditions[0]);
        int length = Integer.parseInt(conditions[1]);
        int weight = Integer.parseInt(conditions[2]);

        // 트럭 무게
        String [] truckWeight = br.readLine().split(" ");

        // 트럭 무게 queue
        Queue <Integer> weightList = new LinkedList<>();

        // 큐에 무게값 넣어주기
        for(int i =0; i<trucks; i++){
            weightList.add(Integer.parseInt(truckWeight[i]));
        }

        // 시간 계산
        calculateTime(weightList, trucks, length, weight);

    }

    private static void calculateTime(Queue<Integer> weightList, int trucks, int length, int weight) {
        int time = 0;
        int weightSum = 0;
        // 시간 관리 큐
        Queue<Integer> bridgeTimes = new LinkedList<>();
        // 무게 관리 큐
        Queue<Integer> bridgeWeights = new LinkedList<>();

        while(!weightList.isEmpty() || !bridgeTimes.isEmpty()){

            time++;
            // 도로에 차량이 빠지는 경우
            if(!bridgeTimes.isEmpty() && time - bridgeTimes.peek() == length) {
                weightSum -= bridgeWeights.poll();
                bridgeTimes.poll();
            }
            // 도로에 차량이 들어가는 경우
            if(!weightList.isEmpty() && weightSum + weightList.peek() <= weight ){
                int truckWeight = weightList.poll();
                weightSum += truckWeight;
                bridgeWeights.offer(truckWeight);
                bridgeTimes.offer(time);
            }

        }

        System.out.println(time);
    }
}
