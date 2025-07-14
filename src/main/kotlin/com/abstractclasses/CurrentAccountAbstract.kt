package com.abstractclasses
class CurrentAccountAbstract(initialBalance: Double = 0.0) : WithdrawableAccount(initialBalance) {
    override fun withdraw(amount: Double) {
        require(amount > 0) { "Withdrawal amount must be positive." }
        balance -= amount // Allow overdraft
        println("Withdrew $amount from Current. New balance: $balance")
    }
}