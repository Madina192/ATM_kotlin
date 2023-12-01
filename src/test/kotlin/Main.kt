import java.util.*

var users = mutableMapOf<String, Any>("login" to "madina", "password" to "1234", "balance" to 2000)

fun main() {
    println("Welcome to our bank!")
    auth()
}

fun auth() {
    var isValid = false
    while (!isValid) {
        val login = inputHandler("Enter login: ")
        val password = inputHandler("Enter password: ")
        if (login == users["login"] && password == users["password"]) {
            runApp()
            isValid = true
        } else {
            isValid = !isDone()
        }
    }
}

fun runApp() {
    while (true) {
        val action = inputHandler("Choose action: 1 - show balance, 2 - deposit, 3 - withdraw, 4 - exit")
        if (action == "4") {
            println("Bye!")
            break
        } else {
            performAction(action)
        }
    }
}

fun performAction(action: String) {
    when (action) {
        "1" -> {
            showBalance()
        }

        "2" -> {
            deposit()
            showBalance()
        }

        "3" -> {
            withDraw()
            showBalance()
        }
    }
}

fun showBalance() {
    println("Your balance: ${users["balance"]}")
}

fun deposit() {
    users["balance"] = users["balance"] as Int + inputHandler("Enter amount: ").toInt()
}

fun withDraw() {
    users["balance"] = users["balance"] as Int - inputHandler("Enter amount: ").toInt()
}

fun isDone(): Boolean {
    return inputHandler("try again? yes/no").lowercase(Locale.getDefault()) == "yes"
}

fun inputHandler(outputText: String): String {
    println(outputText)
    val scanner = Scanner(System.`in`)
    return scanner.nextLine()
}

