package com.isp


class CurrentAccount(private var balance: Double = 0.0) : Account, Withdrawable {
    override fun deposit(amount: Double) {
        require(amount > 0) { "Deposit amount must be positive." }
        balance += amount
        println("Deposited $amount to Current. New balance: $balance")
    }

    override fun viewBalance(): Double {
        return balance
    }

    override fun withdraw(amount: Double) {
        require(amount > 0) { "Withdrawal amount must be positive." }
        // For CurrentAccount, we might allow overdrafts up to a limit
        balance -= amount
        println("Withdrew $amount from Current. New balance: $balance")
    }
}