import java.io.*
import java.util.*
import kotlin.math.roundToInt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val arr = arrayListOf<Int>()

    repeat(n) {
        arr.add(readLine().toInt())
    }

    close()
    arr.sort()

    // 산술평균
    bw.write("${arr.average().roundToInt()}\n")

    // 중앙값
    bw.write("${arr[arr.size / 2]}\n")

    // 최빈값
    val map = arr.groupingBy { it }.eachCount() // groupingBy: Grouping 객체 반환하여 요소 조작 가능
    val maxVal = map.maxOf { it.value }
    val temp = map.filter { it.value == maxVal }.keys // 숫자의 등장 빈도가 최대 등장 빈도와 같은 것만 필터
    val sorted = temp.sorted()

    if(temp.size > 1) {
        bw.write("${sorted[1]}\n")
    }
    else {
        bw.write("${sorted[0]}\n")
    }

    // 범위
    bw.write((arr.max() - arr.min()).toString())
    bw.flush()
    bw.close()
}