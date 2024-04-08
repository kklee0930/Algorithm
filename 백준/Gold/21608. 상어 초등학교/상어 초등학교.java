    import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashMap<Integer, ArrayList<Integer>> favStudentMap = new HashMap<>();
    static int studentNum;
    static int[][] classroom;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        classroom = new int[N+1][N+1];

        // N * N 명 학생의 좋아하는 학생 정보
        for(int i = 1; i < N * N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            studentNum = Integer.parseInt(st.nextToken());
            ArrayList<Integer> temp = new ArrayList<>();

            for(int j = 0; j < 4; j++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
            favStudentMap.put(studentNum, temp);

            // 1번조건: 인근 좌표 탐색하여 좋아하는 학생 수가 많은 칸으로 선정
            ArrayList<int[]> temp2 = condition1();

            // 2번조건: 1번조건의 칸이 여러개면 인접한 빈 칸이 가장 많은 칸으로 선정
            ArrayList<int[]> temp3 = condition2(temp2);

            // 3번조건: 2번조건의 칸이 여러개면 행의 번호가 작은 칸, 열의 번호가 작은 칸으로 자리 선정
            int[] result = temp3.stream().min(Comparator.comparingInt((int[] arr) -> arr[0])
                    .thenComparingInt(arr -> arr[1]))
                    .orElse(null);

            classroom[result[0]][result[1]] = studentNum;
        }
        br.close();
        bw.write(scoreCalculation()+"");
        bw.flush();
        bw.close();
    }

    static ArrayList<int[]> condition1() {
        ArrayList<int[]> temp = new ArrayList<>();
        int maxFavStudentCnt = 0;

        for(int y = 1; y < N + 1; y++) {
            for(int x = 1; x < N + 1; x++) {

                if(classroom[y][x] != 0) {
                    continue;
                }

                // x, y 좌표의 인접한 좋아하는 학생 수
                int favStudentCnt = 0;

                for(int z = 0; z < 4; z++) {

                    int nx = x + dx[z];
                    int ny = y + dy[z];
                    if(nx < 1 || ny < 1 || nx > N || ny > N) {
                        continue;
                    }

                    // nx ny 좌표가 해당 학생이 좋아하는 학생이면 +처리
                    if(favStudentMap.get(studentNum).contains(classroom[ny][nx])) {
                        favStudentCnt++;
                    }
                }

                // 좋아하는 학생 수가 최대인 경우에만 temp에 추가
                if(favStudentCnt == maxFavStudentCnt) {
                    temp.add(new int[]{y, x});
                }
                else if(favStudentCnt > maxFavStudentCnt) {
                    temp.clear();
                    temp.add(new int[]{y, x});
                    maxFavStudentCnt = favStudentCnt;
                }
            }
        }
        return temp;
    }

    static ArrayList<int[]> condition2(ArrayList<int[]> temp2) {
        int maxEmptySpace = 0;
        ArrayList<int[]> temp = new ArrayList<>();

        for(int[] coord : temp2) {

            int tempEmptySpace = 0;
            for(int j = 0; j < 4; j++) {
                int nx = coord[1] + dx[j];
                int ny = coord[0] + dy[j];

                if(nx < 1 || ny < 1 || nx > N || ny > N) {
                    continue;
                }

                // 인접 칸이 빈 경우에만 +처리
                if(classroom[ny][nx] == 0) {
                    tempEmptySpace++;
                }
            }

            // 빈칸이 최대인 경우에만 temp에 추가
            if(tempEmptySpace == maxEmptySpace) {
                temp.add(coord);
            }
            else if(tempEmptySpace > maxEmptySpace) {
                temp.clear();
                temp.add(coord);
                maxEmptySpace = tempEmptySpace;
            }
        }
        return temp;
    }

    static int scoreCalculation() {
        int answer = 0;
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                int targetStudent = classroom[i][j];
                int satisfaction = 0;

                for(int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if(nx < 1 || ny < 1 || nx > N || ny > N) {
                        continue;
                    }
                    if(favStudentMap.get(targetStudent).contains(classroom[ny][nx])) {
                        satisfaction++;
                    }
                }

                switch (satisfaction) {
                    case 1: answer++; break;
                    case 2: answer += 10; break;
                    case 3: answer += 100; break;
                    case 4: answer += 1000; break;
                }
            }
        }
        return answer;
    }
}