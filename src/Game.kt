/**
 * @Description
 * The console game compares the two choices. If they are the same, the result is a draw.
 * If the choices are different, however, the game determines the winner.
 * The game will be run in the IDE’s output window.
 */

fun main() {
    var result : String
    do {
        val options = arrayOf("Rock", "Paper", "Scissors")
        val gameChoice = getGameChoice(options)
        val userChoice = getUserChoice(options)
      result =  printResult(userChoice, gameChoice)
    } while (result == "Tie!")
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {

    var isValidChoice = false
    var userChoice = ""

    while (!isValidChoice) {
        print("Please enter one of the following:")

        for (item in optionsParam) print(" $item")

        println(".")

        val userInput = readLine()?.capitalize()

        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }

        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) : String{
    val result: String = if (userChoice == gameChoice) "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        userChoice == "Scissors" && gameChoice == "Paper"
    ) "You win!"
    else "You lose!"

    println("You chose $userChoice. I chose $gameChoice. $result")
    return result
}