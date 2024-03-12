import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val set = sortedSetOf<Int>()

    repeat(N) {
        set.add(readLine().toInt())
    }
    close()

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    set.forEach {
        bw.write("$it\n")
    }
    bw.flush()
    bw.close()
}