import java.util.*;
import java.io.*;

class Main {

    static int[] parentNode;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); // 노드
        int e = Integer.parseInt(st.nextToken()); // 간선

        List<Node> edgeList = new ArrayList<>(); // 간선의 정보 리스트
        
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 간선의 가중치

            edgeList.add(new Node(a, b, c));
        }
        br.close();

        Collections.sort(edgeList); // 가중치 기준 정렬

        int total = 0;
        parentNode = new int[v+1]; // 노드별 부모

        for(int i = 1; i < v+1; i++) {
            parentNode[i] = i;
        }

        // 크루스칼 알고리즘
        for(Node edge : edgeList) {
            int nodeA = edge.a;
            int nodeB = edge.b;
            int weight = edge.weight;

            // 부모가 같으면 Cyclic Tree 생성되므로 continue
            if(findParent(nodeA) == findParent(nodeB)) {
                continue;
            }

            // Cyclic 아니면 추가
            total += weight;
            union(nodeA, nodeB);
        }

        bw.write(total + "");
        bw.flush();
        bw.close();
    }

    // 부모 정보 저장 처리
    static void union(int A, int B) {
        int a = findParent(A);
        int b = findParent(B);

        if(a != b) {
            parentNode[b] = a;
        }
    }

    // 해당 노드의 부모 노드 찾기
    static int findParent(int node) {
        if(parentNode[node] == node) {
            return node;
        }
        else {
            return findParent(parentNode[node]);
        }
    }

    static class Node implements Comparable<Node> {
        int a;
        int b;
        int weight;

        Node(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node a) {
            // 가중치 기준으로 정렬
            int weight = a.weight;

            if(this.weight > weight) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}