package ai.rever.boss.performance

import java.time.LocalDateTime
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertEquals

class ExportTimestampTest {
    private val time = LocalDateTime.of(2025, 9, 19, 13, 53, 20)

    @Test
    fun `export timestamp is the same ASCII string under every default locale`() {
        val original = Locale.getDefault()
        try {
            listOf("en-US", "th-TH-u-ca-buddhist", "ar-EG", "fa-IR").forEach { tag ->
                Locale.setDefault(Locale.forLanguageTag(tag))
                assertEquals("20250919-135320", exportTimestamp(time), "locale $tag")
            }
        } finally {
            Locale.setDefault(original)
        }
    }
}
