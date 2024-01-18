import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        char current;
        Node left;
        Node right;

        Node(char current, Node left, Node right) {
            this.current = current;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Node parent  = new Node('A', null, null); // 부모노드

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char current = st.nextToken().charAt(0); // 현재 노드
            char left = st.nextToken().charAt(0); // 현재 노드의 왼쪽 자식노드
            char right = st.nextToken().charAt(0); // 현재 노드의 오른쪽 자식노드

            insertNode(parent, current, left, right);
        }
        br.close();

        preOrder(parent);
        System.out.println();
        inOrder(parent);
        System.out.println();
        postOrder(parent);
    }
    static void insertNode(Node parent, char root, char left, char right) {
        // 부모노드가 현재 노드와 같으면
        if(parent.current == root) {
            parent.left = left == '.' ? null : new Node(left, null, null);
            parent.right = right == '.' ? null : new Node(right, null, null);
        }
        // 같지 않다면 비어있지 않은 왼쪽/오른쪽 자식노드를 parent값으로 놓고 재귀
        else {
            if(parent.left != null) {
                insertNode(parent.left, root, left, right);
            }
            if(parent.right != null) {
                insertNode(parent.right, root, left, right);
            }
        }
    }

    static void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.current);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.current);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.current);
    }
}