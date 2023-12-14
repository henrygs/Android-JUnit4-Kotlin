package com.example.tdd_junit4_kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tdd_junit4_kotlin.databinding.ItemAuctionBinding
import com.example.tdd_junit4_kotlin.ui.model.Auction

class AuctionAdapter(private val context: Context, private val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<AuctionViewHolder>(){

    private var auctions: List<Auction> = listOf()

    fun addAuctions(auctions: ArrayList<Auction>) {
        this.auctions = auctions
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuctionViewHolder {
        val binding = ItemAuctionBinding.inflate(LayoutInflater.from(context), parent, false)
        return AuctionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AuctionViewHolder, position: Int) {
        val auction = auctions[position]
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(auction)
        }
        holder.find(auction)
    }

    override fun getItemCount(): Int {
        return auctions.size
    }
}