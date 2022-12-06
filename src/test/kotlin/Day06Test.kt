import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day06Test {

    private val input7 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
    private val input5 = "bvwbjplbgvbhsrlpgdmjqwftvncz"
    private val input6 = "nppdvjthqldpwncqszvftbrmjlhg"
    private val input10 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"

    @Test
    fun name() {
        findFourUnique(input7, 4) shouldBe 7
        findFourUnique(input5, 4) shouldBe 5
        findFourUnique(input6, 4) shouldBe 6
        findFourUnique(input10, 4) shouldBe 10
    }
}