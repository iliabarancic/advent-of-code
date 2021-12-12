import Day03.RatingType.CO2
import Day03.RatingType.OXYGEN

class Day03 {

    fun calculatePowerConsumption(input: List<String>): Int {
        val gammaRate = calculateGammaRate(input)
        return gammaRate.toInt(2) * invertBinary(gammaRate).toInt(2)
    }

    fun calculateGeneratorRating(input: List<String>): Int {
        return calculateGeneratorRating(input, OXYGEN) * calculateGeneratorRating(input, CO2)
    }

    private fun calculateGammaRate(input: List<String>): String {
        val size = input.size / 2
        return buildString {
            input.first().indices.forEach {
                val currentSymbol = if (input.map { line -> line[it] }.count { it == '1' } > size) "1" else "0"
                append(currentSymbol)
            }
        }
    }

    private fun calculateGeneratorRating(input: List<String>, rating: RatingType): Int {
        val inputCopy = input.toMutableList()
        for (index in input.first().indices) {
            val groupBy = inputCopy.map { it[index] }.groupBy { it }
            val mostCommon = when (rating) {
                OXYGEN -> if (groupBy['1']!!.size >= groupBy['0']!!.size) '1' else '0'
                CO2 -> if (groupBy['0']!!.size <= groupBy['1']!!.size) '0' else '1'
            }
            inputCopy.removeIf { it[index] != mostCommon }
            if (inputCopy.size == 1) break
        }
        return inputCopy.single().toInt(2)
    }

    private enum class RatingType {
        OXYGEN, CO2;
    }

}

private fun invertBinary(binary: String): String {
    return buildString { binary.forEach { append(if (it == '1') "0" else "1") } }
}


fun main() {
    println(Day03().calculatePowerConsumption(parseInput("Day03")))
    println(Day03().calculateGeneratorRating(parseInput("Day03")))

}