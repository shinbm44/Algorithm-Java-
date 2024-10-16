package programmers.Lv1;
import java.util.*;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        // 오름차순 정렬
        Arrays.sort(d);
        // 배열 길이
        int leng = d.length;
        // 순회하면서 금액으로 해결 가능 여부 판단
        for(int i =0; i< leng; i++) {
            if(d[i] <= budget) {
                answer++;
                budget -= d[i];
            } else{
                break;
            }
        }

        return answer;
    }
}