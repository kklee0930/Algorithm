fun main() {
    val set : MutableSet<Int> = mutableSetOf()

    repeat(10) {
        set.add(readln().toInt() % 42)
    }

    println(set.size)
}