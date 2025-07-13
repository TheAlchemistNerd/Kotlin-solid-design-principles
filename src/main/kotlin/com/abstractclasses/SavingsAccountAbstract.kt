class SavingsAccountAbstract (intialBalance: Double = 0.0) : WithdrawableAccount(initialBalance) {
    override fun withdraw(amount: Double) {
        require(amount > 0) { "Withdrawal amount must be positive." }
        if (amount <= balance) {
            balance -= amount
            println("Withdrew $amount from Savings. New balance: $balance")
        } else {
            throw IllegalArgumentException("Insufficient balance in Savings Account.")
        }
    }
}