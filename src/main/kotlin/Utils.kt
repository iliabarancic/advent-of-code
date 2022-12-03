fun parseInput(fileName: String) = {}.javaClass.getResource("$fileName.txt")!!.readText().lines()
fun parseInputAsInt(fileName: String) = parseInput(fileName).map { it.toInt() }