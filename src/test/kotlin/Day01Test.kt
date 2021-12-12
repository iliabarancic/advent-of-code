import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day01Test {

    private val sut = Day01()

    @Test
    fun countIncreases() {
        sut.countIncreases(listOf(1, 2, 3, 1)) shouldBe 2
    }

    @Test
    fun countIncreases2() {
        sut.countIncreases(listOf(1, 2, 3, 1, 5, 8, 2, 3)) shouldBe 5
    }

    @Test
    fun countIncreases30() {
        sut.countIncreases(parseInputAsInt("Day01").take(30)) shouldBe 20
    }

}