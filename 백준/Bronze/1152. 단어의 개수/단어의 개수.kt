import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().trim().split(" ")
    close()
    if(input[0] == "") println(0)
    else println(input.size)
}