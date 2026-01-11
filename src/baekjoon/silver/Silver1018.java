package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1018 {

    public static boolean [][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        arr = new boolean[row][col];


        /* W이면 true값을
        *  B이면 false값을
        * */
        for(int i =0; i <  row; i++){
            String str = br.readLine();

            for(int  j =0; j <  col; j++){
                if(str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }


        int rowNum = row - 7;
        int colNum = col - 7;

        for(int  i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                checkCount(i,j);
            }
        }

        System.out.println(min);
    }

    private static void checkCount(int x, int y) {

        int xRange = x + 8;
        int yRange = y + 8;
        int count = 0;
        /* W이면 true값을
         *  B이면 false값을
         * */

        boolean Flag = arr[x][y];

        for (int i =x;  i < xRange; i++) {
            for (int j =y; j < yRange; j++) {

                /* 다음 색이 다르다면, 적절하지 않으므로 변경 */
                if(arr[i][j] != Flag) {
                    count++;
                }

                Flag = !Flag;
            }

            Flag = !Flag;
        }

        count = Math.min(count, 64 - count);

        min = Math.min(min, count);

    }
}
