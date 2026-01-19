package baekjoon.gold;

import java.util.*;
import java.io.*;

public class Gold1202 {

    static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Integer> resultValue = new  PriorityQueue<>(Collections.reverseOrder());
    static long result = 0;


    public static void main(String[] args) throws IOException {

        String [] rangeNum = br.readLine().split(" ");

        int itemRange = Integer.parseInt(rangeNum[0]);
        int bagRange = Integer.parseInt(rangeNum[1]);


        item []  items = new item[itemRange];

        //보석 객체 insert
        for(int i = 0; i < itemRange; i++){

            String [] tempval = br.readLine().split(" ");
            item temp = new item(Integer.parseInt(tempval[0]), Integer.parseInt(tempval[1]));
            items[i] = temp;
        }

        Arrays.sort(items, new Comparator<item>() {

            @Override
            public int compare(item o1, item o2) {
                if(o2.weight ==  o1.weight){

                    return o2.value - o1.value;
                }

                return o1.weight - o2.weight;
            }
        });

        int [] bags  = new int[bagRange];
        // 가방 무게 insert
        for(int i =0; i<bagRange ;i++) {
            int bagWeight =Integer.parseInt(br.readLine());
            bags[i] = bagWeight;
        }
        // 가방 수용 무게 오름차순으로 정렬
        Arrays.sort(bags);



        // 최대 무게 메소드 호출
        result = calculateMaxValue(items, bags);


        System.out.println(result);
    }


    // 최대 가치 계산 메서드
    private static long calculateMaxValue(item[] items, int[] bag) {

        int itemLength = items.length;
        int idx = 0;

        for(int bagItem : bag) {
            while (idx < itemLength && items[idx].weight <= bagItem) {
                resultValue.add(items[idx].value);
                idx++;
            }

            if (!resultValue.isEmpty()) {
                result += resultValue.poll();
            }
        }
        return result;
    }
}

class item {

    int weight;
    int value;
    item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}