import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File
import java.io.FileNotFoundException
import java.lang.IllegalArgumentException

internal class TicTacToeKtTest {

    @Test
    fun winningMove() {
        assertEquals(winningMove("input/input.txt", 'x'), null)
        assertEquals(winningMove("input/input1.txt", 'x'), Pair(1, 5))
        assertEquals(winningMove("input/input2.txt", 'o'), Pair(7, 5))
        assertEquals(winningMove("input/input3.txt", 'x'), Pair(3, 15))
        assertEquals(winningMove("input/input4.txt", 'o'), Pair(11, 5))
        assertEquals(winningMove("input/input5.txt", 'x'), null)
    }
}