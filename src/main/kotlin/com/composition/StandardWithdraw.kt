package com.composition

class StandardWithdraw: WithdrawBehaviour {
    override fun withdraw(account: ComposableBankAccount, amount: Double) {
        require(amount > 0) { "Withdrawal amount must be positive." }
        if (amount > account.balance) {
            throw IllegalArgumentException("Insufficient funds for standard withdrawal.")
        }
        account.decreaseBalance(amount)
        println("Standard withdrawal of $amount. New balance: ${account.balance}")
    }
}