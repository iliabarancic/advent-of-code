fun findFourUnique(input: String, numberOfUniqueSymbols: Int): Int {
    return (0..input.length - numberOfUniqueSymbols).takeWhile {
        input.subSequence(it, it + numberOfUniqueSymbols).toSet().size != numberOfUniqueSymbols
    }.last() + numberOfUniqueSymbols + 1
}

fun main() {
    println("final result: ${findFourUnique(parseInput("Day06").first(), 4)}")
    println("final result2: ${findFourUnique(parseInput("Day06").first(), 14)}")

}