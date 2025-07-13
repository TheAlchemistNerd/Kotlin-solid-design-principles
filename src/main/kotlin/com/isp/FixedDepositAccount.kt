package com.isp

class FixedDepositAccount (private var balance: Double = 0.0) : Account {
    override fun deposit(amount: Double) {
        require(amount > 0) { "Deposit amount must be positive." }
        balance += amount
        println("Deposited $amount to Fixed Deposit. New balance: $balance")
    }

    override fun viewBalance(): Double {
        return balance
    }

        // No withdraw() method here — complies with LSP and ISP
}
