import java.util.*;
import java.io.*;

public class Main {
    static int[][][] tetromino = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // ㅣ
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // ㅁ
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // ㄴ
            {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {1, 0}, {2, 0}, {0, -1}},
            {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 0}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // 번개
            {{0, 0}, {0, 1}, {1, 0}, {1, -1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // ㅗ
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}}
    };

    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = 0;

        // 0, 0 좌표부터 모든 테트로미노 순차적으로 적용
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int[][] shape : tetromino) {
                    maxSum = Math.max(maxSum, getMaxSum(i, j, shape));
                }
            }
        }

        System.out.println(maxSum);
    }

    static int getMaxSum(int x, int y, int[][] shape) {
        int sum = 0;
        for (int[] point : shape) {
            int nx = x + point[0];
            int ny = y + point[1];
            // 범위 벗어나면 바로 return 0
            if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                return 0;
            }
            sum += board[nx][ny];
        }
        return sum;
    }
}
