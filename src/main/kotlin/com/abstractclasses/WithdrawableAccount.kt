abstract class WithdrawableAccount(initialBalance: Double = 0.0) : BankAccount(initialBalance) {
    abstract fun withdraw(amount: Double)
}