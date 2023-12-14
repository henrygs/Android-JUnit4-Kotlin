package com.example.tdd_junit4_kotlin.ui.model

import java.io.Serializable

class Bid(private val user: User? = null, private val value: Double? = null): Serializable, Comparable<Bid>{

    fun getValue(): Double {
        return value ?: 0.0
    }

    override fun compareTo(other: Bid): Int {
        val bid = other as Bid
        val bidValue = value ?: 0.0
        if (bidValue > bid.getValue()) {
            return -1
        }
        return if (bidValue < bid.getValue()) {
           return  1
        } else 0
    }

}