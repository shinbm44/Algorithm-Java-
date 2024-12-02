package programmers.Lv2;

public class 땅따먹기 {

    int solution(int[][] land) {
        int answer = 0;

        int leng = land.length;
        // 각 행에 따른 최고 큰 수의 덧셈 기억
        for(int i= 1; i<leng; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));

        }
        for(int i =0; i<4; i++) {
            answer = Math.max(land[leng-1][i], answer);
        }

        return answer;
    }
}
