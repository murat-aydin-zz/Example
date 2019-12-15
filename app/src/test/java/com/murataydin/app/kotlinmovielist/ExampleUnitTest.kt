
import android.annotation.SuppressLint
import android.view.View
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.regex.Pattern

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isAlgorithm() {

        algorithmCase("abbcccaaeeeeb bfffffca ccab",3)

    }

    @SuppressLint("NewApi")
    private fun algorithmCase(stringData: String, count: Int) {
        var data = stringData
        val m = Pattern.compile("(.+)\\1{" + (count - 1) + ",}").matcher(data)
        while (m.find()) {
            data = data.replace(m.group(), m.group().replace("(.)".toRegex(), "*"))
        }
        print(data)

    }
}