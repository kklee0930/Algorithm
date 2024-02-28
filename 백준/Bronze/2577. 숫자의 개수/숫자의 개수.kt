import java.util.*

fun main() = with(Scanner(System.`in`)) {

    var temp = 1

    repeat(3) {
        temp = temp.times(nextInt())
    }

    val str : String = temp.toString()

    for(i : Int in 0..9)
        println(str.count { it.toString() == i.toString() })
}