package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver10816 {

    public static int[] arr;


    public static void main(String[] args) throws IOException {

        // 1 첫번째 행 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        // 2 두번째 행 입력받기
        int num2 = Integer.parseInt(br.readLine());

        int[] arr2 = new int[num2];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < arr2.length; i++) {

            sb.append(upper(arr2[i], arr) - lower(arr2[i], arr)).append(" ");

        }

        System.out.println(sb);

    }

    private static int lower(int i, int[] arr) {

        int start = 0;
        int end = arr.length;

        while(start < end) {

            int mid = (start + end) /2 ;

            if(i <= arr[mid] ) {
                end = mid;
            }
            else {
                start = mid + 1;
            }

        }

        return start;
    }


    private static int upper(int i, int[] arr) {
        int start = 0;
        int end = arr.length;

        while(start < end) {

            int mid  = (start + end) /2;

            if( i < arr[mid]) {
                end = mid;
            }
            else {
                start = mid+1;
            }

        }

        return start;
    }
}
