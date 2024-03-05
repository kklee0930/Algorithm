import java.io.*
import java.util.*
import kotlin.collections.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    class Data(val index : Int, val weight : Int)
    val t = readLine().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(t) {
        var st = StringTokenizer(readLine())
        val n = st.nextToken().toInt() // 문서의 갯수
        val m = st.nextToken().toInt() // 목표
        var cnt = 0 // 문서 출력 순서

        val queue = ArrayDeque<Data>()

        st = StringTokenizer(readLine())
        for(i in 0 until n) {
            val weight = st.nextToken().toInt() // 문서의 중요도
            queue.add(Data(i, weight))
        }

        while(!queue.isEmpty()) {
            val removed = queue.removeFirst()
            var maxWeight = true

            for(i in 0 until queue.size) {
                // queue를 돌면서 현재 문서의 중요도가 제일 높은지 체크
                if(removed.weight < queue[i].weight) {
                    queue.addLast(removed)
                    maxWeight = false

                    for(j in 0 until i) {
                        queue.addLast(queue.removeFirst())
                    }
                    break
                }
            }

            if(maxWeight) {
                cnt++
                // 제거된 문서의 순서가 m과 같으면 write
                if(removed.index == m) {
                    bw.write("$cnt\n")
                    break
                }
            }
        }
    }
    bw.flush()
    bw.close()
}