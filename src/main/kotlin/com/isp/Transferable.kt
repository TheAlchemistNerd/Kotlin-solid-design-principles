package com.isp

interface Transferable {
    fun transfer(recipient: Account, amount: Double)
}