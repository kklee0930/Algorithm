import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 이동할 원반의 갯수

        br.close();

        sb.append((int)Math.pow(2, K) - 1).append("\n");
        Hanoi(K, 1, 2, 3);
        System.out.println(sb);
    }

    /*
    n = 이동하는 원반 갯수
    start = 시작하는 장소
    via = start에서 goal로 도달하기 위해 거쳐가는 장소
    goal = 목적지
     */
    static void Hanoi(int n, int start, int via, int goal){
        if(n == 1){
            sb.append(start).append(" ").append(goal).append("\n");
            return;
        }

        // start -> via -> goal 순으로 원반을 옮긴다.

        // start에서 goal을 거쳐 via로 원반 옮기기
        Hanoi(n-1, start, goal, via);

        // 가장 아래에 위치해 있던 원반을 목표지점으로 옮긴다.
        sb.append(start).append(" ").append(goal).append("\n");

        // 나머지 원반들을 via에서 start를 거쳐 goal로 옮기기
        Hanoi(n-1, via, start, goal);
    }
}