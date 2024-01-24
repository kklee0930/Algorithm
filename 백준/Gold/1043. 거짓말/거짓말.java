import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수
        ArrayList<Integer>[] partyData = new ArrayList[m+1]; // 파티 참여인원 데이터

        for(int i = 1; i <= m; i++) {
            partyData[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
        boolean[] knowTruthArr = new boolean[n+1]; // 진실을 아는지 확인 위한 배열

        for(int i = 0; i < knowCnt; i++) {
            knowTruthArr[Integer.parseInt(st.nextToken())] = true;
        }

        parent = new int[n+1];
        for(int i = 1; i <= n; i++) { // 유니온 파인드 위한 부모노드 배열
            parent[i] = i;
        }

        for(int i = 1; i <= m; i++) { // 파티 수만큼 iteration
            String[] input = br.readLine().split(" ");
            int personCnt = Integer.parseInt(input[0]); // 파티에 참여하는 사람 수

            if(personCnt == 1) { // 파티참여 인원이 한명일 경우
                partyData[i].add(Integer.parseInt(input[1]));
                continue;
            }

            for(int j = 1; j < personCnt; j++) {
                int a = Integer.parseInt(input[j]);
                int b = Integer.parseInt(input[j+1]);

                if(find(a) != find(b)){ // 서로 부모 노드가 같지 않다면
                    union(a, b); // 유니온 처리
                }
                // i번째 파티에 참여인원 정보 저장
                partyData[i].add(b);
                partyData[i].add(a);
            }
        }

        br.close();

        boolean[] visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && knowTruthArr[i]) { // 아직 방문하지 않았고 진실을 아는 사람이라면
                int parentNode = find(i); // 파인드 처리해서 부모 노드 확인

                // 파인드를 통한 부모노드가 같다면 진실을 알게됨
                for(int j = 1; j <= n; j++) {
                    if(find(j) == parentNode) {
                        visited[j] = true;
                        knowTruthArr[j] = true;
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= m; i++) { // 1번 참여자부터 iteration
            boolean flag = false;
            for(int person : partyData[i]) {
                if(knowTruthArr[person]) { // 진실을 알고 있는 사람이 있다면 다음 파티 데이터로 이동
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    // 유니온
    static void union(int a, int b) {
        int parentB = find(b);
        parent[parentB] = a;
    }

    // 파인드(부모노드 찾기)
    static int find(int n) {
        if(parent[n] == n) { // 루트
            return n;
        }

        parent[n] = find(parent[n]);
        return parent[n];
    }
}