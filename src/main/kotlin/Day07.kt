class Folder(
    val name: String,
    private val folders: MutableList<Folder> = mutableListOf(),
    private val files: MutableList<File> = mutableListOf(),
    val parent: Folder? = null
) {
    fun addFolder(name: String): Folder {
        val folder = Folder(name, parent = this)
        folders.add(folder)
        return folder
    }

    fun addFile(size: Long) = files.add(File(size))
    fun size(): Long = folders.sumOf { it.size() } + files.sumOf { it.size }

    fun getAllFoldersWithSizes(): List<Pair<String, Long>> {
        return folders.map { it.name to it.size() } + folders.flatMap { it.getAllFoldersWithSizes() }
    }
}

data class File(val size: Long)

private fun getDirectory(input: List<String>): Folder {
    val parent = Folder("/")
    var currentFolder = parent
    val cd = """\$ cd (.*)""".toRegex()
    val dir = """\$ dir (.*)""".toRegex()
    val file = """(\d+) .*""".toRegex()

    input.forEach { command ->
        when {
            command == "$ cd .." -> currentFolder = currentFolder.parent ?: error("most upper")
            cd.matches(command) -> currentFolder = currentFolder.addFolder(cd.find(command)!!.destructured.component1())
            dir.matches(command) -> currentFolder.addFolder(cd.find(command)!!.destructured.component1())
            file.matches(command) -> currentFolder.addFile(file.find(command)!!.destructured.component1().toLong())
        }
    }
    return parent
}

fun getSumOfFolderSizes(input: List<String>): Long {
    val parent = getDirectory(input)
    return parent.getAllFoldersWithSizes().filter { it.second <= 100000 }.sumOf { it.second }
}

fun getFolderSizeToDelete(input: List<String>): Long {
    val parent = getDirectory(input)
    val neededSpace = 30000000 - (70000000 - parent.size())
    return parent.getAllFoldersWithSizes().filter { it.second >= neededSpace }.minOf { it.second }
}

fun main() {
    println("final result: ${getSumOfFolderSizes(parseInput("Day07").drop(1))}")
    println("final result: ${getFolderSizeToDelete(parseInput("Day07").drop(1))}")

}