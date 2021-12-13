class Day04 {

    fun checkBingo(input: List<String>) {
        val numbers = getNumbers(input)
        val bingoCards = getBingoCards(input)
        for (number in numbers) {
            val result = openNumberAndCheckResult(number, bingoCards)
            if (result != null) {
                println(result)
                break
            }
        }
    }

    private fun getNumbers(input: List<String>) = input.first().split(",").map { it.toInt() }

    private fun getBingoCards(input: List<String>): List<BingoCard> {
        val result = mutableListOf<BingoCard>()
        for (i in 2..input.size step 6) {
            val bingoField = BingoCard(input.subList(i, i + 5).map { it.split(" ").filter(String::isNotBlank).map(String::toInt) })
            result.add(bingoField)
        }
        return result.toList()
    }

    private fun openNumberAndCheckResult(number: Int, bingoCards: List<BingoCard>): Int? {
        bingoCards.forEach { bingoCard ->
            bingoCard.open(number)
            if (bingoCard.rowCompleted() || bingoCard.columnCompleted()) {
                return bingoCard.calculateResult(number)
            }
        }
        return null
    }

    private class BingoCard(fields: List<List<Int>>) {
        val rows: List<Row> = fields.map { Row(it.map { v -> Field(v) }) }
        val columns = (0..4).map { column -> Row(rows.map { (it.fields[column]) }) }

        fun open(number: Int) {
            rows.flatMap { it.fields }.singleOrNull { it.number == number }?.apply { isOpen = true }
        }

        fun rowCompleted() = findCompletedRowOrColumn(rows) != null
        fun columnCompleted() = findCompletedRowOrColumn(columns) != null

        private fun findCompletedRowOrColumn(rowOrColumn: List<Row>): Row? {
            rowOrColumn.forEach {
                if (it.fields.all(Field::isOpen)) return it
            }
            return null
        }

        fun calculateResult(lastNumber: Int): Int {
            var resultList = if (rowCompleted()) {
                rows.toMutableList() - findCompletedRowOrColumn(rows)!!
            } else {
                columns.toMutableList() - findCompletedRowOrColumn(columns)!!
            }
            return resultList.flatMap { it.fields.filterNot(Field::isOpen).map { field -> field.number } }.sum() * lastNumber
        }
    }

    private data class Row(val fields: List<Field>)
    private data class Field(val number: Int, var isOpen: Boolean = false)

}

fun main() {
    Day04().checkBingo(parseInput("Day04"))
}