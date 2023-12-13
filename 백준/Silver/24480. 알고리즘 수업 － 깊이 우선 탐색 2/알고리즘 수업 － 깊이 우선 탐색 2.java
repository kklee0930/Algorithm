import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int order;

    private static void dfs(int startNumber) {

        visited[startNumber] = order;
        order++;

        for(int i = 0; i < graph.get(startNumber).size(); i++) {

            int adjacentNode = graph.get(startNumber).get(i);

            if(visited[adjacentNode] == 0) {

                dfs(adjacentNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new int[vertex + 1];
        for(int i = 0; i < vertex+1; i++) {

            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        br.close();

        for(ArrayList<Integer> array : graph) {

            array.sort(Comparator.reverseOrder());
        }

        order = 1;
        dfs(start);

        for(int i = 1; i < visited.length; i++) {

            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}