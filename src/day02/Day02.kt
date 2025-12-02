package day02

import day01.println
import day01.readInputAsLine

fun main() {
    fun getInvalidIds(
        input: String,
        regex: Regex,
    ): Long {
        var match: Long = 0
        input.split(",").forEach { sequence ->
            val (bottomRange, topRange) = sequence.split("-").map { it.toLong() }
            for (i in bottomRange..topRange) {
                regex.find(i.toString())?.let { match += it.value.toLong() }
            }
        }
        return match
    }

    val part1Regex = Regex("^(\\d+)\\1$")
    val testInput = readInputAsLine("day02/example")
    val testPart1 = getInvalidIds(testInput, part1Regex)
    testPart1.println()
    check(testPart1.toInt() == 1227775554)

    val input = readInputAsLine("day02/input")
    val part1 = getInvalidIds(input, part1Regex)
    part1.println()

    val part2Regex = Regex("^(\\d+)\\1+$")
    val testPart2 = getInvalidIds(testInput, part2Regex)
    testPart2.println()
    check(testPart2 == 4174379265)

    val part2 = getInvalidIds(input, part2Regex)
    part2.println()
}
