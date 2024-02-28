import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    // !!(null 허용하지 않음) / ?(null 허용)
    val input = readLine()!!.toString()
    // mutableListOf, mutableSetOf, mutableMapOf...
    val map = mutableMapOf<String, Int>()

    input.forEach {
        val character = it.lowercase()
        map[character] = map.getOrDefault(character, 0).plus(1)
    }

    // map 에서 max 값 구하기
    val max = map.maxBy { it.value }

    if(map.filter { it.value == max.value }.count() > 1) println("?")
    else println(max.key.uppercase())
}