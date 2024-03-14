import java.util.*
import java.io.*
import kotlin.collections.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val queue = ArrayDeque<Int>()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(N) {
        val st = StringTokenizer(readLine())
        when(st.nextToken()) {
            "push" -> queue.addLast(st.nextToken().toInt())
            "pop" -> if(queue.isEmpty()) bw.write("-1\n") else bw.write("${queue.removeFirst()}\n")
            "size" -> bw.write("${queue.size}\n")
            "empty" -> if(queue.isEmpty()) bw.write("1\n") else bw.write("0\n")
            "front" -> if(queue.isEmpty()) bw.write("-1\n") else bw.write("${queue.first()}\n")
            "back" -> if(queue.isEmpty()) bw.write("-1\n") else bw.write("${queue.last()}\n")
        }
    }
    close()
    bw.flush()
    bw.close()
}