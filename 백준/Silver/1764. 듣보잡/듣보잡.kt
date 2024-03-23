import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val st = StringTokenizer(readLine())
    val N = st.nextToken().toInt() // 듣도 못한 사람 수
    val M = st.nextToken().toInt() // 보도 못한 사람 수

    val hashmap = mutableMapOf<String, Int>()
    repeat(N) {
        val notHeard = readLine()
        hashmap[notHeard] = hashmap.getOrDefault(notHeard, 0) + 1
    }
    repeat(M) {
        val notSeen = readLine()
        hashmap[notSeen] = hashmap.getOrDefault(notSeen, 0) + 1
    }
    close()

    val result = hashmap.filter { it.value == 2 }.keys.sorted()
    bw.write("${result.size}\n")
    for(word in result) {
        bw.write("$word\n")
    }
    bw.flush()
    bw.close()
}