import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val N = readLine().toInt()
    var cnt = 1
    var currentNum : Long = 666
    close()

    while(N > cnt) {

        currentNum++
        if(currentNum.toString().contains("666")) {
            cnt++
        }
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(currentNum.toString())
    bw.flush()
    bw.close()
}