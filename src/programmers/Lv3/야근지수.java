package programmers.Lv3;

import java.util.*;

public class 야근지수 {
    public long solution(int n, int[] works) {
        // 우선순위 큐를 사용( 내림차순으로 )
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 배열 길이
        int leng = works.length;
        // 배열 원소 우선순위 큐에 넣어주기
        for(int i =0; i<leng; i++) {
            pq.offer(works[i]);
        }
        // n 만큼 가장 큰 수를 1씩 줄여주고 다시 큐에 넣어주기
        while(n > 0) {

            int topWork = pq.poll();

            if(topWork == 0 ) {
                break;
            }

            topWork -= 1;
            pq.offer(topWork);
            n--;
        }

        long answer = 0;
        // 큐에 있는 값들의 제곱의 합을 구하기
        for(int work : pq ) {
            answer += work * work;
        }

        return answer;
    }
}
