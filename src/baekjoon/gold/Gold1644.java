package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Gold1644 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int input = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        list = makeList(list, input);

        int count = calPrime(list, input);

        System.out.println(count);

    }

    private static int calPrime(List<Integer> primes, int input) {
        if (primes.isEmpty()) return 0;
        if (input == 2) return 1;

        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        int len = primes.size();

        while (end < len) {
            // 현재 구간 합이 input보다 작으면 end를 늘려서 더하기
            if (sum < input) {
                sum += primes.get(end++);
            }
            // 현재 구간 합이 input보다 크거나 같으면 start를 늘려서 빼기
            else {
                sum -= primes.get(start++);
            }

            // input과 같아지면 카운트 증가
            if (sum == input) {
                count++;
            }
        }
        while(true) {
            if(sum == input){
                count++;
                return count;
            }
            sum -= primes.get(start++);
            if(start == end){
                break;
            }
        }


        return count;
    }

    // 소수 리스트 만들기
    private static List<Integer> makeList(List<Integer> list, int input) {

        if(input < 2){
            return new ArrayList<>();
        }


        boolean [] checkList = new boolean[input+1];
        List<Integer> result = new ArrayList<>();

        checkList[0] = checkList[1] = false;

        for(int i =2; i<=input; i++) {
            checkList[i] = true;
        }

        for(int i = 2; i * i <= input; i++) {
            if(checkList[i]) {
                for(int j = i * i; j <= input; j += i) {
                    checkList[j] = false;
                }
            }
        }

        for (int i = 2; i <= input; i++) {
            if (checkList[i]) {
                result.add(i);
            }
        }
        return result;

    }
}