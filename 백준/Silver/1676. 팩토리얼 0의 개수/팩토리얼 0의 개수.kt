import java.util.*

fun main() = with(Scanner(System.`in`)) {

    var n = nextInt()
    var cnt = 0
    close()

    // 5! 단위로 0 갯수가 증가함
    while(n >= 5) {
        cnt += n / 5
        n /= 5
    }
    println(cnt)
}