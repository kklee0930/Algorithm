import java.io.*
import kotlin.collections.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val X = readLine().toInt()
    close()
    BufferedWriter(OutputStreamWriter(System.out)).use {
        bw -> bw.write(bfs(X).toString())
    }
}

fun bfs(num : Int) : Int {
    val queue = ArrayDeque<Pair<Int, Int>>().apply { addLast(Pair(num, 0)) }

    while(queue.isNotEmpty()) {
        val (currentNum, cnt) = queue.removeFirst()
        if(currentNum == 1) {
            return cnt
        }
        if(currentNum % 3 == 0) {
            queue.addLast(Pair(currentNum / 3, cnt + 1))
        }
        if(currentNum % 2 == 0) {
            queue.addLast(Pair(currentNum / 2, cnt + 1))
        }
        if(currentNum > 1) {
            queue.addLast(Pair(currentNum - 1, cnt + 1))
        }
    }
    return 0
}