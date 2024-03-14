import java.util.*
import java.io.*
import kotlin.collections.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val dq = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(N) {
        val st = StringTokenizer(readLine())
        when(st.nextToken()) {
            "push_front" -> dq.addFirst(st.nextToken().toInt())
            "push_back" -> dq.addLast(st.nextToken().toInt())
            "pop_front" -> if(dq.isEmpty()) sb.append("-1\n") else sb.append("${dq.removeFirst()}\n")
            "pop_back" -> if(dq.isEmpty()) sb.append("-1\n") else sb.append("${dq.removeLast()}\n")
            "size" -> sb.append("${dq.size}\n")
            "empty" -> if(dq.isEmpty()) sb.append("1\n") else sb.append("0\n")
            "front" -> if(dq.isEmpty()) sb.append("-1\n") else sb.append("${dq.first()}\n")
            "back" -> if(dq.isEmpty()) sb.append("-1\n") else sb.append("${dq.last()}\n")
        }
    }
    close()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}