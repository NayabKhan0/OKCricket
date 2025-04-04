package com.android.okcricket.network

import com.android.okcricket.data.model.MatchResponse
import com.android.okcricket.utils.BaseUrl
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(BaseUrl.FIRST_MATCH)
    fun getFirstMatch() : Call<MatchResponse>

    @GET(BaseUrl.SECOND_MATCH)
    fun getSecondMatch() : Call<MatchResponse>
}