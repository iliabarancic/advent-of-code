import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day03Test {

    @Test
    fun tst() {
        findDuplicateLetterNumber("vJrwpWtwJgWrhcsFMMfFFhFp") shouldBe 16
        findDuplicateLetterNumber("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL") shouldBe 38
        findDuplicateLetterNumber("PmmdzqPrVvPwwTWBwg") shouldBe 42
    }

    @Test
    fun name() {
        val input = listOf(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
        )
        val input2 = listOf(
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw",
        )
        findDuplicateLetterNumberFromLists(input) shouldBe 18
        findDuplicateLetterNumberFromLists(input2) shouldBe 52
    }
}