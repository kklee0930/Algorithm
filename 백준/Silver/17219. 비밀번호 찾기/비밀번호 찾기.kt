import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val hashmap = mutableMapOf<String, String>()
    repeat(N) {
        val input = readLine().split(" ")
        hashmap[input[0]] = input[1]
    }

    BufferedWriter(OutputStreamWriter(System.out)).run {
        repeat(M) {
            hashmap[readLine()]?.let { write("$it\n") }
        }
        flush()
        close()
    }
    close()
}