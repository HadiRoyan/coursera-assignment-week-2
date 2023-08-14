package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0;
    var tempSecret = "";
    var tempGuess = "";

    for (i in secret.indices) {
        if (guess[i] == secret[i]) { // find the right position
            rightPosition++
        } else { // for the wrong position
            tempSecret += secret[i]
            tempGuess += guess[i]
        }
    }

    if (tempSecret.isNotEmpty()) {
        for (j in 'A'..'F') {
            // calculate wrong position
            wrongPosition += tempSecret.count { it == j }.coerceAtMost(tempGuess.count { it == j })
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}
//
//fun main(args: Array<String>) {
//    val evaluateGuess1 = evaluateGuess("BCDF", "ACEB")
//    println(evaluateGuess1)
//    val evaluateGuess2 = evaluateGuess("AAAF", "ABCA")
//    println(evaluateGuess2)
//    val evaluateGuess3 = evaluateGuess("ABCD", "ABCD")
//    println(evaluateGuess3)
//    val evaluateGuess4 = evaluateGuess("DBFF", "FFDD")
//    println(evaluateGuess4)
//    val evaluateGuess5 = evaluateGuess("CFDF", "FCDD")
//    println(evaluateGuess5)
//}

