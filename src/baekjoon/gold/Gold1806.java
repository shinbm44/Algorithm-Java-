package baekjoon.gold;

import java.io.*;

public class Gold1806 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 기준값 잡기
        String [] input = br.readLine().split(" ");
        int maxInt = Integer.parseInt(input[1]);
        // 숫자 받기(배열)
        String [] numbers = br.readLine().split(" ");

        int numberslen = numbers.length;
        int [] list = new int[numberslen];
        // 정수 배열로 세팅
        for(int i =0; i<numberslen; i++){
            list[i] = Integer.parseInt(numbers[i]);
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;


        while (true) {
            // 목표 이상이 되는 경우 최소 길이 갱신 후 구간 줄이기
            if (sum >= maxInt) {
                min = Math.min(min, end - start);
                sum -= list[start];
                start++;
            }
            // 목표에 도달하지 못하고 끝까지 탐색한 경우 루프 종료
            else if (end == numberslen) {
                break;
            }
            // 구간을 확장하는 경우
            else {
                sum += list[end];
                end++;
            }
        }

        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
