import java.util.*
import java.io.*
import kotlin.math.pow

var cnt = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val st = StringTokenizer(readLine())
    close()
    val N = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    val length = 2.0.pow(N.toDouble()).toInt() // 한 변의 길이
    recursion(length, r, c)
    BufferedWriter(OutputStreamWriter(System.out)).run {
        write(cnt.toString())
        flush()
        close()
    }
}

fun recursion(length : Int, r : Int, c : Int) {
    if(length == 1) {
        return
    }
    else if(r < length / 2 && c >= length / 2) { // 1사분면
        cnt += length * length / 4 // 2사분면 카운팅 한 값 추가
        recursion(length / 2, r, c - length / 2)
    }
    else if(r < length / 2 && c < length / 2) { // 2사분면
        recursion(length / 2, r, c)
    }
    else if(r >= length / 2 && c < length / 2) { // 3사분면
        cnt += length * length / 4 * 2 // 1사분면과 2사분면 값 추가
        recursion(length / 2, r - length / 2, c)
    }
    else if(r >= length / 2 && c >= length / 2) { // 4사분면
        cnt += length * length / 4 * 3 // 1, 2, 3사분면 값 추가
        recursion(length / 2, r - length / 2, c - length / 2)
    }
}