import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val t = readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val st = StringTokenizer(readLine())

        val r = st.nextToken().toInt()
        val s = st.nextToken()

        for(element in s) {

            repeat(r) {
                sb.append(element)
            }
        }
        sb.append("\n")
    }

    println(sb)
}