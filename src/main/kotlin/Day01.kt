class Day01 {

    fun countIncreases(numbers: List<Int>): Int {
        return numbers.windowed(2, 1).sumOf(::numberIncreased)
    }

    private fun numberIncreased(pairs: List<Int>): Int {
        return if (pairs.last() > pairs.first()) 1 else 0
    }

}

fun main() {
    println("final result: ${Day01().countIncreases(parseInputAsInt("Day01"))}")
}