class Day02 {

    fun calculatePosition(input: List<String>): Int {
        return calculateXPosition(input) * calculateDepth(input)
    }

    fun calculateXPosition(input: List<String>): Int {
        return input.filter { it.contains("forward") }.map { it.replace("forward ", "") }.sumOf { it.toInt() }
    }

    fun calculateDepth(input: List<String>): Int {
        return input.asSequence().filterNot { it.contains("forward") }
            .map { it.replace("up ", "-") }
            .map { it.replace("down ", "") }
            .sumOf { it.toInt() }
    }
}

fun main() {
    println(Day02().calculatePosition(parseInput("Day02")))

}