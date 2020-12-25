import java.io.File

fun winningMove(inputFileName: String, currentSide: Char): Pair<Int, Int>? {
    var result = Pair(0, 0)
    val field = File(inputFileName).readLines()
    val sb = StringBuilder()
    val winningCombinations = mutableListOf<String>()
    for (i in 0..4) {
        for (j in 1..i) sb.append(currentSide)
        sb.append('-')
        for (j in 1..4 - i) sb.append(currentSide)
        winningCombinations.add(sb.toString())
        sb.setLength(0)
    }

    fun checkHorizontal(i: Int, j: Int): Boolean {
        val substring = field[i].substring(j until j + 5)
        if (substring in winningCombinations) {
            result = Pair(j + substring.indexOf('-') + 1, i + 1)
            return true
        }
        return false
    }

    fun checkVertical(i: Int, j: Int): Boolean {
        for (k in i until i + 5) {
            sb.append(field[k][j])
        }
        val substring = sb.toString()
        sb.setLength(0)
        if (substring in winningCombinations) {
            result = Pair(j + 1, i + substring.indexOf('-') + 1)
            return true
        }
        return false
    }

    fun checkDiagonal(i: Int, j: Int): Boolean {
        for (k in 0..4) {
            sb.append(field[i + k][j + k])
        }
        val substring = sb.toString()
        sb.setLength(0)
        if (substring in winningCombinations) {
            result = Pair(j + substring.indexOf('-') + 1, i + substring.indexOf('-') + 1)
            return true
        }
        return false
    }

    fun checkAntiDiagonal(i: Int, j: Int): Boolean {
        for (k in 0..4) {
            sb.append(field[i - k][j + k])
        }
        val substring = sb.toString()
        sb.setLength(0)
        if (substring in winningCombinations) {
            result = Pair(j + substring.indexOf('-') + 1, i - substring.indexOf('-') + 1)
            return true
        }
        return false
    }

    for (i in field.indices) {
        for (j in field[i].indices) {
            if (j in 0..10) {
                if (checkHorizontal(i, j)) {
                    return result
                } else if (i in 4..14 && checkAntiDiagonal(i, j)) {
                    return result
                }
            }
            if (i in 0..10) {
                if (checkVertical(i, j)) {
                    return result
                } else if (j in 0..10 && checkDiagonal(i, j)) {
                    return result
                }
            }
        }
    }
    return null
}