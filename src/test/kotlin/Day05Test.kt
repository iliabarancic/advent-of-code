import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day05Test {
    private val stacks = listOf(
        ArrayDeque(listOf("N", "Z")),
        ArrayDeque(listOf("D", "C", "M")),
        ArrayDeque(listOf("P")),
    )

    val commands = listOf(
        "move 1 from 2 to 1",
        "move 3 from 1 to 3",
        "move 2 from 2 to 1",
        "move 1 from 1 to 2",
    )

    @Test
    fun testCommands() {
        rearrangeBoxes(stacks, commands) shouldBe "MCD"
    }

}