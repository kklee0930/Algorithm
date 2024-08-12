import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 줄 세운 횟수

        List<Integer>[] tree = new ArrayList[N+1];
        int[] inDegree = new int[N+1]; // 노드별 입력차수
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 1; i < N+1; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 학생 A가 B앞에 옴
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            tree[A].add(B);
            inDegree[B]++; // b노드의 입력차수++
        }
        br.close();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < N+1; i++) {
            if(inDegree[i] == 0) {
                queue.add(i); // 입력차수가 0인 노드만 추가
            }
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll(); // 현재 노드
            answer.add(curr);

            // 현재 노드와 연결된 노드 탐색
            for(int adjNode : tree[curr]) {
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }

        for(int node : answer) {
            bw.write(node + " ");
        }
        bw.flush();
        bw.close();
    }
}