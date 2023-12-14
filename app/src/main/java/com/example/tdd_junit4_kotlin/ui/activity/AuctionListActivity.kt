package com.example.tdd_junit4_kotlin.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tdd_junit4_kotlin.databinding.ActivityAuctionListBinding
import com.example.tdd_junit4_kotlin.ui.adapter.AuctionAdapter
import com.example.tdd_junit4_kotlin.ui.adapter.OnItemClickListener
import com.example.tdd_junit4_kotlin.ui.const.ConstObj
import com.example.tdd_junit4_kotlin.ui.model.Auction
import com.example.tdd_junit4_kotlin.ui.model.Bid
import com.example.tdd_junit4_kotlin.ui.model.User

class AuctionListActivity : AppCompatActivity(), OnItemClickListener {

    lateinit var binding: ActivityAuctionListBinding
    private val adapter by lazy { AuctionAdapter(this, this@AuctionListActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuctionListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter.addAuctions(auctionsMock())
        binding.auctionRecyclerview.adapter = adapter
    }

    override fun onItemClick(auction: Auction) {
        val intent = Intent(this@AuctionListActivity, AuctionBidsActivity::class.java)
        intent.putExtra(ConstObj.AUCTION, auction)
        startActivity(intent)
    }

    fun auctionsMock(): ArrayList<Auction> {
        val list = arrayListOf<Auction>()
        val auction = Auction("Console")
        auction.propose(Bid(User("Henrique"), 200.0))
        auction.propose(Bid(User("Zequinha"), 300.0))
        list.add(auction)
        return list
    }
}