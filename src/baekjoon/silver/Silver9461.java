package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver9461 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());

        for(int i =0; i<testCase; i++) {

            int n = Integer.parseInt(br.readLine());
            long [] dp = new long[101];
            dp[1] =1;
            dp[2] =1;
            dp[3] =1;
            dp[4] =2;
            if(n<=4) {
                System.out.println(dp[n]);
                continue;
            }

            for(int j = 5; j<=n; j++) {
                dp[j] = dp[j-2] + dp[j-3];
                if(j == n) {
                    System.out.println(dp[j]);
                }
            }
        }
    }
}
