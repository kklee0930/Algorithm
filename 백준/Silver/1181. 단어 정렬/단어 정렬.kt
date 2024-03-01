import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val set = hashSetOf<String>()

    for(i in 0 until N) {
        set.add(readLine())
    }
    close()

    val sorted = set.sortedWith(compareBy({it.length}, {it}))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for(num in sorted) {
        bw.append(num.plus("\n"))
    }
    bw.flush()
    bw.close()
}