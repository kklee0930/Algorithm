import java.util.*;
import java.io.*;

class Main {

    static int M;
    static int N;
    static char[][] graph;
    static boolean[][] visitedRight;
    static boolean[][] visitedLeft;
    static boolean[][] visitedUp;
    static boolean[][] visitedDown;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new char[M][N];
        visitedRight = new boolean[M][N];
        visitedLeft = new boolean[M][N];
        visitedUp = new boolean[M][N];
        visitedDown = new boolean[M][N];
        count = 0;

        for(int i = 0; i < M; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                graph[i][j] = input[j];
            }
        }
        br.close();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                checkWall(i, j);
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }

    static void checkWall(int i, int j) {
        if(graph[i][j] == '.') {
            // 현재 위치에서 아래가 빈 공간인지 확인
            if(i + 1 < M && graph[i + 1][j] == '.') {
                // 현재 위치의 왼쪽이 벽이고 아래 공간 또한 왼쪽이 벽이면 그림을 걸 수 있다.
                if(j - 1 >= 0 && graph[i][j - 1] == 'X' && graph[i + 1][j - 1] == 'X' && !visitedLeft[i][j]) {
                    visitedLeft[i][j] = true;
                    visitedLeft[i + 1][j] = true;
                    count++;
                }
                // 현재 위치의 오른쪽이 벽이고 아래 공간 또한 오른쪽이 벽이면 그림을 걸 수 있다.
                if(j + 1 < N && graph[i][j + 1] == 'X' && graph[i + 1][j + 1] == 'X' && !visitedRight[i][j]) {
                    visitedRight[i][j] = true;
                    visitedRight[i + 1][j] = true;
                    count++;
                }
            }

            // 현재 위치에서 오른쪽이 빈 공간인지 확인
            if(j + 1 < N && graph[i][j + 1] == '.') {
                if(i - 1 >= 0 && graph[i - 1][j] == 'X' && graph[i - 1][j + 1] == 'X' && !visitedUp[i][j]) {
                    visitedUp[i][j] = true;
                    visitedUp[i][j + 1] = true;
                    count++;
                }
                if(i + 1 < M && graph[i + 1][j] == 'X' && graph[i + 1][j + 1] == 'X' && !visitedDown[i][j]) {
                    visitedDown[i][j] = true;
                    visitedDown[i][j + 1] = true;
                    count++;
                }
            }
        }
    }
}