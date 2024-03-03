import java.io.*
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    // B, W 여부 담기 위한 boolean 배열
    val arr = Array(N) {BooleanArray(M)}

    for(i in 0 until N) {
        val input = readLine()

        for(j in 0 until M) {
            if(input[j] == 'W') { // W면 true
                arr[i][j] = true
            } else {
                arr[i][j] = false // B면 false
            }
        }
    }

    close()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // 8 X 8 배열이기 때문에 값 64로 초기화
    var minVal = 64

    for(i in 0 until N-7) {
        for(j in 0 until M-7) {
            minVal = min(minVal, check(arr, i, j))
        }
    }

    bw.write(minVal.toString())
    bw.flush()
    bw.close()
}

fun check(arr : Array<BooleanArray>, x : Int, y : Int) : Int {
    var isWhite = arr[x][y]
    var cnt = 0 // 색깔 다시 칠할 정사각형 갯수

    for(i in x until x + 8) {
        for(j in y until y + 8) {

            // 현재 위치 값이 이전과 같으면 색깔을 다시 칠해야 함
            if(isWhite != arr[i][j]) {
                cnt++
            }

            // column 위치가 변경되면 색깔이 바뀜
            isWhite = !isWhite
        }

        // row가 바뀔 때마다 또 한번 색깔이 바뀜
        isWhite = !isWhite
    }

    return min(cnt, 64 - cnt)
}