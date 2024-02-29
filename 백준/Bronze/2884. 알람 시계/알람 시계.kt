import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val st = StringTokenizer(readLine())
    close()
    
    var h = st.nextToken().toInt()
    var m = st.nextToken().toInt()

    if(m - 45 < 0) {
        m += 60 - 45
        if(h - 1 < 0) {
            h = 23
        }
        else {
            h -= 1
        }
    }
    else {
        m -= 45
    }

    println("$h $m")
}