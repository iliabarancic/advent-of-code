import Day02.RockPaperScissors.*

class Day02 {

    enum class RockPaperScissors(val charSet: Char, val points: Int) {
        ROCK('A', 1),
        PAPER('B', 2),
        SCISSORS('C', 3);

        companion object {
            fun from(value: String): RockPaperScissors {
                return values().singleOrNull { it.charSet == value.first() } ?: error("$value unknown")
            }
        }
    }

    private fun String.toRockPaperScissors(): Pair<RockPaperScissors, RockPaperScissors> =
        this.split(" ").let { split ->
            val elvesFigure = RockPaperScissors.from(split.first())
            elvesFigure to chooseMyHand(elvesFigure, split.last())
        }

    private fun chooseMyHand(elvesFigure: RockPaperScissors, last: String) =
        when (last to elvesFigure) {
            "X" to SCISSORS -> PAPER
            "X" to PAPER -> ROCK
            "X" to ROCK -> SCISSORS
            "Z" to SCISSORS -> ROCK
            "Z" to PAPER -> SCISSORS
            "Z" to ROCK -> PAPER

            else -> elvesFigure
        }

    fun playRound(round: Pair<RockPaperScissors, RockPaperScissors>): Int {
        if (round.first == round.second) {
            return round.second.points + 3
        }

        return round.second.points + when (round) {
            ROCK to PAPER, PAPER to SCISSORS, SCISSORS to ROCK -> 6
            else -> 0
        }
    }

    fun play(input: List<String>): Int = input.sumOf { playRound(it.toRockPaperScissors()) }


}

fun main() {
    println("final result: ${Day02().play(parseInput("Day02"))}")
}