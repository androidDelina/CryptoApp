package com.example.cryptoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_coin_detail.*

class CoinDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)

        if (!intent.hasExtra(EXTRA_FROM_SYMB)) {
            finish()
            return
        }
        val fSym: String = intent.getStringExtra(EXTRA_FROM_SYMB).toString()
        val viewModel = ViewModelProvider(this).get(CoinViewModel::class.java)
        viewModel.getDetailInfo(fSym = fSym).observe(this, Observer {
            tvPrice.text = it.price.toString()
            tvMinPrice.text = it.lowDay.toString()
            tvMaxPrice.text = it.highDay.toString()
            tvLastMarket.text = it.lastMarket
            tvLastUpdate.text = it.getGetForrrmatedTime()
            tvFromSymbol.text = it.fromSymbol
            tvToSymbol.text = it.toSymbol
            Picasso.get().load(it.getFullImageUrl()).into(ivLogoCoin)
        })

    }

    companion object {
        fun getNewIntent(context: Context, fSym: String) = Intent(context, CoinDetailActivity::class.java).putExtra(
            EXTRA_FROM_SYMB, fSym)

        const val EXTRA_FROM_SYMB = "fSym"
    }
}