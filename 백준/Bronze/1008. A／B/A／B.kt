import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    br.close()

    val div = token.nextToken().toDouble() / token.nextToken().toDouble()
    bw.write(div.toString())
    bw.flush()
    bw.close()
}