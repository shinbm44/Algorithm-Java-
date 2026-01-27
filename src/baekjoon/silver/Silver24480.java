package baekjoon.silver;


import java.util.*;
import java.io.*;

public class Silver24480 {

    static int [] result;
    static int countNumber = 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        st = new  StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K  = Integer.parseInt(st.nextToken());

        result = new int[N + 1];

        Graph g = new Graph(N+ 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.addEdge(u, v);
        }

        g.sortDesc();
        g.DFS(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb);
    }

    static class Graph {

        static class Node {
            int value;
            boolean visited;
            List<Node> adjacent;

            public Node(int value) {

                this.value = value;
                visited = false;
                adjacent = new ArrayList<>();

            }
        }

        Node [] nodes;

        public Graph(int range) {
            nodes = new Node [range];

            for(int i =0; i < range; i++) {
                nodes[i] = new Node (i);
            }
        }

        public void addEdge(int v, int w) {
            Node n1 = nodes[v];
            Node n2 = nodes[w];

            n1.adjacent.add(n2);
            n2.adjacent.add(n1);
        }

        public void sortDesc(){

            int size =  nodes.length;

            for(int i =0; i<size; i++){

                nodes[i].adjacent.sort(new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o2.value - o1.value;
                    }
                });

            }
        }

        public void DFS(int start) {
            Node node = nodes[start];
            node.visited = true;
            result[start] = countNumber++;

            for( Node item : node.adjacent) {
                if(!item.visited){
                    DFS(item.value);
                }

            }
        }
    }
}
