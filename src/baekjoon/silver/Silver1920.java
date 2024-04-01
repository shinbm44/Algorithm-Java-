package baekjoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver1920 {

    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());


        arr = new int[num];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for(int i =0; i< num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int num2 = Integer.parseInt(reader.readLine());


        st = new StringTokenizer(reader.readLine());

        StringBuilder sb = new StringBuilder();


        for (int i =0; i< num2; i++ ) {
            if(binarySearch(Integer.parseInt(st.nextToken()))>= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }

        }

        System.out.println(sb);

    }

    public static int binarySearch(int number) {

        int start =0;
        int end = arr.length - 1;



       while(start <= end) {

           int mid = (start + end) /2 ;

           if ( number < arr[mid] ) {
               end = mid -1;
           }

           else if (number > arr[mid]) {
               start = mid +1;
           }

           else {
               return mid;
           }

       }
        return  -1;
    }
}
