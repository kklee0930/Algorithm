import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()
    val st = StringTokenizer(readLine())
    close()

    val treeSet = TreeSet<Int>()

    for(i in 1..N)
        treeSet.add(st.nextToken().toInt())

    treeSet.forEach {
        print("$it ")
    }
}