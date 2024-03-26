import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = readLine().toInt()
    val meeting = Array(N){IntArray(2)} // 회의 정보 저장
    val pq = PriorityQueue<Int>()

    for(i in 0 until N) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        meeting[i][0] = start
        meeting[i][1] = end
    }
    close()

    // 회의 시작 시간 오름차순, 종료 시간 오름차순 정렬
    meeting.sortWith(compareBy({it[0]}, {it[1]}))
    pq.offer(meeting[0][1])

    // pq에는 회의 종료 시간을 저장
    for(i in 1 until N) {
        // 이전 회의 종료와 다음 회의 시작이 겹치지 않으면 pq.poll()
        if(pq.peek() <= meeting[i][0]) {
            pq.poll()
        }
        pq.offer(meeting[i][1])
    }
    bw.write(pq.size.toString())
    bw.flush()
    bw.close()
}