package com.isp

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
}