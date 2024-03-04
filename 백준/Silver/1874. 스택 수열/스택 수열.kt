import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val stack = Stack<Int>()
    val sb = StringBuilder() // 결과값 저장
    var nextNum = 1 // 스택에 다음으로 들어갈 숫자

    stack.push(0)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for(i in 0 until n) {

        val givenNum = readLine().toInt() // pop 해야할 값

        // stack의 마지막 원소와 givenNum이 같으면 pop
        if (givenNum == stack.lastElement()) {
            stack.pop()
            sb.append("-\n")
        }
        // stack에 들어갈 숫자가 pop할 값보다 작으면 같아질 때까지 push
        else if (givenNum >= nextNum) {
            while(givenNum >= nextNum) {
                stack.push(nextNum)
                nextNum++
                sb.append("+\n")
            }
            // 같아지면 pop
            stack.pop()
            sb.append("-\n")
        }
        // 위의 두 경우 모두 해당 안되면 불가능
        else {
            bw.write("NO")
            bw.flush()
            bw.close()
            return
        }
    }
    bw.write(sb.toString())
    bw.flush()
    bw.close()
}