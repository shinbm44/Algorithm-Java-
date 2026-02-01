package baekjoon.silver;

import java.io.*;
import java.util.*;


public class Silver24444 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int [] result;
    static int cnt = 1;

    public static void main(String[] args) throws Exception {

        // 입력 받은 값에 +1 해줄것
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        Graph GP = new  Graph(n+1);

        for(int i =1; i<m+1; i++ ) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            GP.addNode(u,v);
        }

        GP.AscNodes();
        GP.BFS(r);

        StringBuilder sb = new StringBuilder();
        for(int i =1; i< n+1; i++  ) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb.toString());

    }


    static class Graph{

        static Queue<Node> queue;

        static class Node {
            int value;
            boolean visited;
            List<Node> adjList;

            public Node(int vlaue) {
                this.value = vlaue;
                this.visited = false;
                this.adjList = new ArrayList<Node>();
            }
        }
        Node [] nodes;

        public Graph(int range) {
            nodes = new  Node[range];

            for(int i =0; i<range;i++){
                nodes[i] = new Node(i);
            }

            result = new  int [range];
            queue = new ArrayDeque<Node>();
        }

        public void AscNodes() {
            for(Node node : nodes) {
                node.adjList.sort(new Comparator<Node>() {

                    @Override
                    public int compare(Node o1, Node o2) {
                        return o1.value - o2.value;
                    }
                });
            }
        }

        public void addNode(int u , int v ) {
            Node node1 = nodes[u];
            Node node2 = nodes[v];

            node1.adjList.add(node2);
            node2.adjList.add(node1);

        }

        public void BFS(int start) {
            Node startNode = nodes[start];
            startNode.visited = true;
            queue.add(startNode);
            result [startNode.value] = cnt++;



            while(!queue.isEmpty()){
                Node tempNode =  queue.poll();

                for(Node node :  tempNode.adjList){
                    if(!node.visited) {
                        queue.add(node);
                        node.visited = true;
                        result[node.value] = cnt++;
                    }
                }
            }
        }
    }
}
