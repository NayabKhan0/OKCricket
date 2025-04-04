package com.android.okcricket.repository

import com.android.okcricket.data.model.MatchResponse
import com.android.okcricket.network.ApiService

class MatchRepository(private val apiService: ApiService) {
    suspend fun getFirstMatch(): Result<MatchResponse> = try {
        val response = apiService.getFirstMatch().execute()
        if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Exception("Empty body"))
        } else {
            Result.failure(Exception("${'$'}{response.code()}: ${'$'}{response.message()}"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getSecondMatch(): Result<MatchResponse> = try {
        val response = apiService.getSecondMatch().execute()
        if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Exception("Empty body"))
        } else {
            Result.failure(Exception("${'$'}{response.code()}: ${'$'}{response.message()}"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}