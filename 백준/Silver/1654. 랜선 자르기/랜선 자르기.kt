import java.io.*
import java.util.*

var arr = arrayListOf<Int>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val st = StringTokenizer(readLine())
    val k = st.nextToken().toInt() // 이미 가지고 있는 랜선의 갯수
    val n = st.nextToken().toInt() // 필요한 랜선의 갯수

    repeat(k) {
        arr.add(readLine().toInt())
    }

    arr.sort()

    close()

    println(binarySearch(n))
}

fun binarySearch(n : Int) : Long {
    var right : Long = arr[arr.lastIndex].toLong() + 1
    var left : Long  = 0
    var mid : Long

    while(left < right) {
        mid = (left + right) / 2
        var cnt : Long = 0

        for(elem in arr) {
            cnt += elem / mid
        }

        // 자른 랜선의 갯수가 부족하면 자를 길이를 줄여야 함
        if(cnt < n) {
            right = mid
        }
        // 자른 랜선의 갯수가 많으면 자를 길이를 늘려야 함
        else {
            left = mid + 1
        }
    }
    return left - 1
}