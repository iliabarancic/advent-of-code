import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day02Test {

    private val sut = Day02()
    @Test
    fun calculateXPosition() {
        sut.calculateXPosition(parseInput("Day02").take(20)) shouldBe 50
    }

    @Test
    fun calculateDepth() {
        sut.calculateDepth(parseInput("Day02").take(30)) shouldBe 24
    }
}