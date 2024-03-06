import java.io.*
import java.util.*

fun binarySearch(
    left: Int,
    right: Int,
    target: Int,
    list: IntArray
) : String {

    var start = left
    var end = right
    var mid = 0

    while(start <= end) {
        mid = (start + end) / 2

        if(list[mid] < target) {
            start = mid + 1
        }
        else if(list[mid] > target) {
            end = mid - 1
        }
        else {
            return "1\n"
        }
    }
    return "0\n"
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    var st = StringTokenizer(readLine())
    val listA = IntArray(n) {st.nextToken().toInt()}.sortedArray()

    val m = readLine().toInt()
    st = StringTokenizer(readLine())
    close()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(m) {
        val target = st.nextToken().toInt()
        bw.write(binarySearch(0, n - 1, target, listA))
        // 아니면 그냥 binarySearch 함수도 사용가능
//        bw.write(if(listA.binarySearch(target) >= 0) "1\n" else "0\n")
    }
    bw.flush()
    bw.close()
}