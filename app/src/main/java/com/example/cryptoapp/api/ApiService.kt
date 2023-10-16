package com.example.cryptoapp.api

import com.example.cryptoapp.pojo.CoinInfoListOfData
import com.example.cryptoapp.pojo.CoinPriceInfoRowData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SIMBOL) tSym: String = CURRENCY
    ): Single<CoinInfoListOfData>

    @GET("pricemultifull")
    fun getFullPriceList(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "",
        @Query(QUERRY_PARAM_FROM_SIMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SIMBOLS) tSyms: String = CURRENCY
    ): Single<CoinPriceInfoRowData>

    companion object {
        private const val QUERY_PARAM_API_KEY = "apy_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SIMBOL = "tsym"
        private const val QUERRY_PARAM_FROM_SIMBOLS = "fsyms"
        private const val QUERY_PARAM_TO_SIMBOLS = "tsyms"

        private const val CURRENCY = "USD"
    }
}