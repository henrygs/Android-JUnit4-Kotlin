package com.example.tdd_junit4_kotlin.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.tdd_junit4_kotlin.databinding.ItemAuctionBinding
import com.example.tdd_junit4_kotlin.ui.model.Auction

class AuctionViewHolder (val binding: ItemAuctionBinding) : RecyclerView.ViewHolder(binding.root) {
    fun find(auction: Auction) {
        binding.run {
            auctionDescription.text = auction.description
            highestBidder.text = auction.getBiggerBid().toString()
        }
    }
}