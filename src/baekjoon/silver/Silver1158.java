package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver1158 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int lenth = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        List<Integer> arr = new LinkedList<>();

        settingArray(lenth, arr);

        StringBuilder sb = new StringBuilder("<");
        int index = 0;

        while (!arr.isEmpty()) {
            index = (index + range-1) % arr.size();
            sb.append(arr.remove(index));

            if(!arr.isEmpty()){
                sb.append(", ");
            }
        }

        sb.append(">");

        System.out.println(sb);

    }

    private static void settingArray(int lenth, List<Integer> arr) {
        for (int i =0; i<lenth; i++) {
            arr.add(i+1);
        }
    }
}
