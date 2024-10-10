package programmers.Lv2;

import java.util.*;

public class 롤케이크자르기 {

    public int solution(int[] topping) {
        int count = 0;
        int length = topping.length;

        // 왼쪽과 오른쪽의 토핑 종류를 저장할 Set
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();

        // 오른쪽의 각 토핑 개수를 저장할 배열
        int[] rightCount = new int[10001]; // topping의 원소는 10,000 이하의 자연수

        // 초기 상태: 모든 토핑을 오른쪽에 배치
        for (int t : topping) {
            rightSet.add(t);
            rightCount[t]++;
        }

        // 왼쪽으로 하나씩 이동하면서 확인
        for (int i = 0; i < length; i++) {
            int t = topping[i];

            // 왼쪽에 토핑 추가
            leftSet.add(t);

            // 오른쪽에서 토핑 제거
            rightCount[t]--;
            if (rightCount[t] == 0) {
                rightSet.remove(t);
            }

            // 양쪽의 토핑 종류 수가 같은지 확인
            if (leftSet.size() == rightSet.size()) {
                count++;
            }
        }

        return count;
    }
}


