package com.composition

class ComposableBankAccount (
    private var _balance: Double,
    private var withdrawBehaviour: WithdrawBehaviour
) {
    var balance: Double
        get() = _balance
        private set(value) {_balance = value} // Only allow internal modification

    fun deposit(amount: Double) {
        require(amount > 0) {"Deposit amount must be positive."}
        balance += amount
        println("Deposited $amount. New Balance: $balance")
    }

    fun handleWithdrawal(amount: Double) {
        withdrawBehaviour.withdraw(this, amount)
    }

    fun decreaseBalance(amount: Double) {
        this.balance -= amount
    }

    fun setWithdrawBehaviour(behaviour: WithdrawBehaviour) {
        this.withdrawBehaviour = behaviour
    }
}