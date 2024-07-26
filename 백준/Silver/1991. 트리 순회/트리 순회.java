import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node root = new Node('A', null, null); // 루트 노드 생성
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char current = st.nextToken().charAt(0); // 현재 입력 노드
            char left = st.nextToken().charAt(0); // 왼쪽 자식 노드
            char right = st.nextToken().charAt(0); // 오른쪽 자식 노드
            
            insertNode(root, current, left, right);
        }
        br.close();

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    static void insertNode(Node root, char current, char left, char right) {
        // root 노드와 current 노드의 값이 같다면 left, right를 각각 자식노드로 추가
        if(root.parent == current) {
            root.left = left == '.' ? null : new Node(left, null, null);
            root.right = right == '.' ? null : new Node(right, null, null);
        }

        // 같지 않다면 null이 아닌 왼쪽/오른쪽 자식노드를 부모노드로 놓고 재귀
        else {
            if(root.left != null) {
                insertNode(root.left, current, left, right);
            }
            if(root.right != null) {
                insertNode(root.right, current, left, right);
            }
        }
    }

    // 전위 순회
    static void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.parent);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위 순회
    static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.parent);
        inOrder(node.right);
    }

    // 후위 순회
    static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.parent);
    }

    static class Node {
        char parent;
        Node left; // 왼쪽 자식노드
        Node right; // 오른쪽 자식노드

        Node(char parent, Node right, Node left) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}