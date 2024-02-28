import java.util.*

fun main() = with(Scanner(System.`in`)) {

    val n = nextInt()
    var answer = 0

    repeat(n) {
        val str = next()
        var prevChar = str[0]
        var flag = false
        val set = mutableSetOf<Char>()

        set.add(prevChar)

        for(i in 1..<str.length) {
            // 이전 문자와 같으면 문제 없음
            if(str[i] == prevChar) {
                continue
            }
            // 이전 문자와 다르고 set에 등록되어 있다면 그룹 단어가 아님
            if(set.contains(str[i])) {
                flag = true
                break
            }
            // 이전 문자와 다르고 set에 등록되어 있지 않다면 문제 없음
            set.add(str[i])
            prevChar = str[i]
        }

        if(!flag) {
            answer++
        }
    }

    println(answer)
}