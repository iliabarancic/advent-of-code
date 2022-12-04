

fun isOverlapping(line: String): Boolean {
    val (range1, range2) = line.split(',')
        .map { it.toRange().toSet() }

    return range1.intersect(range2).let {
        it.size == range1.size || it.size == range2.size
    }
}

fun isOverlappingPartially(line: String): Boolean {
    val (range1, range2) = line.split(',')
        .map { it.toRange().toSet() }

    return range1.intersect(range2).isNotEmpty()
}

private fun String.toRange(): LongRange {
    val regex = """(\d+)-(\d+)""".toRegex()
    val (start, end) = regex.find(this)!!.destructured
    return start.toLong() .. end.toLong()
}

fun countOverlapping(lines: List<String>) = lines.count { isOverlapping(it) }
fun countOverlappingPartially(lines: List<String>) = lines.count { isOverlappingPartially(it) }


fun main() {
    println("final result: ${countOverlapping(parseInput("Day04"))}")
    println("final result2: ${countOverlappingPartially(parseInput("Day04"))}")

}