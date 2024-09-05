package baekjoon.silver;

import java.util.*;
import java.io.*;


public class Silver2002 {

    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int carNum = Integer.parseInt(br.readLine());
        // 진입 차량 입력 받기
        HashMap<String, Integer> inputCars = new HashMap<>();

        for(int i =0; i < carNum; i++ ){
            inputCars.put(br.readLine(), i);
        }

        // 비교 로직 ( 추월 )
        compareOrder(inputCars, br, carNum);
    }


    private static void compareOrder( HashMap<String, Integer> inputCars, BufferedReader br, int carNum) throws Exception {
        // 추월 차량 숫자 집계 변수
        int result = 0 ;

        List <Integer> outCars = new ArrayList<>();

        // 들어온 차의 인덱스값(순서)를 기준으로 나가는 차의 순서값으로 저장
        for(int i=0; i< carNum; i++) {
            outCars.add(inputCars.get(br.readLine()));
        }

        // 추월 차량 숫자 확인
        for(int i = 0; i < carNum; i++ ) {
            for(int j = i+1; j < carNum; j++) {
                if(outCars.get(i) > outCars.get(j)) {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);

    }

}
