package com.android.okcricket.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.okcricket.data.model.MatchResponse
import com.android.okcricket.network.ResultState
import com.android.okcricket.repository.MatchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MatchViewModel(private val repository: MatchRepository) : ViewModel() {

    private val _firstMatchData = MutableLiveData<ResultState<MatchResponse>>()
    val firstMatchData: LiveData<ResultState<MatchResponse>> get() = _firstMatchData

    private val _secondMatchData = MutableLiveData<ResultState<MatchResponse>>()
    val secondMatchData: LiveData<ResultState<MatchResponse>> get() = _secondMatchData

    fun getFirstMatch() {
        _firstMatchData.value = ResultState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getFirstMatch()
            withContext(Dispatchers.Main) {
                result.onSuccess {
                    _firstMatchData.value = ResultState.Success(it)
                }.onFailure {
                    _firstMatchData.value = ResultState.Error(it.message ?: "Unknown error")
                }
            }
        }
    }

    fun getSecondMatch() {
        _secondMatchData.value = ResultState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getFirstMatch()
            withContext(Dispatchers.Main) {
                result.onSuccess {
                    _secondMatchData.value = ResultState.Success(it)
                }.onFailure {
                    _secondMatchData.value = ResultState.Error(it.message ?: "Unknown error")
                }
            }
        }
    }
}