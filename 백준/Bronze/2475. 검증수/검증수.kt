import java.io.*
import java.util.*
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    br.close()

    var sum = 0.0
    repeat(5) {
        sum += st.nextToken().toDouble().pow(2)
    }

    bw.write((sum % 10).toInt().toString())
    bw.flush()
    bw.close()
}