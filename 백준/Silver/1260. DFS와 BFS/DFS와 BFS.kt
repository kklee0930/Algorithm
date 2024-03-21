import java.util.*
import java.io.*
import kotlin.collections.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // 정점의 갯수, 간선의 갯수, 시작 정점
    val (N, M, V) = readLine().split(" ").map { it.toInt() }
    val arr = Array(N + 1) { sortedSetOf<Int>() } // 간선 정보를 저장하는 배열

    repeat(M) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        arr[start].add(end) // 양방향
        arr[end].add(start)
    }
    close()

    val visited = BooleanArray(N + 1)
    val dfsResult = StringBuilder()
    val bfsResult = StringBuilder()

    dfs(arr, visited, V, dfsResult)
    bfs(arr, visited, V, bfsResult)

    bw.write("$dfsResult\n$bfsResult")
    bw.flush()
    bw.close()
}

fun dfs(arr : Array<TreeSet<Int>>, visited : BooleanArray, value : Int, sb : StringBuilder) {

    visited[value] = true
    sb.append("$value ")

    for(num in arr[value]) {
        if(!visited[num]) {
            dfs(arr, visited, num, sb)
        }
    }
}

fun bfs(arr : Array<TreeSet<Int>>, visited : BooleanArray, value : Int, sb : StringBuilder) {
    Arrays.fill(visited, false)
    val queue = ArrayDeque<Int>()
    queue.addLast(value)

    while(queue.isNotEmpty()) {
        val removed = queue.removeFirst()

        if(!visited[removed]) {
            visited[removed] = true
            sb.append("$removed ")

            for(num in arr[removed]) {
                if(!visited[num]) {
                    queue.addLast(num)
                }
            }
        }
    }
}