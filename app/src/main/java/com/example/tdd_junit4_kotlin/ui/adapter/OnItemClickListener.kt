package com.example.tdd_junit4_kotlin.ui.adapter

import com.example.tdd_junit4_kotlin.ui.model.Auction

interface OnItemClickListener {
    fun onItemClick(auction: Auction)
}