import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    br.close()

    val sum = token.nextToken().toInt() + token.nextToken().toInt()
    bw.write(sum.toString())
    bw.flush()
    bw.close()
}