import java.util.*;

class Solution {
    
    ArrayList<String> result = new ArrayList<>();
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String[] cmd = {"d", "l", "r", "u"};
    int n, m, r, c, k;
    boolean flag = false;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c =c;
        this.k = k;
        
        if(!arrivalTester(x, y, 0)) {
            return "impossible";
        }
        if(x == r && y == c) {
            return "";
        }
        dfs("", 1, x, y);
        Collections.sort(result);
        // System.out.println(result);
        return result.isEmpty() ? "impossible" : result.get(0);
    }
    
    public void dfs(String route, int cnt, int x, int y) {
        
        // 델타탐색
        for(int i = 0; i < 4; i++) {
            
            if(flag) {
                return;
            }
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 경로 이탈, 도착 불가능한 경우
            if(nx < 1 || nx > n || ny < 1 || ny > m || !arrivalTester(nx, ny, cnt)) {
                continue;
            }

            // 현재 위치(nx, ny) 까지의 이동루트
            String currentRoute = route + cmd[i];
            // System.out.println("nx: "+nx+" / ny: "+ny+" / currentRoute: "+ currentRoute);

            // 아직 더 이동할 수 있으면 재귀
            if(cnt < k) {
                dfs(currentRoute, cnt + 1, nx, ny);
            }
            
            // 탈출지점이면 이동루트를 저장
            if(cnt == k && nx == r && ny == c) {
                result.add(currentRoute);
                flag = true;
                return;
            }
        }
    }
    
    public boolean arrivalTester(int currX, int currY, int cnt) {
        
        // 현재 지점에서 탈출지점까지 남은 거리
        int remainDist = Math.abs(currX - r) + Math.abs(currY - c);
        // 남은 이동횟수
        int remainCnt = k - cnt;
        
        if(remainDist > remainCnt || (remainCnt - remainDist) % 2 != 0) {
            return false;
        }
        else {
            return true;
        }
    }
}