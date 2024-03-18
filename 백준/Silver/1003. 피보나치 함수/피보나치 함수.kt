import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val T = readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // N은 40보다 작거나 0, Pair = (0 value, 1 value)
    val dp = Array(41) {Pair(1, 0)}
    dp[1] = Pair(0, 1)

    for(i in 2..40) {
        dp[i] = Pair(dp[i - 1].first + dp[i - 2].first, dp[i - 1].second + dp[i - 2].second)
    }
    repeat(T) {
        val n = readLine().toInt()
        bw.write(dp[n].let { "${it.first} ${it.second}\n" })
    }
    close()
    bw.flush()
    bw.close()
}