import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val stack = Stack<Int>()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(N) {
        val st = StringTokenizer(readLine())
        when(st.nextToken()) {
            "push" -> stack.push(st.nextToken().toInt())
            "pop" -> if(stack.isEmpty()) bw.write("-1\n") else bw.write("${stack.pop()}\n")
            "size" -> bw.write("${stack.size}\n")
            "empty" -> if(stack.isEmpty()) bw.write("1\n") else bw.write("0\n")
            "top" -> if(stack.isEmpty()) bw.write("-1\n") else bw.write("${stack.peek()}\n")
        }
    }
    close()
    bw.flush()
    bw.close()
}