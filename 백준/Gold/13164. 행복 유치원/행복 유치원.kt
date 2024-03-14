import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val st = StringTokenizer(readLine())
    val N = st.nextToken().toInt() // 원생의 수
    val K = st.nextToken().toInt() // 그룹의 수

    // 입력 받은 값 바로 리스트로 변환하고 정렬
    val arr = readLine().split(" ").map { it.toInt() }.sorted()
    close()

    // 인접한 원생 사이의 키 리스트로 변환하고 정렬
    val gap = (1 until N).map { arr[it] - arr[it-1] }.sorted()

    // N - K 개 그룹 합
    val sum = gap.subList(0, N - K).sum()

    BufferedWriter(OutputStreamWriter(System.out)).run {
        write(sum.toString())
        flush()
        close()
    }
}