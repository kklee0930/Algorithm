import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    br.close()

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    if(a > b) {
        bw.write(">")
    }
    else if(a < b) {
        bw.write("<")
    }
    else {
        bw.write("==")
    }
    bw.flush()
    bw.close()
}