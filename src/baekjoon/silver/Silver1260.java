package baekjoon.silver;

import java.util.*;
import java.io.*;

public class Silver1260 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 노드, 간선, 시작 노드 번호
        int nodeNumber = Integer.parseInt(input[0]);
        int edgeNumber = Integer.parseInt(input[1]);
        int startNumber = Integer.parseInt(input[2]);
        // 그래프 생성
        Graph graph = new Graph(nodeNumber);
        // 그래프에 간선 추가
        for(int i =0; i<edgeNumber; i++) {
            String [] edge = br.readLine().split(" ");
            graph.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }
        // dfs 메서드 호출
        graph.dfs(startNumber);
        // visited 초기화 메서드
        graph.clearMarks();
        System.out.println();
        // bfs 메서드 호출
        graph.bfs(startNumber);

    }

    // 그래프 객체
    static class Graph {
        // 그래프 내부의 노드 객체
        class Node {
            int data;
            List<Node> adjacent;
            boolean marked;
            Node(int data) {
                this.data = data;
                adjacent = new LinkedList<>();
                this.marked = false;
            }
        }
        // 노드들을 담아줄 리스트
        Node [] nodes;
        // 그래프 초기화
        Graph(int size) {
            nodes = new Node[size+1];
            for(int i=1; i<size+1; i++ ){
                nodes[i] = new Node(i);
            }
        }
        // 노드들 간에 간선 생성 메서드 (정렬도 해준다.)
        void addEdge(int v, int w) {
            Node n1 = nodes[v];
            Node n2 = nodes[w];
            if(!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }
            if(!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
            n1.adjacent.sort(Comparator.comparingInt(n -> n.data));
            n2.adjacent.sort(Comparator.comparingInt(n -> n.data));

        }
        // dfs를 실행함에 시작 값이 없는 경우 1부터 시작
        void dfs() {
            dfs(1);
        }
        // dfs 메서드
        void dfs(int index) {
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();
            stack.push(root);

            while(!stack.isEmpty()) {
                Node node = stack.pop();
                if (!node.marked) {
                    visit(node);
                    node.marked = true;
                    // 스택 원리로 인해 역순으로 실행하여 작은 값부터 처리하도록
                    for (int i = node.adjacent.size() - 1; i >= 0; i--) {
                        Node n = node.adjacent.get(i);
                        if (!n.marked) {
                            stack.push(n);
                        }
                    }
                }
            }
        }

        void bfs() {
            bfs(1);
        }

        void bfs(int index) {
            Node root = nodes[index];
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(root);
            root.marked = true;
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                for(Node n : node.adjacent) {
                    if(!n.marked) {
                        n.marked = true;
                        queue.add(n);
                    }
                }
                visit(node);
            }
        }

        void visit(Node node) {
            System.out.print(node.data + " ");
        }

        void clearMarks() {
            for(Node node : nodes) {
                if(node != null) {
                    node.marked = false;
                }
            }
        }
    }
}
