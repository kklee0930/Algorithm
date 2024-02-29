import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val t = readLine().toInt()

    repeat(t) {

        var sum = 0
        var temp = 0
        val input = readLine().toString()

        for(char in input) {
            if(char == 'O') {
                sum += ++temp
            }
            else {
                temp = 0
            }
        }

        println(sum)
    }

    close()
}