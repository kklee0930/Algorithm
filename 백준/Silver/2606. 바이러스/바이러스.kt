import java.io.*

var cnt = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val M = readLine().toInt()

    val network = Array(N + 1) { mutableListOf<Int>() }
    val infected = BooleanArray(N + 1) {idx -> idx == 1}

    // 네트워크 상에서 연결된 컴퓨터들을 2차원 배열로 표현
    repeat(M) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        network[start].add(end)
        network[end].add(start)
    }
    dfs(1, network, infected)

    BufferedWriter(OutputStreamWriter(System.out)).use {
        bw -> bw.write(cnt.toString())
    }
}

fun dfs(start : Int, network : Array<MutableList<Int>>, infected : BooleanArray) {
    val connected = network[start]
    // 네트워크 상에서 연결된 컴퓨터가 감염되지 않은 경우 감염시키고 재귀
    for(node in connected) {
        if(!infected[node]) {
            infected[node] = true
            cnt++
            dfs(node, network, infected)
        }
    }
}