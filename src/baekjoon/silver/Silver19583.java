package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver19583 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] times = br.readLine().split(" ");

        int start = hourToMinute(times[0]);
        int end = hourToMinute(times[1]);
        int endSt = hourToMinute(times[2]);

        // 멤버별 채팅 시간을 담아줄 map
        Map <String, List<Integer>> chatMap = new HashMap<>();
        String input = "";

        // 채팅 기록 담기
        while((input = br.readLine()) != null) {
            String [] chat = input.split(" ");
            // 시간을 정수로 변경하기
            int chatTiem = hourToMinute(chat[0]) ;
            // 만약 이전에 입력이 없으면 새로 생성 후 채팅 시간 담기
            if(!chatMap.containsKey(chat[1])) {
                chatMap.put(chat[1], new ArrayList<>());
                chatMap.get(chat[1]).add(chatTiem);
            } else {
                chatMap.get(chat[1]).add(chatTiem);
            }
        }
        // 참석자 학인
        System.out.println(checkTime(chatMap, start, end,endSt));


    }

    private static int hourToMinute(String time) {
        String [] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    private static int checkTime(Map<String, List<Integer>> chatMap, int start, int end, int endSt) {

        int count = 0;
        for(Map.Entry<String, List<Integer>> entry : chatMap.entrySet()) {

            List<Integer> times = entry.getValue();
            boolean enter = false;
            boolean left = false;

            for(int time : times) {
                if (time <= start) {
                    enter = true;
                }
                if (time >= end && time <= endSt) {
                    left = true;
                }
                if (enter && left) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}