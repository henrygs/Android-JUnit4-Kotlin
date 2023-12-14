package com.example.tdd_junit4_kotlin.ui.model
import java.io.Serializable
import java.util.Collections

class Auction(val description: String? = null,
                   private val bids: ArrayList<Bid> = arrayListOf(),
                   private var biggerBid: Double = Double.NEGATIVE_INFINITY,
                   private var smallerBid: Double = Double.POSITIVE_INFINITY): Serializable {

    fun propose(bid: Bid) {
        bids.add(bid)
        Collections.sort(bids)
        val valueBid = bid.getValue()
        calculatorBiggerAuction(valueBid)
        calculatorSmallerAuction(valueBid)
    }

    fun calculatorBiggerAuction(valueBid: Double) {
        if(valueBid > biggerBid) {
            biggerBid = valueBid
        }
    }

    fun calculatorSmallerAuction(valueBid: Double) {
        if(valueBid < smallerBid) {
            smallerBid = valueBid
        }
    }
    fun threeBiggersAuction(): List<Bid> {
        var quantityMaxAuction = bids.size
        if (quantityMaxAuction > 3) {
            quantityMaxAuction = 3
        }
        return bids.subList(0, quantityMaxAuction)
    }

    fun getBiggerBid(): Double {
        return biggerBid
    }

    fun getSmallerBid(): Double {
        return smallerBid
    }
}