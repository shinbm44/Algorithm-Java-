package programmers.Lv2;

import java.util.*;


public class 방금그곡 {
    // m은 기억하는 멜로디
    public String solution(String m, String[] musicinfos) {
        String answer = "";

        // 음악 정보 배열 길이
        int infoleng = musicinfos.length;

        List<infoNode> infoNodes = new LinkedList();

        // 음악 정보 객체 생성 후 리스트에 넣기
        for(int i =0; i< infoleng; i++) {
            // 음악 정보 쪼개기
            String [] info = musicinfos[i].split(",");
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");


            // 시작 시간
            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            // 종료 시간
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            // 노래 제목
            String musicTitle = info[2];
            // 노래 정보
            String musicInfo = info[3];

            infoNodes.add((new infoNode(i, endTime-startTime, musicTitle, musicInfo)));
        }

        // 가장 긴 재생 시간
        int maxPlayTime = 0;
        // 정답 노래 제목
        String maxTitleMusic = "";
        // 기억한 멜로디 변환
        String transformedM = transformMelody(m);


        // 리스트 순회하며 로직 구현
        for(infoNode info : infoNodes) {
            StringBuilder sb = new StringBuilder();
            // 음악 멜로드 길이
            String musicInfo = transformMelody(info.info);
            int musicLength = musicInfo.length();

            // 음악이 재생되는 동안 멜로디 생성
            for (int i = 0; i < info.playTime; i++) {
                // 음악 정보의 멜로디를 반복
                sb.append(musicInfo.charAt(i % musicLength));
            }

            // 정보로 만든 멜로디 변환
            String generatedMelody = transformMelody(sb.toString());


            // 사용자가 기억한 멜로디 m과 일치하면
            if (generatedMelody.contains(transformedM)) {
                // 현재 음악의 재생 시간이 가장 긴 경우 갱신
                if (info.playTime > maxPlayTime) {
                    maxPlayTime = info.playTime;
                    maxTitleMusic = info.title;
                }
            }
        }

        return maxTitleMusic.isEmpty() ? "(None)" : maxTitleMusic;
    }


    // 멜로디를 변환
    // 문제에 오류있음 -> B# 추가해야 34번 케이스 해결
    private String transformMelody(String melody) {
        return melody.replace("C#", "H")
                .replace("D#", "I")
                .replace("F#", "J")
                .replace("G#", "K")
                .replace("A#", "L")
                .replace("B#", "M");
    }


    // 음악 정보 객체
    class infoNode {
        int order;
        int playTime;
        String title;
        String info;
        boolean check = false;

        public infoNode(int order, int playTime, String title, String info){
            this.order = order;
            this.playTime = playTime;
            this.title = title;
            this.info = info;
        }
    }
}