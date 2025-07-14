package com.composition

class OverdraftWithdraw: WithdrawBehaviour{
    override fun withdraw(account: ComposableBankAccount, amount: Double) {
        require(amount > 0) { "Withdrawal amount must be positive." }
        account.decreaseBalance(amount) // overdraft allowed
        println("Overdraft withdrawal of $amount. New balance: ${account.balance}")
    }
}