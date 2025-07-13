package com.isp

class SavingsAccount(private var balance: Double = 0.0) : Account, Withdrawable {
    override fun deposit(amount: Double) {
        require(amount > 0) { "Deposit amount must be positive." }
        balance += amount
        println("Deposited $amount to Savings. New balance: $balance")
    }

    override fun viewBalance(): Double {
        return balance
    }

    override fun withdraw(amount: Double) {
        require(amount > 0) {"Withdrawal amount must be positive."}
        if (amount <= balance) {
            balance -= amount
            println("Withdrew $amount from savings. New balance: $balance")
        } else {
            throw IllegalArgumentException("Insufficient balance in Savings Account.")
        }
    }
}