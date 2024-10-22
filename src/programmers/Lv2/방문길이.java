package programmers.Lv2;
import java.util.*;

class 방문길이 {

    static Set <String> route = new HashSet<>();
    static int endX = 11;
    static int endY = 11;
    static int startX = 0;
    static int startY = 0;

    public int solution(String dirs) {

        // 시작점 세팅하기
        int x = 5;
        int y = 5;

        // 이동 변수
        int dx = x;
        int dy = y;

        int leng = dirs.length();

        // 로직시작
        for(int i =0; i< leng; i++ ) {
            // 위로 이동
            if(dirs.charAt(i) == 'U' ){

                dy++;

                if(check(dx, dy)) {
                    route.add(x + "," + y + "," + dx + "," + dy);
                    route.add(dx + "," + dy + "," + x + "," + y);
                } else{
                    dy--;
                }

                x = dx;
                y = dy;

                // 왼쪽으로 이동
            } else if(dirs.charAt(i) == 'L'){

                dx--;
                if(check(dx, dy)) {
                    route.add(x + "," + y + "," + dx + "," + dy);
                    route.add(dx + "," + dy + "," + x + "," + y);
                } else{
                    dx++;
                }

                x = dx;
                y = dy;

                // 아래로 이동
            } else if(dirs.charAt(i) == 'D') {

                dy--;
                if(check(dx, dy)) {
                    route.add(x + "," + y + "," + dx + "," + dy);
                    route.add(dx + "," + dy + "," + x + "," + y);
                } else{
                    dy++;
                }

                x = dx;
                y = dy;

                // 오른쪽으로 이동
            } else {

                dx++;
                if(check(dx, dy)) {
                    route.add(x + "," + y + "," + dx + "," + dy);
                    route.add(dx + "," + dy + "," + x + "," + y);
                } else{
                    dx--;
                }

                x = dx;
                y = dy;


            }
        }
        // 전체 길이의 절반이 답
        return route.size() / 2;
    }

    // 범주 안에 있는 지 확인
    public boolean check(int dx, int dy) {
        if(startX<=dx && dx<endX && startY<= dy && dy < endY){
            return true;
        }
        return false;
    }
}