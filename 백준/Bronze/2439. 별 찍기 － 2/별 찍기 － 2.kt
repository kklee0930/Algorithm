import java.util.*

fun main() = with(Scanner(System.`in`)) {

    val n = nextInt()
    close()

    for(i in 1..n) { // 별의 갯수

        for(j in n downTo 1) { // 공백의 갯수
            if(j > i) {
                print(" ")
            }
            else {
                print("*")
            }
        }
        println()
    }
}