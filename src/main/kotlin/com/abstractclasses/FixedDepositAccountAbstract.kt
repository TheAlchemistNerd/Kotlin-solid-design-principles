package com.abstractclasses

class FixedDepositAccountAbstract(initialBalance: Double = 0.0) : BankAccount(initialBalance) {
    // No withdraw method — safe and compliant
}