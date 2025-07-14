package com.composition

class NoWithdraw : WithdrawBehaviour {
    override fun withdraw(account: ComposableBankAccount, amount: Double) {
        throw UnsupportedOperationException("Withdrawals not allowed from this account type.")
    }
}