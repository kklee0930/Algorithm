import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (N, M) = readLine().split(" ").map { it.toInt() }
    val intToString = hashMapOf<Int, String>()
    val stringToInt = hashMapOf<String, Int>()

    for(i in 1 .. N) {
        val name = readLine()
        intToString[i] = name
        stringToInt[name] = i
    }

    repeat(M) {
        val input = readLine()
        if(isNumeric(input)) {
            intToString[input.toInt()]?.let { it1 -> bw.write("$it1\n") }
        }
        else {
            bw.write("${stringToInt[input].toString()}\n")
        }
    }
    close()
    bw.flush()
    bw.close()
}

fun isNumeric(input : String) : Boolean {
    return input.toDoubleOrNull() != null
}
