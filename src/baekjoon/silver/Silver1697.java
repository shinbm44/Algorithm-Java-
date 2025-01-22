package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Silver1697 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean [] check = new boolean[100001];
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        String [] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        int count =0;

        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                int now = q.poll();

                if (now == end) {
                    System.out.println(count);
                    return;
                }

                int[] next = {now + 1, now - 1, now * 2};

                for (int cur : next) {
                    if (cur >= 0 && cur <= 100000 && !check[cur]) {
                        q.add(cur);
                        check[cur] = true;
                    }
                }
            }
            count++;
        }
    }
}

