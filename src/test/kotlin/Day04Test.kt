import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day04Test {

    @Test
    fun tst() {
        isOverlapping("2-4,6-8") shouldBe false
        isOverlapping("5-7,7-9") shouldBe false
        isOverlapping("2-8,3-7") shouldBe true
        isOverlapping("6-6,4-6") shouldBe true
    }

}