package programmers.Lv3;

public class 네트워크  {

    // union-find 풀이
    static int [] link;

    public int solution(int n, int[][] computers) {

        link = new int [n];
        // link 배열 생성(일단 자기 자신을 바라보도록)
        for(int i =0; i< n; i++) {
            link[i] =i;
        }
        // 순회하면서 연결된 경우
        for(int i =0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                if(computers[i][j] == 1) {
                    union(i,j);
                }
            }
        }

        int answer =0;
        for(int i =0; i<n; i++) {
            if(link[i] == i){
                answer++;
            }
        }


        return answer;
    }
    // union 로직
    private void union(int i , int j) {
        // 어떤 집합에 속한지 찾는 로직
        int x = find(i);
        int y = find(j);

        if(x != y) {
            if(x < y) {
                link[y] =x;
            } else {
                link[x] =y;
            }
        }
    }
    // link 배열에 있는 자신이 속한 집합 찾기
    private int find(int x) {
        if(link[x] == x) {
            return link[x];
        }
        return find(link[x]);
    }
}