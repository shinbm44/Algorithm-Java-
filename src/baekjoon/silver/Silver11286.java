package baekjoon.silver;

import java.util.*;
import java.io.*;
import java.math.*;

public class Silver11286 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Number> pq;


    public static void main(String [] args) throws IOException {

        int rangeNum = Integer.parseInt(br.readLine());

        pq = new PriorityQueue(rangeNum, comparator);

        for(int i =0; i<rangeNum;i++){

            int var = Integer.parseInt(br.readLine());
            int abVar =  Math.abs(var);

            Number number = new Number(var,abVar);

            //  0이 아닌 경우
            if(var != 0) {
                pq.add(number);
            }
            // 0인 경우
            else {
                // 만약 큐가 비었다면 0 출력
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(pq.poll().realNum).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }


    public static Comparator<Number> comparator = new Comparator<Number>() {
        @Override
        public int compare(Number o1, Number o2) {
            if(o1.absoluteNum ==  o2.absoluteNum){

                return o1.realNum - o2.realNum;
            }
            else {

               return o1.absoluteNum - o2.absoluteNum;
            }
        }
    };
}

class Number {
    int realNum;
    int absoluteNum;

    public Number(int realNum, int absoluteNum) {
        this.realNum = realNum;
        this.absoluteNum = absoluteNum;
    }
}
