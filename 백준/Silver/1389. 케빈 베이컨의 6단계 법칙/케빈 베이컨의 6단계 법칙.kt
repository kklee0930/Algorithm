import java.util.*
import java.io.*
import kotlin.collections.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt() // 유저의 수
    val M = st.nextToken().toInt() // 친구 관계의 수

    val baconValue = IntArray(N)
    val graph = Array(N+1) { mutableListOf<Int>() }

    repeat(M) {
        st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        graph[start].add(end)
        graph[end].add(start)
    }

    // bfs
    for(i in 1 .. N) {
        val visited = BooleanArray(N + 1)
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.addLast(Pair(i, 1))
        visited[i] = true

        while(queue.isNotEmpty()) {
            val (current, depth) = queue.removeFirst()

            for(node in graph[current]) {
                if(!visited[node]) {
                    visited[node] = true
                    baconValue[i - 1] += depth
                    queue.addLast(Pair(node, depth + 1))
                }
            }
        }
    }

    // 베이컨 값이 가장 작은 사람 출력(여럿이면 번호가 가장 작은 사람 출력)
    val minVal = baconValue.min()
    val result = baconValue.indexOfFirst { it == minVal } + 1
    bw.write(result.toString())
    bw.flush()
    bw.close()
}