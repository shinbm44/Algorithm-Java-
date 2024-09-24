package baekjoon.silver;

import java.io.*;
import java.util.*;


public class Silver1991 {

    static StringBuilder sb = new StringBuilder();

    // 필요한 노드 객체
    private static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    // 트리 객체
    private static class Tree {
        Node root;

        // 삽입 로직
        void insert(char rootValue, char left, char right) {
            if (root == null) {
                root = new Node(rootValue);
                insertChildren(root, left, right);
            } else {
                Node target = search(root, rootValue);
                if (target != null) {
                    insertChildren(target, left, right);
                }
            }
        }

        void insertChildren(Node root, char left, char right) {
            if(left != '.'){
                root.left = new Node(left);
            }
            if(right != '.'){
                root.right = new Node(right);
            }
        }

        // 값 탐색
        Node search(Node root, char rootValue) {
            if(root == null) {
                return null;
            }

            if(root.value == rootValue) {
                return root;
            }

            Node leftNode = search(root.left, rootValue);
            if(leftNode != null) {
                return leftNode;
            }
            return search(root.right, rootValue);
        }

        // 전위(루트->왼->오)
        void preOrder(Node root) {
            if(root != null) {
                sb.append(root.value);
                preOrder(root.left);
                preOrder(root.right);
            }
        }
        // 중위(왼->루트->오)
        void inOrder(Node root) {
            if(root != null) {
                inOrder(root.left);
                sb.append(root.value);
                inOrder(root.right);
            }
        }
        // 후위(왼->오->루트)
        void postOrder(Node root) {
            if(root != null) {
                postOrder(root.left);
                postOrder(root.right);
                sb.append(root.value);
            }
        }
    }


    public static void main(String[] args) throws Exception  {
        Node root = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 트리 depth
        int layer = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        StringTokenizer st;

        for(int i =0; i< layer; i++){
            st = new StringTokenizer(br.readLine());
            char one = st.nextToken().charAt(0);
            char two = st.nextToken().charAt(0);
            char three = st.nextToken().charAt(0);
            tree.insert(one, two, three);
        }

        tree.preOrder(tree.root);
        sb.append("\n");
        tree.inOrder(tree.root);
        sb.append("\n");
        tree.postOrder(tree.root);
        sb.append("\n");

        System.out.println(sb);
    }
}
