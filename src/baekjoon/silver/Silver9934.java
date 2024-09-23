package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver9934 {
    public static void main(String[] args) throws Exception {
        // 입력 객체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 트리 깊이
        int layer = Integer.parseInt(br.readLine());
        // 각 노드의 값 배열
        String [] NodeItem = br.readLine().split(" ");
        // 이진 트리 노드 값을 담을 배열
        List<ArrayList<Integer>> BSTList = new ArrayList<>();
        // 트리 계층 만큼 이중 리스트x
        for(int i =0; i<layer; i++) {
            BSTList.add(new ArrayList<>());
        }
        // 이진 트리 노드 상태 이중 배열에 담는 메소드
        makeNode(0, NodeItem, NodeItem.length,0 ,layer, BSTList);
        // 값 출력을 위한 객체 생성
        StringBuilder sb = new StringBuilder();

        for (int i =0; i<layer; i++) {
            int layerLength = BSTList.get(i).size();
            for(int j =0; j<layerLength; j++) {
                sb.append(BSTList.get(i).get(j)).append(" ");

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void makeNode(int startIndex, String[] nodeItem, int endIndex, int depth, int layer, List<ArrayList<Integer>> BSTList) {

        if (startIndex > endIndex || depth >= layer) {
            return;
        }

        int mid = (startIndex + endIndex)/2;

        BSTList.get(depth).add(Integer.parseInt(nodeItem[mid]));


        makeNode(startIndex, nodeItem, mid-1, depth + 1, layer, BSTList);
        makeNode(mid+1, nodeItem, endIndex, depth + 1, layer, BSTList);

    }
}
