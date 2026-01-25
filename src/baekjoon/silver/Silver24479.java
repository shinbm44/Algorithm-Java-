package baekjoon.silver;

import java.io.*;
import java.util.*;

public class Silver24479 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [] result ;
    static StringTokenizer st;
    static int visitOrder = 1;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        result = new int[N + 1];

        Graph gp = new Graph(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gp.addEdge(u, v);
        }

        gp.sortAdj();
        gp.DFS(R);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append('\n');
        }

        System.out.print(sb);
    }

    static class Graph{


        static class Node{

            int value;
            List<Node> adjacent;
            boolean marked;


            public Node(int value) {

                this.value = value;
                adjacent = new ArrayList<>();
                this.marked = false;

            }
        }

        Node [] nodes;

        Graph(int size) {
            nodes = new Node [size + 1];

            for (int i = 1; i <= size; i++) {
                    nodes[i] = new Node(i);
            }
        }

        void addEdge(int v,int w){
            Node n1 = nodes[v];
            Node n2 = nodes[w];

            n1.adjacent.add(n2);
            n2.adjacent.add(n1);


        }

        void sortAdj() {

            int size = nodes.length;

            for(int i =1; i< size; i++) {
                nodes[i].adjacent.sort(new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o1.value-o2.value;
                    }
                });
            }
        }

        void DFS(int start) {

            Node node = nodes[start];
            node.marked = true;
            result[start] = visitOrder++;

            for(Node item : node.adjacent) {
                if(!item.marked){
                    DFS(item.value);
                }
            }
        }
    }

}
