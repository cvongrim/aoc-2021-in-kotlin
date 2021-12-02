fun main() {
    fun part1(input: List<String>): Int {
        var totalElevationIncreases = 0
        var previousElevation = 0

        for (currentElevation in input) {
            val currentElevationInt = currentElevation.toInt()
            if(previousElevation != 0 && previousElevation < currentElevationInt) {
                totalElevationIncreases++
            }
            previousElevation = currentElevationInt
        }
        return totalElevationIncreases
    }

    fun part2(input: List<String>): Int {
        val window = mutableListOf<Int>()
        var totalElevationIncreases = 0
        var previousElevationTotal = 0

        for (currentElevation in input) {

            window.add(currentElevation.toInt())

            if(window.size == 3){
                var currentElevationTotal = 0

                for(elevation in window){
                    currentElevationTotal += elevation
                }

                if(previousElevationTotal != 0 && previousElevationTotal < currentElevationTotal) {
                    totalElevationIncreases++
                }

                window.removeFirst()
                previousElevationTotal = currentElevationTotal
            }
        }

        return totalElevationIncreases
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
