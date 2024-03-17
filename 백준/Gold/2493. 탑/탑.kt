import java.util.*
import java.io.*

class Data(val height : Int, val idx : Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val st = StringTokenizer(readLine())

    val stack = Stack<Data>() // 타워 높이 및 위치 저장 스택
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for(i in 0 until N) {
        val currentHeight = st.nextToken().toInt()

        // 현재 빌딩 높이가 이전 빌딩 높이보다 높으면 수신 불가능
        // 수신 불가능 시 수신 가능한 높이 나올 때까지 pop
        while(stack.isNotEmpty() && stack.peek().height < currentHeight) {
            stack.pop()
        }
        // empty일 경우 현재 빌딩 높이보다 높은 빌딩 없기 때문에 0
        if(stack.isEmpty()) {
            bw.write("0 ")
        }
        else {
            bw.write("${stack.peek().idx} ")
        }
        stack.push(Data(currentHeight, i + 1))
    }
    close()
    bw.flush()
    bw.close()
}