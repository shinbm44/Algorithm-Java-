package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver2559 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        String[] input = br.readLine().split(" ");
        int days = Integer.parseInt(input[0]);
        int step = Integer.parseInt(input[1]);

        int [] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = 0;

        for(int i =0; i<step; i++){
            result += temp[i];
        }

        int start =0;
        int end = step -1;

        int maxSum = cal(days ,result, start, end, temp);

        System.out.println(maxSum);

    }

    private static int cal(int days, int result, int start, int end, int[] temp) {
        int sum = result;


        while(end < days-1){
            sum += temp[++end];
            sum -= temp[start++];

            result = Math.max(sum, result);

        }

        return result;
    }
}
