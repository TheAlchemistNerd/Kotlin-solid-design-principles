package com.composition

interface WithdrawBehaviour {
    fun withdraw(account: ComposableBankAccount, amount: Double)
}