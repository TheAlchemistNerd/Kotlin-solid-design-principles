package com

import com.abstractclasses.CurrentAccountAbstract
import com.abstractclasses.FixedDepositAccountAbstract
import com.abstractclasses.SavingsAccountAbstract
import com.composition.ComposableBankAccount
import com.composition.NoWithdraw
import com.composition.OverdraftWithdraw
import com.composition.StandardWithdraw
import com.isp.*


fun processWithdrawal(account: Withdrawable, amount: Double) {
    try {
        account.withdraw(amount)
    } catch (e: IllegalArgumentException) {
        println("Withdrawal failed: ${e.message}")
    }
}

fun main() {
    val savings = SavingsAccount(1000.0)
    val current = CurrentAccount(500.0)
    val fixedDeposit = FixedDepositAccount(2000.0)

    println("\n--- Processing Withdrawals ---")
    processWithdrawal(savings, 200.0) // OK
    processWithdrawal(current, 700.0) // OK (Current might allow overdraft)

    // This will cause a compile-time error if uncommented, which is good!
    // processWithdrawal(fixedDeposit, 100.0)
    // Error: Type mismatch: inferred type is FixedDepositAccount but Withdrawable was expected

    // To interact with FixedDepositAccount, we use its specific interface or common 'Account'
    fixedDeposit.deposit(100.0)
    println("Fixed Deposit balance: ${fixedDeposit.viewBalance()}")

    println("\n--- Demonstrating polymorphism with Account interface ---")
    val accounts: List<Account> = listOf(savings, current, fixedDeposit)
    for (acc in accounts) {
        println("Account balance: ${acc.viewBalance()}")
        acc.deposit(50.0) // All accounts can deposit
    }

    println("\n--- Using Abstract Classes (Kotlin) ---")
    val savingsAbs = SavingsAccountAbstract(1200.0)
    val currentAbs = CurrentAccountAbstract(600.0)
    val fixedDepositAbs = FixedDepositAccountAbstract(2500.0)

    savingsAbs.deposit(50.0)
    savingsAbs.withdraw(300.0)

    currentAbs.deposit(20.0)
    currentAbs.withdraw(700.0)

    fixedDepositAbs.deposit(100.0)
    println("Fixed Deposit (Abstract) balance: ${fixedDepositAbs.viewBalance()}")

    // This would also be a compile-time error:
    // processWithdrawal(fixedDepositAbs, 100.0)

    println("\n--- Using Composition (Kotlin) ---")
    val savingsComposed = ComposableBankAccount(1500.0, StandardWithdraw())
    val currentComposed = ComposableBankAccount(700.0, OverdraftWithdraw())
    val fixedDepositComposed = ComposableBankAccount(3000.0, NoWithdraw())

    savingsComposed.deposit(100.0)
    savingsComposed.handleWithdrawal(400.0) // OK
    try {
        savingsComposed.handleWithdrawal(1500.0) // Insufficient funds
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    currentComposed.deposit(50.0)
    currentComposed.handleWithdrawal(900.0) // Overdraft allowed

    fixedDepositComposed.deposit(200.0)
    try {
        fixedDepositComposed.handleWithdrawal(100.0) // Not allowed
    } catch (e: UnsupportedOperationException) {
        println("Error: ${e.message}")
    }

    // Runtime flexibility: Change behavior
    println("\nChanging savings account withdrawal behavior:")
    savingsComposed.setWithdrawBehaviour(OverdraftWithdraw())
    savingsComposed.handleWithdrawal(2000.0) // Now allows overdraft
}