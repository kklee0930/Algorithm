import java.util.*
import java.io.*

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val T = readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(T) {
        var st = StringTokenizer(readLine())
        val M = st.nextToken().toInt() // 가로 길이
        val N = st.nextToken().toInt() // 세로 길이
        val K = st.nextToken().toInt() // 배추 갯수
        var warmCnt = 0

        val field = Array(N) {IntArray(M)} // 배추밭

        repeat(K) {
            st = StringTokenizer(readLine())
            val c = st.nextToken().toInt()
            val r = st.nextToken().toInt()
            field[r][c] = 1
        }

        for(r in 0 until N) {
            for(c in 0 until M) {
                if(field[r][c] == 1) {
                    dfs(r, c, N, M, field)
                    warmCnt++
                }
            }
        }
        bw.write("$warmCnt\n")
    }
    close()
    bw.flush()
    bw.close()
}
fun dfs(
    row: Int,
    column: Int,
    N: Int,
    M: Int,
    field : Array<IntArray>
) {
    for(i in 0 until 4) {
        val nr = row + dx[i]
        val nc = column + dy[i]

        // 배추밭 범위를 벗어나거나, 이미 방문했거나, 배추가 심어저 있지 않은 경우 continue
        if(nr < 0 || nc < 0 || nr > N - 1 || nc > M - 1 || field[nr][nc] != 1) {
            continue
        }
        field[nr][nc] = 0
        dfs(nr, nc, N, M, field)
    }
}