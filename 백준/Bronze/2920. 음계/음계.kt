import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr : List<Int> = readLine().split(" ").map { it.toInt() }
    close()

    when (arr) {
        arr.sorted() -> println("ascending")
        arr.sortedDescending() -> println("descending")
        else -> println("mixed")
    }
}