import java.util.*;
import java.io.*;

class Main {
    
    static int M;
    static boolean[] opened;
    static List<Node> chickenList;
    static List<Node> houseList;
    static int answer;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가로 세로 길이
        M = Integer.parseInt(st.nextToken()); // 치킨집 수

        houseList = new ArrayList<>(); // 집 좌표 리스트
        chickenList = new ArrayList<>(); // 치킨집 좌표 리스트
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                
                if(value == 1) {
                    houseList.add(new Node(i, j));
                } else if(value == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }
        br.close();

        answer = Integer.MAX_VALUE;
        opened = new boolean[chickenList.size()]; // 영업중인 치킨집
        
        dfs(0, 0);
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int count) {
        if(count == M) {
            int result = 0;

            // 모든 집과 영업중인 치킨집들 간의 거리를 계산
            for(int i = 0; i < houseList.size(); i++) {
                int tempDist = Integer.MAX_VALUE;
                Node h = houseList.get(i); // 집의 좌표 정보
                
                for(int j = 0; j < chickenList.size(); j++) {
                    if(opened[j]) {
                        Node c = chickenList.get(j); // 치킨집의 좌표 정보
                        int dist = Math.abs(c.row - h.row) + Math.abs(c.column - h.column);
                        tempDist = Math.min(dist, tempDist);
                    }
                }
                result += tempDist;
            }
            answer = Math.min(answer, result);
            return;
        }

        for(int i = start; i < chickenList.size(); i++) {
            opened[i] = true;
            dfs(i + 1, count + 1);
            opened[i] = false;
        }
    }

    static class Node {
        int row;
        int column;

        Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}