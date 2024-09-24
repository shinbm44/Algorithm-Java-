package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver2606 {
    // 그래프 객체
    static class graph{
        // 연결된 노드 값 결과
        static int count=0;
        // 노드 객체(인접 리스트 사용)
        static class Node{
            int value;
            List<Node> adjacent;
            boolean visited;
            Node(int value){
                this.value = value;
                adjacent = new LinkedList<Node>();
                visited = false;
            }
        }
        // 노드 배열
        Node [] nodes;
        // 그래프 생성자
        public graph(int n) {
            nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i+1);
            }
        }
        // 그래프 연결 메소드
        void addEdge(int v, int w){
            Node n1 = nodes[v-1];
            Node n2 = nodes[w-1];
            if(!n1.adjacent.contains(n2)){
                n1.adjacent.add(n2);
            }
            if(!n2.adjacent.contains(n1)){
                n2.adjacent.add(n1);
            }
        }
        // dfs 탐색 (결과값 반환을 위한 )
        int dfs(int index) {
            index--;
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            root.visited = true;
            while(!stack.isEmpty()){
                Node r = stack.pop();
                count++;
                for(Node node : r.adjacent) {
                    if(!node.visited){
                        node.visited = true;
                        stack.push(node);
                    }
                }
            }
            return count-1;
        }
    }

    public static void main(String [] args ) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computers = Integer.parseInt(br.readLine());
        int couple = Integer.parseInt(br.readLine());

        graph graph = new graph(computers);

        for (int i = 0; i < computers; i++) {
            graph.nodes[i] = new graph.Node(i+1);
        }


        for(int i =0; i < couple; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.addEdge(a,b);
        }

        int result = graph.dfs(1);

        System.out.println(result);
    }
}
