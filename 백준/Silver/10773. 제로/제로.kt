import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val K = readLine().toInt()
    val stack = Stack<Int>()

    repeat(K) {
        val num = readLine().toInt()

        if (num == 0) stack.pop() else stack.push(num)
    }
    close()

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(stack.sum().toString())
    bw.flush()
    bw.close()
}