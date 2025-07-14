package com.abstractclasses

abstract class BankAccount(protected var balance: Double =0.0) {
    fun deposit(amount: Double) {
        require(amount > 0) {"Deposit amount must be positive."}
        balance += amount
        println("Deposited $amount. New Balance: $balance")
    }

    fun viewBalance(): Double {
        return balance
    }

    // withdraw is NOT defined here. Only in specific subclasses
}