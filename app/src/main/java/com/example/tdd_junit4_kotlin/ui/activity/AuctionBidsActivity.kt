package com.example.tdd_junit4_kotlin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tdd_junit4_kotlin.databinding.ActivityAuctionBindsBinding
import com.example.tdd_junit4_kotlin.ui.const.ConstObj
import com.example.tdd_junit4_kotlin.ui.model.Auction


class AuctionBidsActivity : AppCompatActivity() {
    lateinit var binding : ActivityAuctionBindsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuctionBindsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val auction = intent.getSerializableExtra(ConstObj.AUCTION, Auction::class.java)

        if(auction != null) {
            with(binding) {
                auction.run {
                    biddingDescriptionTitleTextView.text = description ?: ""
                    highestBiddingValueTextView.text = getBiggerBid().toString()
                    lowestBidderValueTextView.text = getSmallerBid().toString()
                    highestBidsValuesTextView.text = threeBiggersAuction().joinToString(" \n") { "${it.getValue()}" }
                }
            }
        }
    }
}