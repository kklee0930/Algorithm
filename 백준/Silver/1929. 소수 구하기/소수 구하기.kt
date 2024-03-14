import java.util.*
import java.io.*
import kotlin.math.sqrt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val st = StringTokenizer(readLine())
    val M = st.nextToken().toInt()
    val N = st.nextToken().toInt()
    close()

    val isPrime = BooleanArray(N + 1){true}
    isPrime[0] = false
    isPrime[1] = false

    // 에라토스테네스의 체 (2부터 N의 제곱근 값까지 iteration)
    for(i in 2..sqrt((N + 1).toDouble()).toInt()) {
        // isPrime[i] 값이 소수면 소수의 배수는 소수가 되지 않기 때문에 모두 false 처리
        if(isPrime[i]) {
            for(j in i*i..N step i) {
                isPrime[j] = false
            }
        }
    }

    BufferedWriter(OutputStreamWriter(System.out)).run {
        for(i in M .. N) {
            if(isPrime[i]) write("$i\n")
        }
        flush()
        close()
    }
}