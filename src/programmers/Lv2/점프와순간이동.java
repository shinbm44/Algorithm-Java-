package programmers.Lv2;

public class 점프와순간이동 {

    int ans = 0;

    public int solution(int n) {

        while (n>0) {
            if (n % 2 == 1) {
                ans++;
                n--;
            } else {
                n = n/2;
            }
        }
        return ans;
    }
}
