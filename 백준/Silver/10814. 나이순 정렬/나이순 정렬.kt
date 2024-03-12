import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val arr = arrayListOf<Pair<Int, String>>()
    for(i in 0 until N) {

        val st = StringTokenizer(readLine())
        val age = st.nextToken().toInt()
        val name = st.nextToken()
        arr.add(Pair(age, name))
    }
    close()

    // 나이 오름차순 정렬
    arr.sortBy { it.first }

    val sb = StringBuilder()
    for(data in arr) {
        sb.append("${data.first} ${data.second}\n")
    }
    println(sb)
}