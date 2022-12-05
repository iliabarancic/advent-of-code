val stacks = listOf(
    ArrayDeque(listOf("D", "Z", "T", "H")),
    ArrayDeque(listOf("S", "C", "G", "T", "W", "R", "Q")),
    ArrayDeque(listOf("H", "C", "R", "N", "Q", "F", "B", "P")),
    ArrayDeque(listOf("Z", "H", "F", "N", "C", "L")),
    ArrayDeque(listOf("S", "Q", "F", "L", "G")),
    ArrayDeque(listOf("S", "C", "R", "B", "Z", "W", "P", "V")),
    ArrayDeque(listOf("J", "F", "Z")),
    ArrayDeque(listOf("Q", "H", "R", "Z", "V", "L", "D")),
    ArrayDeque(listOf("D", "L", "Z", "F", "N", "G", "H", "B")),
)

private fun List<ArrayDeque<String>>.applyCommand(command: String) {
    val (times, from, to) = parseCommand(command)
    val fromStack = get(from)
    val toStack = get(to)
//Solution 1
//    repeat(times) {
//        toStack.addFirst(fromStack.removeFirst())
//    }
// Solution 2
    (0 until times).map { fromStack.removeFirst() }.reversed().forEach(toStack::addFirst)
}

private fun parseCommand(command: String): Triple<Int, Int, Int> {
    val (times, from, to) = """move (\d+) from (\d+) to (\d+)""".toRegex().find(command)?.destructured ?: error("no match for $command")
    return Triple(times.toInt(), from.toInt() - 1, to.toInt() - 1)
}

fun rearrangeBoxes(stacks: List<ArrayDeque<String>>, commands: List<String>): String {
    commands.forEach(stacks::applyCommand)
    return stacks.joinToString(separator = "") { it.first() }
}

fun main() {
    println("final result: ${rearrangeBoxes(stacks, parseInput("Day05"))}")

}