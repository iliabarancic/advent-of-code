fun findDuplicateLetterNumber(textLine: String): Int {
    val chars = textLine.toCharArray().toList().chunked(textLine.length / 2)
    val single = chars.first().intersect(chars.last()).single()
    return getCharsValue(single)
}

fun getCharsValue(char: Char) = char.code - if (char.isUpperCase()) 38 else 96

fun findDuplicateLetterNumberFromLists(charGroup: List<String>): Int {
    check(charGroup.size == 3)
    return charGroup
        .map { it.toCharArray().toSet() }
        .reduce(Set<Char>::intersect)
        .single()
        .let(::getCharsValue)

}

fun findSumOfAllDuplicates(charLines: List<String>): Int = charLines.sumOf(::findDuplicateLetterNumber)
fun findSumOfAllDuplicatesGroups(charLines: List<String>): Int = charLines.chunked(3).sumOf(::findDuplicateLetterNumberFromLists)


fun main() {
    println("final result: ${findSumOfAllDuplicates(parseInput("Day03"))}")
    println("final result2: ${findSumOfAllDuplicatesGroups(parseInput("Day03"))}")
}