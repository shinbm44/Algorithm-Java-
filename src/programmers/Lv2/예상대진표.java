package programmers.Lv2;

public class 예상대진표 {
    public int solution(int n, int a, int b){
        int answer = 0;

    /*
        1 2 / 3 4 / 5 6 / 7 8 / 9 10 / 11 12 / 13 14 / 15 16
        0 1   1 2   2 3   3 4   4  5   5  6    6  7    7  8

         1     2     3     4     5       6       7       8     -----  1

            1          2             3            4            -----  2

                  1                         2                  -----  3

                                1                              -----  4
    */

        while(true) {
            // 순서값을 지정
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);

            answer++;
            // 순서가 같아지면 끝낸다.
            if(a == b) {
                break;
            }
        }
        return answer;
    }
}
