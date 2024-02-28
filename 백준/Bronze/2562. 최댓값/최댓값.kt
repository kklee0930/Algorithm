import java.util.*

fun main() = with(Scanner(System.`in`)) {

    var arr = mutableListOf<Int>()
    for(i: Int in 1..9)
        arr.add(nextInt())

    close()

    val max = arr.maxBy { it }
    val idx = arr.indexOf(max).plus(1)

    println(max)
    println(idx)
}