package com.k1ch.aqb.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.k1ch.aqb.network.AnimeQuote
import com.k1ch.aqb.network.QuoteBookApi
import kotlinx.coroutines.launch

class QuoteBookViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()


    val status: LiveData<String> = _status

    private val _quote = MutableLiveData<List<AnimeQuote>>()
    val quote: LiveData<List<AnimeQuote>> = _quote

    init {
        getQuoteBook()
    }

    private fun getQuoteBook() {
        viewModelScope.launch {
            try {
                _quote.value = QuoteBookApi.retrofitService.getQuote()
                _status.value = "Success: Mars properties retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"

            }
        }
    }
}