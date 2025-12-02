package day01

import kotlin.math.abs
import kotlin.math.floor

fun main() {
    fun part1(input: List<String>): Int {
        var pos = 50
        var count = 0

        for (line in input) {
            val dir = line[0]
            val amount = line.substring(1).toInt()

            pos += if (dir == 'L') -amount else amount

            pos = ((pos % 100) + 100) % 100

            if (pos == 0) count++
        }

        return count
    }

    fun part2(input: List<String>): Int {
        var pos = 50
        var count = 0

        for (line in input) {
            val dir = if (line[0] == 'R') 1 else -1
            val amount = line.substring(1).toInt()

            repeat(amount) {
                pos = (pos + dir + 100) % 100
                if (pos == 0) count++
            }
        }

        return count
    }

    val testInput = readInput("day01/example")
    val part1 = part1(testInput)
    check(part1 == 3)
    val input = readInput("day01/input")
    part1(input).println()

    val part2 = part2(testInput)
    part2.println()
    check(part2 == 6)

    part2(input).println()
}
