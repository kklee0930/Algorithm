import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int k;
    static List<int[]> arr;
    static List<boolean[]> visited;
    
    static class Node {
        private int number; // 현재 칸의 번호
        private int isLeft; // 왼쪽줄 오른쪽줄 구분 위한 값
        private int limit; // 사라지는 칸의 번호

        public Node(int number, int isLeft, int limit) {
            this.number = number;
            this.isLeft = isLeft;
            this.limit = limit;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        int[] left = br.readLine().chars().map(chr -> chr - '0').toArray();
        int[] right = br.readLine().chars().map(chr -> chr - '0').toArray();
        arr.add(right);
        arr.add(left);

        visited = new ArrayList<>();
        boolean[] leftVisited = new boolean[N];
        boolean[] rightVisited = new boolean[N];
        visited.add(rightVisited);
        visited.add(leftVisited);

        br.close();
        
        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1, -1));
        visited.get(1)[0] = true;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int number = current.number;
            int isLeft = current.isLeft;
            int limit = current.limit;

            // 목표 값 N 넘으면 1
            if(number + 1 >= N || number + k >= N) {
                return 1;
            }
            // 범위를 벗어나지 않고 해당 인덱스의 값이 0이 아닐 경우 큐에 추가
            if(arr.get(isLeft)[number + 1] != 0 && !visited.get(isLeft)[number + 1]) {
                queue.offer(new Node(number + 1, isLeft, limit + 1));
                visited.get(isLeft)[number + 1] = true;
            }
            if(number - 1 >= 0 && arr.get(isLeft)[number - 1] != 0 && number - 1 > limit + 1 && !visited.get(isLeft)[number - 1]) {
                queue.offer(new Node(number - 1, isLeft, limit + 1));
                visited.get(isLeft)[number - 1] = true;
                
            }
            if(arr.get(isLeft ^ 1)[number + k] != 0 && !visited.get(isLeft ^ 1)[number + k]) {
                queue.offer(new Node(number + k, isLeft ^ 1, limit + 1));
                visited.get(isLeft ^ 1)[number + k] = true;
            }
        }
        return 0;
    }
}